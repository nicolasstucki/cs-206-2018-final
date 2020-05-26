package exercise3

abstract class JobQueue(maxSize: Int) {
  def put(job: Job): Unit
  def take: Job
}
