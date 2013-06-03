import java.util.concurrent.TimeUnit
import play.api.libs.iteratee.{Enumerator, Iteratee}
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object SumIterateeRun extends App {
  val it = Iteratee.fold[Int, Int](0){ _ + _ }
  val fut = Enumerator(1, 2, 3).apply(it)
  Await.result(fut, Duration(3, TimeUnit.SECONDS))
}
