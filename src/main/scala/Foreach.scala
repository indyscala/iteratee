import play.api.libs.iteratee.{Enumerator, Iteratee}

object Foreach extends App {
  val it = Iteratee.foreach[Int](s => println(s))
  Enumerator(1, 2, 3).apply(it)
}
