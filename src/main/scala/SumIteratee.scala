import play.api.libs.iteratee.{Enumerator, Iteratee}

object SumIteratee extends App {
  val it = Iteratee.fold[Int, Int](0){ _ + _ }

  Enumerator(1, 2, 3).apply(it)
}
