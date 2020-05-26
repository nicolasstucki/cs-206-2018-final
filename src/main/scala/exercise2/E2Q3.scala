package exercise2

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

trait E2Q3[A] { // trait Furure[A] {
  val ths: Future[A] = ??? // assumed to be `this` in `Furure`
  
  def zip[B](fb: Future[B]): Future[(A, B)] = ???

  /*
  def zip[B](fb: Future[B]): Future[(A, B)] = {
    for {
      a <- ths
      b <- fb
    } yield (a, b)
  }
  */

  /*
  def zip[B](fb: Future[B]): Future[(A, B)] =
    ths.flatMap(a => fb.map(b => (a, b)))
  */



 
}
