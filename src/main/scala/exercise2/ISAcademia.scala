package exercise2

import scala.concurrent.Future

object ISAcademia {
  private implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  case class Student(name: String, sciper: Int)

  val students: List[Student] = List(
    Student("Student1", 1001),
    Student("Student2", 1002),
    Student("Student3", 1003),
    Student("StudentA", 2001),
    Student("StudentB", 2002),
    Student("StudentC", 2003),
  )

  def getGrade(s: Student): Future[Double] = 
    Future {
      val grade = 4.0 + (students.indexOf(s).toDouble / 3)
      Thread.sleep((util.Random().nextDouble() * 1000).toLong)
      println("Loaded grade of: " + s)
      grade
    }


}
