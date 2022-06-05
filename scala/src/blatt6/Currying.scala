package blatt6

object Main {
  def main(args: Array[String]): Unit = {
    println(concatThree("1", "2", "3"))
    println(prefix("pre")("-Test-"))
    println(postfix("post")("-Test-"))
    println(preAndPostfix("-Test-"))
  }

  val concatThree: (String, String, String) => String = (x, y, z) => x + y + z

  def prefix(pre: String)(txt: String) = { concatThree(pre, txt, "") }
  def postfix(post: String)(txt: String) = { concatThree("", txt, post) }
  def preAndPostfix(txt: String) = { concatThree(">>>", txt, "<<<") }
}