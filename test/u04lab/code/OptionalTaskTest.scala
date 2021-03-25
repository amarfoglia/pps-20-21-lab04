package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue, fail}
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

  @Test
  def testSameTeacher(): Unit = {
    val ppsCourse: Course = Course("PPS", "Viroli")
    val courses = List(ppsCourse, ppsCourse)
    courses match {
      case sameTeacher(t) => println(s"$courses have same teacher $t")
      case _ => fail(s"$courses have different teachers")
    }
    assertTrue(sameTeacher.unapply(List.Nil()).isEmpty)
    assertFalse(sameTeacher.unapply(List(ppsCourse)).isEmpty)
    assertTrue(sameTeacher.unapply(List(ppsCourse, Course("pcd", "Ricci"))).isEmpty)
  }
}
