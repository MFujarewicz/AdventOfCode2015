package day6
import org.scalatest.FunSuite

class LightsTest extends FunSuite {
  test("getLightNumber") {
    assert(Lights.getLightNumber("toggle 461,550 through 564,900") == ((461, 550),(564, 900)))
    assert(Lights.getLightNumber("toggle 41,550 through 564,900") == ((41, 550),(564, 900)))
    assert(Lights.getLightNumber("turn off 387,19 through 720,700") == ((387, 19),(720, 700)))
    assert(Lights.getLightNumber("turn on 390,706 through 884,72") == ((390, 706),(884, 72)))
  }
}
