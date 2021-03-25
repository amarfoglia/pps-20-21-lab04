package u04lab.code

import Optionals._
import Lists._
import Streams._
import u04lab.code.Streams.Stream.Cons

trait PowerIterator[A] {
  def next(): Option[A]
  def allSoFar(): List[A]
  def reversed(): PowerIterator[A]
}

object PowerIterator {
  def apply[A](stream: Stream[A]): PowerIterator[A] = new PowerIteratorImpl(stream)

  private class PowerIteratorImpl[A](private var stream: Stream[A]) extends PowerIterator[A] {
    private var pastList: List[A] = List.Nil()

    override def next(): Option[A] = stream match {
      case Cons(h, t) =>
        pastList = List.Cons(h(), pastList)
        stream = t()
        Option.Some(h())
      case _ => Option.empty
    }

    override def allSoFar(): List[A] = List.reverse(pastList)

    override def reversed(): PowerIterator[A] = PowerIterator(List.toStream(pastList))
  }
}

trait PowerIteratorsFactory {

  def incremental(start: Int, successive: Int => Int): PowerIterator[Int]
  def fromList[A](list: List[A])
  def randomBooleans(size: Int): PowerIterator[Boolean]
}

class PowerIteratorsFactoryImpl extends PowerIteratorsFactory {

  override def incremental(start: Int, successive: Int => Int): PowerIterator[Int] =
    PowerIterator(Stream.iterate(start)(successive))

  override def fromList[A](list: List[A]): Unit = ???

  override def randomBooleans(size: Int): PowerIterator[Boolean] = ???
}
