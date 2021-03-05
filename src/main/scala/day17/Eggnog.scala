package day17

import scala.io.Source

object Eggnog {
  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("src/main/scala/day17/input.txt")
    val input = source.getLines().toList
    source.close

    val containers = input.map(_.toInt)
    val eggnog = 150
    println(containers)
    var counter = 0
    var minNumberOfContainers = containers.length
    var countOfminimumContainerCombinations = 0

    for (i <- 0 until scala.math.pow(2, containers.size).toInt) {

      val binaryString = i.toBinaryString.reverse.padTo(containers.size, '0').reverse.toList.map(_.toString.toInt)

      var volume = 0
      for (j <- binaryString.indices) {
        volume += containers(j) * binaryString(j)
      }

      if (volume == eggnog) {
        counter += 1
        if (binaryString.sum == minNumberOfContainers) {
          countOfminimumContainerCombinations += 1
        }
        if (binaryString.sum < minNumberOfContainers) {
          minNumberOfContainers = binaryString.sum
          countOfminimumContainerCombinations = 1
        }
      }

    }
    println(counter)
    println(countOfminimumContainerCombinations)
  }
}