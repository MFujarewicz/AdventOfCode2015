package day20

import scala.util.control.Breaks._


object PresentsFactor {
  def main(args: Array[String]): Unit = {

    val threshold = 34000000 //puzzle input
    val ELF_COUNT = 1000000 //acts as upper search bound
    val houses = Array.fill(ELF_COUNT + 1) {0} //array index corresponds to house number exactly


    breakable {
      for {i <- 1 to ELF_COUNT} {
        for {j <- i to ELF_COUNT by i} {
          houses(j) += i * 10
        }
        if (houses(i) >= threshold) {
          println(i)
          break
        }
      }
    }

    //part two
    houses.indices.foreach(x => houses(x) = 0)


    breakable {
      for {i <- 1 to ELF_COUNT} {
        for {j <- i to (if (i * 50 < ELF_COUNT) i * 50 else ELF_COUNT) by i} {
          houses(j) += i * 11
        }
        if (houses(i) >= threshold) {
          println(i)
          break
        }
      }
    }
  }
}