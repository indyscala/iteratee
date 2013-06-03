import scala.language._
import play.api.libs.iteratee.{Enumerator, Iteratee}
import scala.concurrent.Await
import scala.concurrent.duration._

object Consume extends App {
  val it = Iteratee.consume[String]()
  val fut = Enumerator("a", "b", "c").run(it)
  println(Await.result(fut, 3 seconds))
}
