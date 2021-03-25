package u04lab.code

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.{assertFalse, assertNotEquals, fail}

class ComplexTest {
  val complex = new ComplexImpl(5.3, -1)

  @Test
  def testEqualityFailure(): Unit = {
    val complex2 = new ComplexImpl(5.3, -1)
    assertFalse(complex.equals(complex2))
    assertFalse(complex == complex2)
    assertFalse(complex.eq(complex2))
  }

  @Test
  def testToStringFailure(): Unit = {
    assertNotEquals(s"${complex.re} ${complex.im}i", complex.toString)
  }
}
