package exercise1

import org.apache.spark.rdd.RDD

import java.util.Date

object E1Q2 {

  def main(args: Array[String]): Unit = {
    println("Exercise 1 - Question 2")
    val db = DB.create()
    val orders: RDD[Order] = db.orders
    
    def isLastBlackFriday(date: Date): Boolean = 
      date.getYear == 2019 && date.getMonth == 11 && date.getDate == 29






    // val itemsSoldLastBlackFriday: Int = ???

    // /*
    val itemsSoldLastBlackFriday: Int =
      orders.filter(order => isLastBlackFriday(order.date)).map(_.itemIds.size).reduce(_ + _)
    // */



    println(s"Items sold last black Friday: $itemsSoldLastBlackFriday")
    
    db.close()
  }
 
}
