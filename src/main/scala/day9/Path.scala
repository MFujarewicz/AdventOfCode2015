package day9

import scala.io.Source

object Path {

  def totalDistance(distances: Map[Set[String], Int], path:List[String]) = {
    path.foldLeft((0, ""))((acc, city) => {
      (distances.getOrElse(Set(acc._2, city), 0) + acc._1, city)
    })._1
  }

  def main(args: Array[String]): Unit = {
    val list = Source.fromFile("src/main/scala/day9/input.txt").getLines.toList

    val distances = list.map(_.split(" ")).map(_.filter(s => s != "to" && s != "=")).map(e => (Set(e(0), e(1)), e(2).toInt)).toMap

    val cities = distances.keys.flatMap(identity).toList

    val pathDistances = cities.permutations.map(p => (p, totalDistance(distances, p))).toList

    println(pathDistances.map(e => e._2).min)
    println(pathDistances.map(e => e._2).max)


  }
}
