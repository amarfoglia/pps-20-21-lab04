package u04lab.code

import u04lab.code.Lists._
import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List.Cons

class StudentTest {
  val student: Student = Student("alberto", 2021)
  val ppsCourse: Course = Course("PPS", "Viroli")
  val pcdCourse: Course = Course("PCD", "Ricci")

  @Test
  def testCourseApply(): Unit = {
    assertEquals(s"CourseImpl(${ppsCourse.name},${ppsCourse.teacher})", ppsCourse.toString)
  }

  @Test
  def testStudentApply(): Unit = {
    assertEquals(s"StudentImpl(${student.name},${student.year})", student.toString)
  }

  @Test
  def testGetStudentCourses(): Unit = {
    assertEquals(List.Nil(), student.courses)
    student.enrolling(ppsCourse)
    student.enrolling(pcdCourse)
    assertEquals(Cons(pcdCourse.name, Cons(ppsCourse.name, List.Nil())), student.courses)
  }

  @Test
  def testHasTeacher(): Unit = {
    assertFalse(student.hasTeacher(ppsCourse.teacher))
    student.enrolling(ppsCourse)
    assertTrue(student.hasTeacher(ppsCourse.teacher))
    student.enrolling(pcdCourse)
    assertTrue(student.hasTeacher(pcdCourse.teacher))
  }
}
