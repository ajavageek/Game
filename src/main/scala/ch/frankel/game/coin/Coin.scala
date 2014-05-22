package ch.frankel.game.coin

import ch.frankel.game.dice.{Die, Rollable}
import java.util.Random

class Coin(implicit random: Random) extends Rollable[Flip] {

  override def roll = new Die(2)(random).roll match {

    case 1 => Head
    case 2 => Tail
    case other => {
      val message:String = "d2 rolled " + other + ". Are you sure the Random generator [" + random + "] is appropriate?"
      throw new IndexOutOfBoundsException(message)
    }
  }
}

object Coin
case class Flip()
object Head extends Flip {
  override def toString:String = "Head"
}
object Tail extends Flip {
  override def toString:String = "Tail"
}
