package ch.frankel.game.dice

import java.util.Random

import org.junit.runner.RunWith
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.runner.JUnitRunner
import org.specs2.specification.Scope

@RunWith(classOf[JUnitRunner])
object DieSpec extends Specification with Mockito {

  "Die" should {

    "return rolled result plus one" in new die(mock[Random]) {

      random.nextInt(100) returns 5
      die.roll mustEqual 6
    }
  }

  class die(val random:Random) extends Scope {
    val die = new Die(100)(random)
  }
}