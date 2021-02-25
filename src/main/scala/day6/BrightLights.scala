package day6

import scala.io.Source


object BrightLights {


  var lights = Array.ofDim[Int](1000, 1000)

  def doInstruction(str: String) = {
    if (str.contains("turn on")) turnOn(getLightNumber(str))
    if (str.contains("turn off")) turnOff(getLightNumber(str))
    if (str.contains("toggle")) toggle(getLightNumber(str))
  }

  def turnOff(tuple: ((Int, Int), (Int, Int))) = {
    for (i <- tuple._1._1 to tuple._2._1) {
      for (j <- tuple._1._2 to tuple._2._2) {
        lights(i)(j) = lights(i)(j) - 1
        if (lights(i)(j) < 0) lights(i)(j) = 0
      }
    }
  }

  def turnOn(tuple: ((Int, Int), (Int, Int))) = {
    for (i <- tuple._1._1 to tuple._2._1) {
      for (j <- tuple._1._2 to tuple._2._2) {
        lights(i)(j) = lights(i)(j) + 1
      }
    }
  }

  def toggle(tuple: ((Int, Int), (Int, Int))) = {
    for (i <- tuple._1._1 to tuple._2._1) {
      for (j <- tuple._1._2 to tuple._2._2) {
        lights(i)(j) = lights(i)(j) + 2
      }
    }
  }


  def getLightNumber(str: String): ((Int, Int), (Int, Int)) = {
    val numbers = str.filter(c => c.isDigit | c == ',' | c == ' ').split(",| ").filter(!_.isBlank).map(_.toInt)
    ((numbers(0), numbers(1)), (numbers(2), numbers(3)))
  }

  def main(args: Array[String]): Unit = {
    val instructions = Source.fromFile("src/main/scala/day6/input.txt").getLines.toList
//    instructions.foreach(println)

    instructions.foreach(doInstruction(_))
    println(lights.map(_.sum).sum)
   }
}
