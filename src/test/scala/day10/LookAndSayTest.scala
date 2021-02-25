package day10
import org.scalatest.FunSuite

class LookAndSayTest extends FunSuite {
  var word = "1"
  println(word)

  for (i <-  1 to 5){
    word = LookAndSay.lookAndSay(word)
    println(word)
  }
}
