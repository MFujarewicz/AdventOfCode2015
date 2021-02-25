package day4

import java.security.MessageDigest
import java.io._


object Md5test {
  val salt = "iwrupvqb"

  def md5(text: String): String = {
    java.security.MessageDigest.getInstance("MD5").digest(text.getBytes()).map(0xFF & _).map {
      "%02x".format(_)
    }.foldLeft("") {
      _ + _
    }
  }

  def main(args: Array[String]): Unit = {

    var number = 1
    var hash = md5(salt + number)
    var i = 0
    var first5 = "99999"
    while (first5 != "000000") {
      i = i + 1
      first5 = md5(salt + i).reverse.substring(26).reverse.mkString
    }
    println("ZNALEZIONO!")
    println(i)


    val pw = new PrintWriter(new File("src/main/scala/day4/6hash.txt" ))
    pw.write(i.toString)
    pw.close
  }
}
