package day7

import scala.collection.mutable.HashMap
import scala.io.Source


object Assembly {


  var variables: HashMap[String, Char] = HashMap()

  def doInstruction(str: String) = {

    val parsed = parse(str)
    if (parsed.length == 2) {
      if (valueAvailable(parsed(0))) {
        val a = getValue(parsed(0))
        val key = parsed(1)
        if (str.contains("NOT")) variables(key) = Not(a)
        else variables(key) = a
      }
    }
    else {
      if (valueAvailable(parsed(0)) || valueAvailable(parsed(1))) {
        //        println(str + " " + valueAvailable(parsed(0)) + " " +valueAvailable(parsed(1)))
      }

      if (valueAvailable(parsed(0)) && valueAvailable(parsed(1))) {

        val a = getValue(parsed(0))
        val b = getValue(parsed(1))
        val key = parsed(2)

        if (str.contains("AND")) variables(key) = And(a, b)
        else if (str.contains("OR")) variables(key) = Or(a, b)
        else if (str.contains("LSHIFT")) variables(key) = Lshift(a, b)
        else if (str.contains("RSHIFT")) variables(key) = Rshift(a, b)
      }
    }
  }


  def valueAvailable(str: String): Boolean = {
    if (str.forall(_.isDigit)) true
    else if (variables.contains(str)) true
    else false
  }

  def getValue(str: String): Char = {
    if (str.forall(_.isDigit)) str.toInt.toChar
    else variables(str)
  }

  def And(x: Char, y: Char) = {
    (x & y).toChar
  }

  def Or(x: Char, y: Char) = {
    (x | y).toChar
  }

  def Lshift(x: Char, y: Char) = {
    (x << y).toChar
  }


  def Rshift(x: Char, y: Char) = {
    (x >> y).toChar
  }

  def Not(x: Char) = {
    (~x).toChar
  }


  def parse(str: String) = {
    str.split(" ").toList.filter(w => w == w.toLowerCase && w.forall(_.isLetterOrDigit))
  }

  def getLightNumber(str: String): ((Int, Int), (Int, Int)) = {
    val numbers = str.filter(c => c.isDigit | c == ',' | c == ' ').split(",| ").filter(!_.isBlank).map(_.toInt)
    ((numbers(0), numbers(1)), (numbers(2), numbers(3)))
  }

  def main(args: Array[String]): Unit = {
    val instructions = Source.fromFile("src/main/scala/day7/inputOverride.txt").getLines.toList

    while (!valueAvailable("a")){
      instructions.foreach(doInstruction(_))
    }

    println(variables.map(x => (x._1, x._2.toInt)))
    println(variables("a").toInt)
  }
}
