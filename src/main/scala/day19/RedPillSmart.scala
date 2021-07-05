package day19

import scala.collection.mutable.ListBuffer
import scala.io.Source
//https://www.reddit.com/r/adventofcode/comments/3xflz8/day_19_solutions/
// user askalski pointed out that replacement rules denote context-free grammar
//this solution is using his reasoning

object RedPillSmart {
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

    val nonTerminals = replacements.map(_._1).distinct //Non terminals are characters on left side of rules


    val terminalsString = replacements.map(_._2)
      .map(_.replaceAll(nonTerminals.mkString("|"), ""))
      .filter(_.nonEmpty)
      .distinct
      .mkString("")

    val terminals = {for (i <- 0 to terminalsString.length - 2) yield {
      if (terminalsString(i).isUpper) {
        if (terminalsString(i + 1).isUpper)
          terminalsString(i)
        else
          terminalsString(i).toString + terminalsString(i + 1).toString
      }
    }}.distinct.toList.map(_.toString).filter(_ != "()")


    println(nonTerminals)
    println(terminals)


  }
}