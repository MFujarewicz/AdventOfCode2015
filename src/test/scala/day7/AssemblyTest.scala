package day7
import org.scalatest.FunSuite

class AssemblyTest extends FunSuite {
  println(Assembly.parse("x OR 1 -> e"))
  println(Assembly.parse("1 -> e"))
}
