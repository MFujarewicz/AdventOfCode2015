package day10

import scala.collection.mutable.ListBuffer

object LookAndSay {

  def lookAndSay(str: String) = {
    val sepAt = new ListBuffer[(Int, Int)]()
    var last = -1
    for (i <- 0 until str.length - 1) {
      if (str(i) != str(i + 1)) {
        sepAt.append((last + 1, i + 1))
        last = i
      }
    }
    sepAt.append((last + 1, str.length))

    sepAt.map(range => {
      "" + (range._2 - range._1) + str(range._1)
    }).mkString

  }


  def main(args: Array[String]): Unit = {
    val input = "1113122113"

    var word = input
    for (i <- 1.to(50)) {
      word = lookAndSay(word)
      if (i == 40 || i == 50){
        println(word.length)
      }
    }
  }
}
