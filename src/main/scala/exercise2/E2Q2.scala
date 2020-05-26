package exercise2

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import ISAcademia.{Student, getGrade, students}

object E2Q2 {

  
  def computeAverage(s1: Student, s2: Student, s3: Student): Unit = {
    // TODO: emit 3 concurrent requests
    val f1 = getGrade(s1)
    val f2 = getGrade(s2)
    val f3 = getGrade(s3)
    
    // TODO: compute the average grade
    val average: Future[Double] = 
      for {
        g1 <- f1
        g2 <- f2
        g3 <- f3
      } yield (g1 + g2 + g3) / 3

    average.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    println("Exercise 2 - Question 2")
    computeAverage(students(0), students(1), students(2)) // Student1, Student2, Student3
    // computeAverage(students(3), students(4), students(5)) // StudentA, StudentB, StudentC
  }
}
