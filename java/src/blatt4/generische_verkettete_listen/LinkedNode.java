package blatt4.generische_verkettete_listen;

public class LinkedNode<E extends Comparable<E>> {
    private class Node<E extends Comparable<E>> {
        private E item;
        private Node<E> nextNode;

        private Node() {
            this(null, null);
        }

        private Node(E element) {
            this(element, null);
        }

        private Node(E element, Node<E> next) {
            item = element;
            nextNode = next;
        }

        public E getElement( ) {
            return item;
        }
        public Node<E> getNextNode( ) {
            return nextNode;
        }
        public void setElement (E element) {
            this.item = element;
        }
        public void setNextNode(Node<E> Node) {
            this.nextNode = Node;
        }
    }

    private Node<E> _root;

    public LinkedNode() {
        this._root = null;
    }

    private Node getLastNode() {
        Node lastNode = this._root;
        while(lastNode.getNextNode() != null) {
            lastNode = lastNode.getNextNode();
        }
        return lastNode;
    }

    public void insert(E item) {
        if(this._root == null) {
            this._root = new Node<>(item);
        } else {
            getLastNode().setNextNode(new Node(item));
        }
    }

    public boolean contains(E item) {
        Node node = this._root;
        while(node != null) {
            if(node.getElement().equals(item)) {
                return true;
            }
            node = node.getNextNode();
        }
        return false;
    }

    public int getLength() {
        Node node = this._root;
        int c = 0;
        while(node != null) {
            node = node.getNextNode();
            c++;
        }
        return c;
    }

    public String toString() {
        if(this._root == null) {
            return "[]";
        }

        Node currentNode = this._root;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while(currentNode != null) {
            sb.append(currentNode.getElement().toString());

            currentNode = currentNode.getNextNode();
            if(currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        int l = getLength();
        sb.append(" (" + l + " element" + (l == 1 ? "" : "s") + " in list)");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedNode<String> liste = new LinkedNode<>();
        liste.insert("Test1");
        liste.insert("Test2");
        liste.insert("Test4");
        liste.insert("Test7");

        System.out.println(liste);
        System.out.println(liste.contains("Test1") ? "Ja" : "Nein");
        System.out.println(liste.contains("Test2") ? "Ja" : "Nein");
        System.out.println(liste.contains("Test3") ? "Ja" : "Nein");
    }
}