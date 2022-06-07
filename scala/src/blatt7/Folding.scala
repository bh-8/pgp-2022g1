package blatt7

object Main {
  def charCount(list: List[String]): Int = {
    list.foldLeft(0) {
      case(count, str) => count + str.foldLeft(0) {
        case(count, ch) => count + 1
      }
    }
  }

  def length[A](list: List[A]): Int = {
    list.foldLeft(0) {
      case(count, i) => count + 1
    }
  }

  def reverse[A](list: List[A]): List[A] = {
    list.foldLeft(List[A]()) {
      (x, y) => y :: x
    }
  }

  def concat[A](list1: List[A], list2: List[A]): List[A] = {
    list1.foldLeft(list2) {
      case (l1, l2) => l2 :: l1
    }
  }

  /*
  def enumerate[A](list: List[A]): List[(Int, A)] = {

  }
  */

  def main(args: Array[String]): Unit = {
    val l0: List[Int] = List()
    val l1: List[Int] = List(1, 2, 3, 4, 5, 6)
    val l2: List[Int] = List(7, 8, 9, 10, 11)

    println(reverse(l0))
    println(reverse(l1))
    println(reverse(l2))
    println(length(l0))
    println(length(l1))
    println(length(l2))
    println(concat(l1, l2))
    //println(enumerate(l2))
    //println(enumerate(l0))
    println(charCount(List("Lorem", "ipsum", "dolor", "sit", "amet")))
  }
}
