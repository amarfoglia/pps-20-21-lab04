package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class StudentTest {

  @Test
  def testCourseApply(): Unit = {
    val course: Course = Course("PPS", "m.viroli")
    assertEquals(s"CourseImpl(${course.name},${course.teacher})", course.toString)
  }
}
