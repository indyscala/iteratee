import play.api.libs.iteratee.{Enumeratee, Concurrent, Iteratee}
import scala.concurrent.Await
import scala.concurrent.duration._

object Broadcast extends App {
  // Some building blocks
  val sum = Iteratee.fold[Int, Int](0) { _ + _ }
  val toInt = Enumeratee.map[String] { _.toInt }
  val odds = Enumeratee.filter[Int] { _ % 2 == 1 }

  val (enum, channel) = Concurrent.broadcast[String]
  val sumOdds = enum.run(toInt.compose(odds).transform(sum))
  enum.run(Iteratee.foreach[String] { s => println("TRACE: "+s) }.map(_ => println("DONE")))
  println("Look ma, main thread is not blocked")

  io.Source.stdin.getLines foreach {
    case line if line.trim.isEmpty =>
      channel.eofAndEnd()
      println("SUM OF ODDS: "+Await.result(sumOdds, 3 seconds))

    case line => channel.push(line.trim)
  }
}
