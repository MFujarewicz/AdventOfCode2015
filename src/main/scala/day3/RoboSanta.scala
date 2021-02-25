package day3

import scala.io.Source


object RoboSanta {
  val up = '^'
  val down = 'v'
  val left = '<'
  val right = '>'

  def main(args: Array[String]): Unit = {
    val moves = Source.fromFile("src/main/scala/day3/moves.txt").getLines.mkString
    var santaPosition = (0, 0)
    var robotPosition = (0, 0)
    var position_log = List(santaPosition)

    for (x <- 0 until moves.length) {
      val i = moves(x)
      if (x % 2 == 0) {
        if (i == right) santaPosition = (santaPosition._1 + 1, santaPosition._2)
        if (i == left) santaPosition = (santaPosition._1 - 1, santaPosition._2)
        if (i == up) santaPosition = (santaPosition._1, santaPosition._2 + 1)
        if (i == down) santaPosition = (santaPosition._1, santaPosition._2 - 1)
        position_log = position_log.appended(santaPosition)
      }
      else {
        if (i == right) robotPosition = (robotPosition._1 + 1, robotPosition._2)
        if (i == left) robotPosition = (robotPosition._1 - 1, robotPosition._2)
        if (i == up) robotPosition = (robotPosition._1, robotPosition._2 + 1)
        if (i == down) robotPosition = (robotPosition._1, robotPosition._2 - 1)
        position_log = position_log.appended(robotPosition)
      }
    }
    //    position_log.foreach(println)
    println(position_log.toSet.size)
  }
}
