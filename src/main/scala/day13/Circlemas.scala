package day13

import scala.io.Source

object Circlemas {
  def main(args: Array[String]): Unit = {


    val source = Source.fromFile("src/main/scala/day13/input.txt")
    val input = source.getLines().toList
    source.close

    var stats: Map[(String, String), Int] = Map()

    val data = input.map(s => s.substring(0, s.length - 1))
      .map(_.split(" "))
      .map(x => (x(0), x(10), {
        if (x(2).equals("gain"))
          x(3).toInt
        else
          -x(3).toInt
      }))

    data.foreach(x => stats += ((x._1, x._2) -> x._3))

    val best1 = findBestScore(stats)
    println(best1)

    for(name <- stats.keys.map(_._1).toList.distinct){
      stats += (("Me", name) -> 0)
      stats += ((name, "Me") -> 0)
    }
    val best2 = findBestScore(stats)
    println(best2)
  }
  def findBestScore(stats:Map[(String, String), Int]): Int = {
    val names = stats.keys.map(_._1).toSet.toList
    val tables = names.permutations.filter(_.head == names.head)

    tables.map(t => {
      var score = 0
      for (i <- t.indices){
        score = score + stats(t(i), t((i+1)%names.size))
        score = score + stats(t(i), t((i+names.size-1)%names.size))
      }
      score
    }).max

  }
}
