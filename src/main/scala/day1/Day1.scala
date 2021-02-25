package day1

import scala.io.Source

object Day1 {


  def main(args: Array[String]): Unit = {
    val up = '('
    val down = ')'

    val chars = Source.fromFile("src/main/scala/day1/puzzle1.txt").getLines.mkString

    val charNumbers = chars.map(x => if (x == up) 1 else -1)

    val finalFloor = charNumbers.fold(0)(_ + _)

    println(finalFloor)

    val upCount = chars.filter(x => x == up)
    val downCount = chars.filter(x => x == down)
    println(upCount.length - downCount.length)
  }
}
