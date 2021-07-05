package day21

object Boss {
  def main(args: Array[String]): Unit = {

    val BOSS_HP = 104
    val BOSS_DAMAGE = 8
    val BOSS_ARMOR = 1

    val PLAYER_HP = 100

    val weapons = List(
      (8, 4, 0),
      (10, 5, 0),
      (25, 6, 0),
      (40, 7, 0),
      (74, 8, 0),
    )

    val armors = List(
      (0, 0, 0), //no armor
      (13, 0, 1),
      (31, 0, 2),
      (53, 0, 3),
      (75, 0, 4),
      (102, 0, 5)
    )

    val rings = List(
      (0, 0, 0), //no ring
      (25, 1, 0),
      (50, 2, 0),
      (100, 3, 0),
      (20, 0, 1),
      (40, 0, 2),
      (80, 0, 3),
    )

    val allRingConfigurations = (for (leftRing <- rings; rightRing <- rings; if leftRing != rightRing)
      yield (leftRing._1 + rightRing._1, leftRing._2 + rightRing._2, leftRing._3 + rightRing._3)
      ).appended((0, 0, 0))

    var lowestCostWin = 999
    var highestToLose = 0

    for (weapon <- weapons; armor <- armors; ring <- allRingConfigurations) {
      val cost = weapon._1 + armor._1 + ring._1
      val player_damage = weapon._2 + armor._2 + ring._2
      val player_armor = weapon._3 + armor._3 + ring._3

      if (fight(PLAYER_HP, player_damage, player_armor, BOSS_HP, BOSS_DAMAGE, BOSS_ARMOR) && cost < lowestCostWin) {
        lowestCostWin = cost
      }

      if (!fight(PLAYER_HP, player_damage, player_armor, BOSS_HP, BOSS_DAMAGE, BOSS_ARMOR) && cost > highestToLose) {
        highestToLose = cost
      }
    }

    println("least gold to win: " + lowestCostWin)
    println("highest gold to win: " + highestToLose)


  }

  //returns true if player won
  //returns false if boss won
  def fight(player_hp: Int, player_damage: Int, player_armor: Int,
            boss_hp: Int, boss_damage: Int, boss_armor: Int): Boolean = {
    val damageToBoss = math.max(player_damage - boss_armor, 1)
    val damageToPlayer = math.max(boss_damage - player_armor, 1)
    val turns_to_kill_player = math.ceil(player_hp.toFloat / damageToPlayer.toFloat)
    val turns_to_kill_boss = math.ceil(boss_hp.toFloat / damageToBoss.toFloat)

    if (turns_to_kill_boss <= turns_to_kill_player) true else false
  }
}