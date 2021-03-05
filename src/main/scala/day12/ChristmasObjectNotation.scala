package day12

import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object ChristmasObjectNotation {

  def findRedObjects(str: String): Int = {

    val redVal = """:"red""""
    val strBuilder = new StringBuilder(str)

    while (strBuilder.mkString.contains(redVal)) {
      val redIndex = strBuilder.indexOf(redVal)

      var bracketCount = 0
      var leftBracket = 0
      breakable(for (i <- redIndex to 0 by -1) {
        if (strBuilder(i) == '}') {
          bracketCount += 1
        }
        if (strBuilder(i) == '{') {

          if (bracketCount == 0) {
            leftBracket = i

            break()
          }
          bracketCount -= 1
        }
      })

      var rightBracket = 0
      breakable(for (i <- redIndex until strBuilder.length) {
        if (strBuilder(i) == '{') {

          bracketCount += 1
        }
        if (strBuilder(i) == '}') {

          if (bracketCount == 0) {
            rightBracket = i
            break()
          }
          bracketCount -= 1
        }
      })
      //      println(strBuilder.subSequence(leftBracket, rightBracket+1))
      strBuilder.delete(leftBracket, rightBracket + 1)
    }


    strBuilder.toString.split(",").map(s => s.filter(c => c.isDigit || c == '-')).filter(_.nonEmpty).map(_.toInt).sum
  }

  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("src/main/scala/day12/input.txt")
    val list = source.getLines.mkString
    source.close()

    val sum = list.split(",").map(s => s.filter(c => c.isDigit || c == '-')).filter(_.nonEmpty).map(_.toInt).sum

    val redSum = findRedObjects(list)

    println(sum)
    println(redSum)
  }
}
