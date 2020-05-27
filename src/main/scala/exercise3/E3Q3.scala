package exercise3

object E3Q3 {

  class MyQueue(maxSize: Int) extends JobQueue(maxSize) {
    var front = 0
    var size = 0
    val buffer = new Array[Job](maxSize)

    /*{
      var watchers = 0
    }*/

    def put(job: Job): Unit = synchronized {
      while (size == maxSize) wait()

      val rear = (front + size) % maxSize
      buffer(rear) = job
      size += 1

      notifyAll()
    }

    /*
    def put(job: Job): Unit = synchronized {
      if (size == maxSize || watchers > 0) wait()

      val rear = (front + size) % maxSize
      buffer(rear) = job
      size += 1

      notifyAll()
    }
    */
    
    def take: Job = synchronized {
      while (size == 0) wait()

      val job = buffer(front)
      front = (front + 1) % maxSize
      size -= 1

      notifyAll()
      
      job  
    }

    /*
    def take: Job = synchronized {
      if (size == 0 || watchers > 0) wait()

      val job = buffer(front)
      front = (front + 1) % maxSize
      size -= 1

      notifyAll()
      
      job  
    }
    */

    def snapshot: List[Job] = synchronized {
      val snapSeq: Seq[Job] = 
        for (i <- front until (front + size)) yield buffer(i % maxSize)
      snapSeq.toList
    }
    
    /*
    def snapshot: List[Job] = 
      synchronized {
        watchers += 1
      }

      val snapSeq: Seq[Job] = 
        for (i <- front until (front + size)) yield buffer(i % maxSize)

      synchronized {
        watchers -= 1
        if (watchers == 0) notifyAll()
      }

      snapSeq.toList
    }
    */
    
  }
  
}
