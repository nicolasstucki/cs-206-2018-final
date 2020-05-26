package exercise1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

import org.apache.log4j.{Logger, Level}

object E1Q1 {

  Logger.getLogger("org").setLevel(Level.OFF)

  def main(args: Array[String]): Unit = {
    println("Exercise 1 - Question 1")
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("E1Q1")
    val sc: SparkContext = new SparkContext(conf)
    





    val items: RDD[ItemKind] = sc.makeRDD(List(
      ItemKind(1, "item1", 1),
      ItemKind(2, "item2", 200000),
      ItemKind(3, "item3", 13553),
      ItemKind(4, "item4", 100000),
      ItemKind(5, "item5", 45324),
      ItemKind(6, "item6", 100002),
      ItemKind(7, "item7", 455),
    ))







    // val expensiveItemsNames: Array[String] = ???

    // /*
    val expensiveItemsNames: Array[String] = 
      items.filter(_.price > 100000).map(_.name).collect()
    // */




    println(expensiveItemsNames.mkString("[", ", ", "]"))
    
    sc.stop()
  }
 
}
