package day12

import scala.io.Source

object RealMeaningOfChristmas {
  def main(args: Array[String]): Unit = {

    sealed trait Foo
    val list = Source.fromFile("src/main/scala/day12/input.txt").mkString
    println(list)

  }
}
