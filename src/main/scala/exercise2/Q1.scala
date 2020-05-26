package exercise2

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import ISAcademia.{Student, getGrade, students}

object E2Q1 {

  
  def computeAverage(s1: Student, s2: Student, s3: Student): Unit = {
    // TODO: emit 3 sequencial requests
    
    // TODO: compute the average grade
    val average: Future[Double] = ???

    /*
    val average: Future[Double] = 
      for {
        g1 <- getGrade(s1)
        g2 <- getGrade(s2)
        g3 <- getGrade(s3)
      } yield (g1 + g2 + g3) / 3
    */

    /*
    val average = 
      getGrade(s1).flatMap(g1 => getGrade(s2).flatMap(g2 => getGrade(s3).map(g3 => (g1 + g2 + g3) / 3)))
    */

    average.foreach(println)
  }

  def main(args: Array[String]): Unit = {
    println("Exercise 2 - Question 1")
    computeAverage(students(0), students(1), students(2)) // Student1, Student2, Student3
    // computeAverage(students(3), students(4), students(5)) // StudentA, StudentB, StudentC
  }
}
