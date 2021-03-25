package u04lab.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List.Cons
import u04lab.code.Lists._

class OptionalTaskTest {
  @Test
  def testListApply(): Unit = {
    val list = List(1, 2, 3)
    assertEquals(Cons(1, Cons(2, Cons(3, List.Nil()))), list)
    assertEquals(List.Nil(), List())
  }
}
