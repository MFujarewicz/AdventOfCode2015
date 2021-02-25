package day5

import scala.io.Source


object NiceWords {

  def contains3vowels(str: String): Boolean = {
    val vowels = List('a', 'e', 'i', 'o', 'u')
    str.filter(vowels.contains(_)).length >= 3
  }


  def letter2inRow(str: String): Boolean = {
    str.foldLeft((0, '0'.charValue()))((acc, char) => {
      if (acc._2 == char) (acc._1 + 1, char) else (acc._1, char)
    })._1 > 0
  }

  def noBadStrings(str: String): Boolean = {
    val badStrings = List("ab", "cd", "pq", "xy")
    !badStrings.map(str.contains(_)).max
  }

  def isNice(str: String): Boolean = {
    contains3vowels(str) & letter2inRow(str) & noBadStrings(str)
  }

  def pair(str: String): Boolean = {
    var pairFound = false
    for (l<-0 until str.length-1){
      for(p<-l+2 until str.length-1){
        if(str(p) == str(l) & str(p+1) == str(l+1)) pairFound = true
      }
    }
    pairFound
  }

  def repeat(str: String): Boolean = {
    str.foldLeft(
      (0, '0'.charValue(), '0'.charValue())
    )(
      (acc, char) => {
        if (acc._2 == char) (acc._1 + 1, acc._3, char) else (acc._1, acc._3, char)
      })._1 > 0
  }

  def isNicer(str: String): Boolean = {
    pair(str) & repeat(str)
  }


  def main(args: Array[String]): Unit = {
    val words = Source.fromFile("src/main/scala/day5/input.txt").getLines.toList
    println(words.map(x => if (isNice(x)) 1 else 0).sum)
    println(words.map(x => if (isNicer(x)) 1 else 0).sum)
  }
}
