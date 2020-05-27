package exercise3

object E3Q1 {

  // [.................]
  //  |--|

  class MyQueue(maxSize: Int) extends JobQueue(maxSize) {
    var front = 0
    var size = 0
    val buffer = new Array[Job](maxSize)
    def put(job: Job): Unit = synchronized {
      if (size == maxSize) wait()

      val rear = (front + size) % maxSize
      buffer(rear) = job
      size += 1

      notifyAll()
    }

    def take: Job = synchronized {
      if (size == 0) wait()

      val job = buffer(front)
      front = (front + 1) % maxSize
      size -= 1

      notifyAll()
      
      job  
    }
  }

  /* Solution
    The implementation doesn’t obey the specification.
    We should change the first line in put and take to while.
    This is because when a thread is weaken up, the test condition 
    cannot be guaranteed, thus a while is needed.
  */
}
