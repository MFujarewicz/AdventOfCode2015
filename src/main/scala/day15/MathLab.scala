package day15

import scala.io.Source

object MathLab {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("src/main/scala/day15/input.txt")
    val input = source.getLines().toList
    source.close

    val ingredients = input.map(_.filter(_ != ','))
      .map(_.split(" "))
      .map(x => (x(2).toInt, x(4).toInt, x(6).toInt, x(8).toInt, x(10).toInt))


    println(ingredients)


    var cookies = List()
    var maxScore = 0
    val calorieTarget = 500
    var maxScoreCalories = 0
    for (a <- 0 to 100) {
      for (b <- 0 to 100 - a) {
        for (c <- 0 to 100 - a - b) {
          val d = 100 - a - b - c
          val capacity = a * ingredients(0)._1 + b * ingredients(1)._1 + c * ingredients(2)._1 + d * ingredients(3)._1
          val durability = a * ingredients(0)._2 + b * ingredients(1)._2 + c * ingredients(2)._2 + d * ingredients(3)._2
          val flavor = a * ingredients(0)._3 + b * ingredients(1)._3 + c * ingredients(2)._3 + d * ingredients(3)._3
          val texture = a * ingredients(0)._4 + b * ingredients(1)._4 + c * ingredients(2)._4 + d * ingredients(3)._4
          val calories = a * ingredients(0)._5 + b * ingredients(1)._5 + c * ingredients(2)._5 + d * ingredients(3)._5
          val score = cookieScore(capacity, durability, flavor, texture)
          maxScore = math.max(score, maxScore)
          if (calories==calorieTarget) {
            maxScoreCalories = Math.max(maxScoreCalories, score)
          }
        }

      }

    }

    println("max normal cookie: " + maxScore)
    println("max diet cookie: " + maxScoreCalories)
  }

  def cookieScore(capacity: Int, durability: Int, flavor: Int, texture: Int): Int = {
    math.max(capacity, 0) * math.max(durability, 0) * math.max(flavor, 0) * math.max(texture, 0)
  }


}
