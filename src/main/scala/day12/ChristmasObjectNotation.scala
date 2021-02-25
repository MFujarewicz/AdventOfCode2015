package day12

import scala.io.Source

object ChristmasObjectNotation {

  def findRedObjects(str: String) = {

    val redVal = """:"red""""

    var lastObjEnd = -1

    while(str.substring(lastObjEnd+1).contains(redVal)){
      val currStr = str.substring(lastObjEnd+1)
      val redIndex = currStr.indexOf(redVal)
      val objStart = {
        var i = redIndex
        while (currStr(i) != '{') i += 1
        i
      }
      val objEnd = {
        var i = redIndex
        var bracketCount = 1
        while (bracketCount > 0) {
          i += 1
        }
        i
      }

    }
  }

  def main(args: Array[String]): Unit = {
    val list = Source.fromFile("src/main/scala/day12/input.txt").getLines.mkString

    val  sum = list.split(",").map(s => s.filter(c => c.isDigit || c == '-')).filter(_.nonEmpty).map(_.toInt).sum

    val redSum = findRedObjects(list)


    println(sum)
  }
}
