package day18

import scala.io.Source

object GameOfLights {
  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("src/main/scala/day18/input.txt")
    val input = source.getLines().toArray
    source.close

    val inputDimensions = (input.head.length, input.length)

    val inputArray = Array.ofDim[Int](inputDimensions._1, inputDimensions._2)

    var array = inputArray

    val intInput = input.map(_.map(c => if (c == '.') 0 else 1))
    for (x <- 0 to 99; y <- 0 to 99) {
      array(x)(y) = intInput(x)(y)
    }

    for (_ <- 1 to 100) {
      val nextArray = Array.ofDim[Int](inputDimensions._1, inputDimensions._2)
      for (x <- 0 to 99; y <- 0 to 99) {
        val onNeighbours = countOnNeighbors(array, x, y)

        if (array(x)(y) == 1) {
          if (onNeighbours == 2 || onNeighbours == 3) nextArray(x)(y) = 1 else nextArray(x)(y) = 0
        }

        if (array(x)(y) == 0) {
          if (onNeighbours == 3) nextArray(x)(y) = 1 else nextArray(x)(y) = 0
        }
      }
      array = nextArray
    }

    println(array.map(_.sum).sum)

    //part 2

    array = inputArray
    setCornersOn(array)

    for (_ <- 1 to 100) {
      val nextArray = Array.ofDim[Int](inputDimensions._1, inputDimensions._2)
      for (x <- 0 to 99; y <- 0 to 99) {
        val onNeighbours = countOnNeighbors(array, x, y)

        if (array(x)(y) == 1) {
          if (onNeighbours == 2 || onNeighbours == 3) nextArray(x)(y) = 1 else nextArray(x)(y) = 0
        }

        if (array(x)(y) == 0) {
          if (onNeighbours == 3) nextArray(x)(y) = 1 else nextArray(x)(y) = 0
        }
      }
      array = nextArray
      setCornersOn(array)
    }
    println(array.map(_.sum).sum)

  }

  def countOnNeighbors(array: Array[Array[Int]], x: Int, y: Int): Int = {
    val neighbors =
      for (i <- x - 1 to x + 1;
           j <- y - 1 to y + 1
           if !(i == x && j == y) &&
             i >= 0 &&
             j >= 0 &&
             i < array.head.length &&
             j < array.length)
        yield array(i)(j)
    neighbors.sum
  }

  def setCornersOn(array: Array[Array[Int]]):Unit = {
    val x = array.length - 1
    val y = array.head.length - 1
    array(0)(0) = 1
    array(0)(y) = 1
    array(x)(0) = 1
    array(x)(y) = 1

  }

}