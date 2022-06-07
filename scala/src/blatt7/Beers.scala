package blatt7

object Main {

  def flatten2(coolList: List[Any]): List[Any] = {
    flatten(coolList)
  }

  def flatten(coolList: List[Any]): List[Any] = coolList flatten {
    case i: List[_] => flatten(i)
    case e => List(e)
  }

  def main(Args: Array[String]): Unit = {
    val lager = List("Pale Lager", "Dark Lager")
    val pale_ale = List("India Pale Ale", "Amercian Pale Ale",
      "West Coast Pale Ale", "Island Pale Ale")
    val ales = List("Brown ale", "Scotch ale", pale_ale)
    val beers = List(ales, lager, "Pilsner")

    println(beers)
    println(flatten(beers))
  }
}