import scala.language._
import play.api.libs.iteratee.{Enumeratee, Enumerator, Iteratee}
import scala.concurrent.Await
import scala.concurrent.duration._

object Adapt extends App {
  val it = Iteratee.fold[Int, Int](0){ _ + _ }
  val etee = Enumeratee.map[String] { _.toInt }
  val fut = Enumerator("1", "2", "3").run(etee.transform(it))
  println(Await.result(fut, 3 seconds))
}
