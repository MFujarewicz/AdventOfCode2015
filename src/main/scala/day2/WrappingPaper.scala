package day2

import scala.io.Source


object WrappingPaper {

  def paperNeeded(x: String) = {
    val dims = x.split("x").map(s => s.toInt)
    val s1 = dims(0) * dims(1)
    val s2 = dims(1) * dims(2)
    val s3 = dims(0) * dims(2)
    2 * (s1 + s2 + s3) + List(s1, s2, s3).min
  }

  def ribbonNeeded(x: String) = {
    val dims = x.split("x").map(s => s.toInt)
    val bow = dims.product
    val wrap =  2*(dims.sum-dims.max)
    bow + wrap
  }



  def main(args: Array[String]): Unit = {
    val dimensions = Source.fromFile("src/main/scala/day2/presents.txt").getLines.toList
    println(dimensions.map(paperNeeded(_)).sum)
    println(dimensions.map(ribbonNeeded(_)).sum)
  }
}
