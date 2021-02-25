package day3

import scala.io.Source


object Santa {
  val up = '^'
  val down = 'v'
  val left = '<'
  val right = '>'

  def main(args: Array[String]): Unit = {
    val moves = Source.fromFile("src/main/scala/day3/moves.txt").getLines.mkString
    var position = (0, 0)
    var position_log  = List(position)

    for (i <- moves.iterator) {
      if (i == right) position = (position._1 + 1, position._2)
      if (i == left) position = (position._1 - 1, position._2)
      if (i == up) position = (position._1, position._2 + 1)
      if (i == down) position = (position._1, position._2 - 1)
      position_log = position_log.appended(position)
    }
//    position_log.foreach(println)
    println(position_log.toSet.size)
  }
}
