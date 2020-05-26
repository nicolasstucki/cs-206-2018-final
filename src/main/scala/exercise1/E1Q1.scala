package exercise1

import org.apache.spark.rdd.RDD

object E1Q1 {

  def main(args: Array[String]): Unit = {
    println("Exercise 1 - Question 1")
    val db = DB.create()
    val items: RDD[ItemKind] = db.items




    val expensiveItemsNames: Array[String] = ???

    /*
    val expensiveItemsNames: Array[String] = 
      items.filter(_.price > 100000).map(_.name).collect()
    */



    assert(expensiveItemsNames.sorted.toList == List("item2", "item6"))
    println(expensiveItemsNames.mkString("[", ", ", "]"))
    
    db.close()
  }
 
}
