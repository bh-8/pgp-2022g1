package blatt4.bintreetraversal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class BinaryTree<T> {
    private T _value;
    private BinaryTree<T> _left;
    private BinaryTree<T> _right;
    private BinaryTree<T> _parent;

    public BinaryTree(T value) {
        this._value = value;
    }

    public BinaryTree<T> getLeft() {
        return this._left;
    }

    public BinaryTree<T> getRight() {
        return this._right;
    }

    public BinaryTree<T> getParent() {
        return this._parent;
    }

    public BinaryTree<T> setLeft(BinaryTree<T> node) {
        this._left = node;
        node._parent = this;
        return node;
    }

    public BinaryTree<T> setRight(BinaryTree<T> node) {
        this._right = node;
        node._parent = this;
        return node;
    }

    public T getValue() {
        return this._value;
    }

    public T setValue(T value) {
        this._value = value;
        return value;
    }

    public Iterator<T> iterate(Iterable<T> iter) {
        return iter.iterator();
    }
}

class BinTreeTraversal {
    public static void main(String[] args) {
        /*
            Following is an usage example, creating a binary tree and printing out all values in the order of the given iterator
         */

        BinaryTree<Integer> root = new BinaryTree<Integer>(1);

        root.setLeft(new BinaryTree<Integer>(2));
        root.setRight(new BinaryTree<Integer>(3));

        // Your implementation should be able to perform a for each with the given syntax
        System.out.println("Inorder:");
        for (int item : new InorderIterable<Integer>(root)) {
            System.out.println(item);
        }
        System.out.println("Preorder:");
        for (int item : new PreorderIterable<Integer>(root)) {
            System.out.println(item);
        }
    }
}

class InorderIterable<T> implements Iterable<T> {
    BinaryTree<T> root;
    Iterator<T> iterator;

    public InorderIterable(BinaryTree<T> root) {
        this.root = root;

        this.iterator = new Iterator<T>() {
            BinaryTree<T> next = root;
            {
                //Go as far left as possible
                while(next.getLeft() != null) {
                    next = next.getLeft();
                }
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                assert(hasNext());

                T currentValue = next.getValue();

                //if there is an element on the right
                if(next.getRight() != null) {
                    next = next.getRight();

                    //go down the right tree
                    while(next.getLeft() != null) {
                        next = next.getLeft();
                    }
                    return currentValue;
                }

                while(true) {
                    //if no parents
                    if(next.getParent() == null) {
                        next = null;
                        return currentValue;
                    }

                    //go up
                    if(next.getParent().getLeft() == next) {
                        next = next.getParent();
                        return currentValue;
                    }

                    next = next.getParent();
                }
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        assert(this.iterator != null);
        return this.iterator;
    }
}

class PreorderIterable<T> implements Iterable<T> {
    BinaryTree<T> root;
    Iterator<T> iterator;

    public PreorderIterable(BinaryTree<T> root) {
        this.root = root;
        this.iterator = new Iterator<T>() {
            private List<T> order;
            private int index;
            {
                this.order = new ArrayList<>();
                this.index = 0;
                this.preorder(root);
            }

            private void preorder(BinaryTree<T> tree) {
                this.order.add(tree.getValue());
                if(tree.getLeft() != null) {
                    preorder(tree.getLeft());
                }
                if(tree.getRight() != null) {
                    preorder(tree.getRight());
                }
            }
            @Override
            public boolean hasNext() {
                return this.index < this.order.size();
            }

            @Override
            public T next() {
                assert(hasNext());
                return this.order.get(index++);
            }
        };
    }

    @Override
    public Iterator<T> iterator() {
        assert(this.iterator != null);
        return this.iterator;
    }
}