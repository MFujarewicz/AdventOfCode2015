package day11

object Password {
  def contains3straightLetters(p: IndexedSeq[Char]): Boolean = {

    var i = 0
    var found = false
    while (i < p.length - 3 && !found) {
      found = p(i) + 1 == p(i + 1) && p(i) + 2 == p(i + 2)

      i += 1
    }
    found
  }

  def contains2doubleLetters(p: IndexedSeq[Char]): Boolean = {
    var found = 0
    var i = 0
    while (i < p.length - 1 && found < 2) {
      if (p(i) == p(i + 1)) {
        found += 1
        i += 1
      }
      i += 1
    }

    if (found == 2) true else false
  }

  def doesNotContainIOL(p: IndexedSeq[Char]): Boolean = {
    !(p.contains('i') || p.contains('o') || p.contains('l'))
  }

  def increment(p: String): String = {
    var rightBound = p.length - 1

    var l = rightBound
    while (p(l) == 'z') {
      l -= 1
    }

    p.substring(0, l) + (p.charAt(l)+1).toChar + "a".repeat(rightBound-l)

  }

  def main(args: Array[String]): Unit = {
    val currentPassword = "vzbxxyzz"

    var w = increment(currentPassword)


    while (!(doesNotContainIOL(w) && contains2doubleLetters(w) && contains3straightLetters(w))) {
      w = increment(w)
    }
    println(w)

  }
}
