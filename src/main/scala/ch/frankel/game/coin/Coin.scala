package ch.frankel.game.coin

import ch.frankel.game.dice.{Die, Rollable}
import java.util.Random

class Coin(implicit random: Random) extends Rollable[Flip] {

  override def roll = new Die(2)(random).roll._2 match {

    case 1 => (this, Head)
    case 2 => (this, Tail)
    case other => {
      val message:String = "d2 rolled " + other + ". Are you sure the Random generator [" + random + "] is appropriate?"
      throw new IndexOutOfBoundsException(message)
    }
  }
}

object Coin {

  def main(args: Array[String] ) {

    object MyRandom extends Random {
      override def nextInt(x:Int) = 1
    }
    val coin = new Coin()(MyRandom)
    System.out.println(coin.roll._2)
  }
}

case class Flip()
object Head extends Flip
object Tail extends Flip
