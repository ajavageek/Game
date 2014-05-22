package ch.frankel.game.coin

import java.util.Random

import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
object CoinSpec extends Specification with Mockito {

  "Coin" should {

    "return Head when rolled 1" in new coin(mock[Random]) {

      random.nextInt(2) returns 0
      coin.roll mustEqual Head
    }

    "return Tail when rolled 2" in new coin(mock[Random]) {

      random.nextInt(2) returns 1
      coin.roll mustEqual Tail
    }

    "return Tail Tail Head Tail when rolled 1 1 2 1" in new coin(mock[Random]) {

      random.nextInt(2) returns 1 thenReturn 1 thenReturn 0 thenReturn 1
      coin.roll mustEqual Tail
      coin.roll mustEqual Tail
      coin.roll mustEqual Head
      coin.roll mustEqual Tail
    }

    "throw exception when Coin's Random generates out of bound results" in new coin(mock[Random]) {

      random.nextInt(2) returns 10
      coin.roll must throwA[IndexOutOfBoundsException]
    }
  }

  class coin(val random:Random) extends Scope {

    val coin = new Coin()(random)
  }
}
