# Game project

This simple Scala project offers a simple model for dice rolling, in the context of Games (and especially Role Playing Games).

At the root of the hierarchy lies the `Rollable` trait. It offers a single `roll()` method, which returns a Tuple of itself and the rolled result.

```
trait Rollable[T] {

  def roll:(Rollable[T], T)
}
```

Directly extending `Rollable` is `Die` It represents of those multi-sided dice commonly found in Role Playing Games.

```
class Die (val sides:Int)(implicit random:Random) extends Rollable[Int] {

  override def roll:(Die, Int) = (this, random.nextInt(sides) + 1)
}
```

One can inject dedicated random generators (especially useful for testing), but `Die` also provides a `SecureDie` object with an implicit random generator of type `SecureRandom`.

Finally, the API has dice objects, from `d2` to `d100` to easily start, *e.g.*:

* `val roll:(Die, Int) = d2.roll`
* `var roll = d6.roll`
* etc.