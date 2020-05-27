package exercise3

object E3Q2 {

  class MyQueue(maxSize: Int) extends JobQueue(maxSize) {
    var front = 0
    var size = 0
    val buffer = new Array[Job](maxSize)
    def put(job: Job): Unit = synchronized { ??? }
    def take: Job = synchronized { ??? }
    
    def snapshot: List[Job] = ???

    /*
    def snapshot: List[Job] = 
      synchronized {
        val snapSeq: Seq[Job] = 
          for (i <- front until (front + size)) yield buffer(i % maxSize)
        snapSeq.toList
      }
    */
  }
  
}
