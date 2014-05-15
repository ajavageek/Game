package ch.frankel.game.dice

import java.util.Random
import java.security.SecureRandom

/**
 * A die, pure and simple.
 *
 * @param sides Number of sides of the die
 * @param random Randomness generator
 */
class Die (val sides:Int)(implicit random:Random) extends Rollable[Int] {

  override def roll:(Die, Int) = (this, random.nextInt(sides) + 1)
}

object SecureDie {

  /**
   * Use this generator by default if none is passed to the constructor.
   */
  implicit val random = new SecureRandom
}
