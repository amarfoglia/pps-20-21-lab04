package u04lab.code

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertNotEquals, assertTrue, fail}

class ComplexTest {
  val oneComplex: Complex = Complex(1, 1)
  val zeroComplex: Complex = Complex(0, 0)

  @Test
  def testEquality(): Unit = {
    val complex2 = Complex(1, 1)
    assertTrue(oneComplex.equals(complex2))
    assertTrue(oneComplex == complex2)
    assertFalse(oneComplex.eq(complex2))
  }

  @Test
  def testToString(): Unit = {
    assertEquals(s"ComplexImpl(${oneComplex.re},${oneComplex.im})", oneComplex.toString)
  }

  @Test
  def testSum(): Unit = {
    assertEquals(Complex(2, 2), oneComplex + oneComplex)
    assertEquals(oneComplex, oneComplex + zeroComplex)
    assertEquals(zeroComplex, oneComplex + Complex(-1, -1))
  }

  @Test
  def testProduct(): Unit = {
    assertEquals(Complex(0, 2), oneComplex * oneComplex)
    assertEquals(Complex(2, 0), oneComplex * Complex(1, -1))
    assertEquals(Complex(-2, 0),oneComplex * Complex(-1, 1))
    assertEquals(Complex(0, 0), oneComplex * zeroComplex)
  }
}
