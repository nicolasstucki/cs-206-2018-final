package exercise1

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

import org.apache.log4j.{Logger, Level}

import java.util.Date

class DB private (sc: SparkContext) {

  val items: RDD[ItemKind] = sc.makeRDD(List(
    ItemKind(1, "item1", 1),
    ItemKind(2, "item2", 200000),
    ItemKind(3, "item3", 13553),
    ItemKind(4, "item4", 100000),
    ItemKind(5, "item5", 45324),
    ItemKind(6, "item6", 100002),
    ItemKind(7, "item7", 455),
  ))

  val orders: RDD[Order] = sc.makeRDD(List(
    Order(1001, new Date(2019, 11, 27), Seq(1, 4, 5)),
    Order(1002, new Date(2019, 11, 29), Seq(3, 4, 3, 5, 5)),
    Order(1003, new Date(2019, 1, 29), Seq(3, 4, 7)),
    Order(1004, new Date(2019, 5, 6), Seq(3, 2)),
    Order(1005, new Date(2019, 4, 5), Seq(1, 1, 2)),
    Order(1006, new Date(2019, 11, 29), Seq(1, 1, 1, 1, 4)),
    Order(1007, new Date(2019, 11, 30), Seq(1, 1, 1)),
  ))


  def close(): Unit = sc.stop()

}

object DB {
  def create(): DB = {
    Logger.getLogger("org").setLevel(Level.OFF)
    val conf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("E1Q1")
    val sc: SparkContext = new SparkContext(conf)
    new DB(sc)
  }
}