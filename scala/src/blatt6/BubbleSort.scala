package blatt6

object Main {
  def printArr(arr: Array[Int]): Unit = {
    arr.foreach(println)
  }

  def swap(arr: Array[Int], i1: Int, i2: Int): Array[Int] = {
    val tmp = arr(i1)
    arr(i1) = arr(i2)
    arr(i2) = tmp
    arr
  }

  def _bubbleSort2(arr: Array[Int], i: Int, nMax: Int): Array[Int] = {
    if(i == nMax) {
      arr
    } else {
      if(arr(i) > arr(i + 1)) {
        swap(arr, i, i + 1)
      }
      _bubbleSort2(arr, i + 1, nMax)
    }
  }

  def _bubbleSort1(arr: Array[Int], n: Int): Array[Int] = {
    if(n == 0) {
      arr
    } else {
      _bubbleSort2(arr, 0, n)
      _bubbleSort1(arr, n - 1)
    }
  }

  def bubbleSort(arr: Array[Int]): Array[Int] = {
    _bubbleSort1(arr, arr.length - 1)
  }

  def main(args: Array[String]): Unit = {
    var arr = Array(9, 5, 2, 7, 1, 8, 4, 3, 6)
    printArr(arr)
    bubbleSort(arr)
    println("Sorted:");
    printArr(arr)
  }
}
