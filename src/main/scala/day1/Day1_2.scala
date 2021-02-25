package day1

import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Day1_2 {


  def main(args: Array[String]): Unit = {
    val up = '('
    val down = ')'

    val chars = Source.fromFile("src/main/scala/day1/puzzle1.txt").getLines.mkString

    val charsNumbers = chars.map(c => if (c == up) 1 else -1)

    var currentFloor = 0
    breakable {
      for (i <- charsNumbers.indices) {
        currentFloor = currentFloor + charsNumbers(i)
        if (currentFloor < 0) {
          println(i + 1)
          break
        }
      }
    }
  }
}
