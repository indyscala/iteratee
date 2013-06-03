object SumScala extends App {
  def sum(xs: Iterator[Int]) = xs.foldLeft(0) { _ + _ }

  println(sum(Iterator(1, 2, 3)))
}