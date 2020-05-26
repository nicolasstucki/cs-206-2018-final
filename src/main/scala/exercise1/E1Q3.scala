package exercise1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

import java.util.Date

object E1Q3 {

  def main(args: Array[String]): Unit = {
    println("Exercise 1 - Question 3")
    val db = DB.create()
    val items: RDD[ItemKind] = db.items
    val orders: RDD[Order] = db.orders
    



    val mostExpensiveOrder: (Int, Int) = ???


    /*
    val itemsSoldInOrder: RDD[(Int, Int)] = // (itemID, orderID)
       orders.flatMap((order: Order) => order.itemIds.map((itemId: Int) => (itemId, order.id)))
    val itemPrices: RDD[(Int, Int)] = // (itemID, price)
      items.map((item: ItemKind) => (item.id, item.price))
    val orderItemSoldPriece: RDD[(Int, Int)] = // (price, orderID)=
      itemsSoldInOrder.join(itemPrices).values
    val oderPrieces: RDD[(Int, Int)]  = // (totalPrice, orderID)
      orderItemSoldPriece.reduceByKey(_ + _)
    val mostExpensiveOrder: (Int, Int) = // (totalPrice, orderID)
      oderPrieces.max()(Ordering.by(_._2))
    */

    /*
    val mostExpensiveOrder: (Int, Int) = 
      orders.flatMap((order: Order) => order.itemIds.map((itemId: Int) => (itemId, order.id)))
        .join(items.map((item: ItemKind) => (item.id, item.price)))
        .values
        .reduceByKey(_ + _)
        .max()(Ordering.by(_._2))
    */


    assert(mostExpensiveOrder == (1002,217754))
    println(s"Most expensive order: $mostExpensiveOrder")
    
    db.close()
  }
 
}
