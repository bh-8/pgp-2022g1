package blatt5;

object CharacterTree {
  def _print_tree_layer_chars(n: Int, c: Char): Unit = {
    if (n != 0) then {
      print(c);
      _print_tree_layer_chars(n - 1, c);
    }
  }

  def _print_tree_layer(n: Int, c: Char, originalHeight: Int): Unit = {
    if (n != 0) then {
      _print_tree_layer_chars(n - 1, ' ');
      _print_tree_layer_chars((originalHeight - n) * 2 + 1, c);
      print("\n");

      _print_tree_layer(n - 1, c, originalHeight);
    } else {
      _print_tree_layer_chars(originalHeight - 1, ' ');
      println('*');
    }
  }

  def print_tree_char(height: Int, char: Char): Unit = {
    _print_tree_layer(height, char, height);
  }

  def print_tree(height: Int): Unit = {
    print_tree_char(height, '*');
  }

  def main(args: Array[String]): Unit = {
    var foo: Int = 14;
    print_tree(foo);
    print_tree_char(foo, 'o');
  }
}

