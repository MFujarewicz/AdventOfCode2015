package day8

import scala.collection.mutable.HashMap
import scala.io.Source


object CodeLength {

  def main(args: Array[String]): Unit = {
    val list = Source.fromFile("src/main/scala/day8/input.txt").getLines.toList

    val codeLength = list.map(_.length).sum

    val withoutQuotes = list.map(s => s.substring(1, s.length - 1))
    val withoutBaskSlashEscape = withoutQuotes.map(s => s.replaceAll("""\\\\""", "0"))
    val withoutQuoteEscape = withoutBaskSlashEscape.map(s => s.replaceAll("""\\\"""", "0"))
    val withoutHex = withoutQuoteEscape.map(s => s.replaceAll("""\\x[0-9a-z][0-9a-z]""", "1"))

    println(codeLength - withoutHex.map(_.length).sum)

    val encoded = list.map(s => s.replaceAll("""\\""", "aa"))
      .map(s => s.replaceAll("\"", "aa"))
      .map(s => "\"" + s + "\"")

    println(encoded.map(_.length).sum - codeLength)
  }


}
