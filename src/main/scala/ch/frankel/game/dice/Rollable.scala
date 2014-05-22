package ch.frankel.game.dice

/**
 * Something that can be "rolled" to get a random result.
 *
 * @tparam T Result type
 */
trait Rollable[T] {

  /**
   * Rolls the rollable.
   *
   * @return Tuple consisting of 1) the rollable itself and 2) the rolled result
   */
  def roll:T
}
