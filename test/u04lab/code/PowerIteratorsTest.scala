package u04lab.code

import Optionals._
import Lists._
import Lists.List._
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

class PowerIteratorsTest {

  val factory = new PowerIteratorsFactoryImpl()

  @Test
  def testIncremental() {
    val pi = factory.incremental(5,_+2); // pi produce 5,7,9,11,13,...
    assertEquals(Option.of(5), pi.next());
    assertEquals(Option.of(7), pi.next());
    assertEquals(Option.of(9), pi.next());
    assertEquals(Option.of(11), pi.next());
    assertEquals(List.Cons(5, List.Cons(7, List.Cons(9, List.Cons(11,List.Nil())))), pi.allSoFar()); // elementi già prodotti
    for (i <- 0 until 10) {
      pi.next(); // procedo in avanti per un po'..
    }
    assertEquals(Option.of(33), pi.next()); // sono arrivato a 33
  }

  @Test
  def testFromList(): Unit = {
    val pi = factory.fromList(Cons("a", Cons("b", Cons("c", Nil())))) // pi produce a,b,c
    assertEquals(pi.next(), Option.of("a"))
    assertEquals(pi.next(), Option.of("b"))
    assertEquals(pi.allSoFar(), Cons("a", Cons("b", Nil()))) // fin qui a,b
    assertEquals(pi.next(), Option.of("c"))
    assertEquals(pi.allSoFar(), Cons("a", Cons("b", Cons("c", Nil())))) // fin qui a,b,c
    assertTrue(Option.isEmpty(pi.next())) // non c'è più niente da produrre
  }

  @Test
  def testRandom(): Unit = {
    val pi = factory.randomBooleans(4) // pi produce 4 booleani random
    val b1 = Option.get(pi.next())
    val b2 = Option.get(pi.next())
    val b3 = Option.get(pi.next())
    val b4 = Option.get(pi.next())
    System.out.println(b1 + " " + b2 + " " + b3 + " " + b4) // stampo a video.. giusto per vedere se sono proprio random..

    assertTrue(Option.isEmpty(pi.next())) // ne ho già prodotti 4, quindi il prossimo è un opzionale vuoto

    assertEquals(pi.allSoFar(), Cons(b1, Cons(b2, Cons(b3, Cons(b4, Nil()))))) // ho prodotto proprio b1,b2,b3,b4
  }
}