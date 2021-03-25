package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class StudentTest {
  val student: Student = Student("alberto", 2021)
  val course: Course = Course("PPS", "Viroli")

  @Test
  def testCourseApply(): Unit = {
    assertEquals(s"CourseImpl(${course.name},${course.teacher})", course.toString)
  }

  @Test
  def testStudentApply(): Unit = {
    assertEquals(s"StudentImpl(${student.name},${student.year})", student.toString)
  }
}
