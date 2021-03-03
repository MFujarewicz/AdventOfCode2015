package day14

import scala.io.Source

object Reindeerer {


  def main(args: Array[String]): Unit = {
    val totalTime = 2503

    val source = Source.fromFile("src/main/scala/day14/input.txt")
    val input = source.getLines().toList
    source.close

    val reindeers = input.map(_.split(" ")).map(x => new Reindeer(x(3).toInt, x(6).toInt, x(13).toInt))
    val reindeerDistances = reindeers.map(_.calculateDistance(totalTime))
    println(reindeerDistances.max)

    //Part two

    for(i <- 1 to totalTime){
      val reindeersWithDistances = reindeers.map(r => (r, r.calculateDistance(i)))
      val max = reindeersWithDistances.map(x => x._2).max
      reindeersWithDistances.filter(x => x._2 == max).foreach(x => x._1.incScore())
    }
    println(reindeers.map(_.score).max)



  }

  class Reindeer(val speed: Int, val runTime: Int, val restTime: Int) {
    def calculateDistance(seconds: Int): Int = {
      val fullRunRestCycles = seconds / (runTime + restTime) //cast to int rounds down
      val fullRunRestCyclesDistance = fullRunRestCycles*speed*runTime
      val remainingTime = seconds-fullRunRestCycles*(runTime+restTime)
      val remainingTimeDistance = Math.min(runTime, remainingTime)*speed
      fullRunRestCyclesDistance+remainingTimeDistance
    }
    var score = 0
    def incScore(): Unit ={
      score = score + 1
    }
  }


}


