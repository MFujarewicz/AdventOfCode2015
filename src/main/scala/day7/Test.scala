package day7

import scala.collection.mutable.HashMap

object Test {
  def main(args: Array[String]): Unit = {
    //    var hashMap: HashMap[String, Int] = HashMap(("aa", 1))
    //    println(hashMap("aa"))
    //    hashMap("bb") = 2
    //    println(hashMap("bb"))
    //    hashMap("bb") = 3
    //    println(hashMap("bb"))
    //    println(hashMap.getOrElse("cc", 0))

    val x:Char = 123.toChar
    val y:Char = 456.toChar
    val d:Char = (x & y).toChar
    val e = (x | y).toChar
    val f = (x << 2).toChar
    val g = (y >> 2).toChar
    val h = (~x).toChar
    val i = (~y).toChar

    println("d: " + d.toInt)
    println("e: " + e.toInt)
    println("f: " + f.toInt)
    println("g: " + g.toInt)
    println("h: " + h.toInt)
    println("i: " + i.toInt)

    val a = List(1, 2, 3)
    println(65536.toChar.toInt)

    if (null != null) println("dsadasdsad")
  }
}
