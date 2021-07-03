package day19

import scala.collection.mutable.ListBuffer
import scala.io.Source

object RedPill {
  def main(args: Array[String]): Unit = {

    val source = Source.fromFile("src/main/scala/day19/input.txt")
    val input = source.getLines().toList
    source.close
    //    input.foreach(println)

    val protoMolecule = input.last
    val replacements = input.slice(0, input.size - 2)
      .map(s => {
        val t = s.split(" => ")
        (t(0), t(1))
      })

    val allTransformedStrings = generateAllTransformations(protoMolecule, replacements)

    println(allTransformedStrings.distinct.size)
    println(protoMolecule.size)
    println()


    //part 2
    val reverseReplacements = replacements.map(_.swap)


    var stepCount = 0

    var molecules = List(protoMolecule)
    while (!molecules.contains("e")) {
      molecules = molecules.flatMap(generateAllTransformations(_, reverseReplacements))
        .distinct
        .sortBy(_.length).slice(0, 100)
        .distinct
      stepCount += 1
    }
    println("It takes " + stepCount + " steps")

  }

  def generateAllTransformations(string: String, replacements: List[(String, String)]): List[String] = {
    replacements.flatMap(t => {
      val mi = t._1.r.findAllIn(string)
      if (mi.nonEmpty) {
        val lb = new ListBuffer[Int]
        lb.append(mi.start)
        while (mi.hasNext) {
          mi.next()
          lb.append(mi.start)
        }
        lb.toList.map(i => {
          string.substring(0, i) + string.substring(i).replaceFirst(t._1, t._2)
        })
      }
      else List()
    })
  }
}