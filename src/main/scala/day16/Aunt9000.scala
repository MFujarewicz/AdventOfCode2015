package day16

import scala.collection.mutable.ArrayBuffer
import scala.io.Source
import scala.util.control.Breaks.{break, breakable}

object Aunt9000 {
  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("src/main/scala/day16/input.txt")
    val input = source.getLines().toList
    source.close

    val sueAttributes = Map(
      "children" -> 3,
      "cats" -> 7,
      "samoyeds" -> 2,
      "pomeranians" -> 3,
      "akitas" -> 0,
      "vizslas" -> 0,
      "goldfish" -> 5,
      "trees" -> 3,
      "cars" -> 2,
      "perfumes" -> 1,
    )

    var suesBuffer = new ArrayBuffer[Map[String, Int]]
    for (s <- input) {
      val split = s.filter(c => !c.equals(',') && !c.equals(':')).split(" ")
      suesBuffer += Map(split(2) -> split(3).toInt, split(4) -> split(5).toInt, split(6) -> split(7).toInt)
    }

    val sues = suesBuffer.toArray

    breakable {
      for (i <- sues.indices) {
        val sue = sues(i)

        if (sue.keys.forall(k => sue(k) == sueAttributes(k))) {
          println(i + 1)
          break
        }
      }
    }
    //    part 2
    breakable {
      for (i <- sues.indices) {
        val sue = sues(i)

        if (sue.keys.forall(k => {
          if (k.equals("cats") || k.equals("trees")) {
            sue(k) > sueAttributes(k)
          }
          else if (k.equals("pomeranians") || k.equals("goldfish")) {
            sue(k) < sueAttributes(k)
          } else {
            sue(k) == sueAttributes(k)
          }
        })) {
          println(i + 1)
          break
        }
      }
    }
  }
}