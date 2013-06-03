object SumSlow extends App {
  def slow(it: Iterator[Int]) = {
    it.map { x => Thread.sleep(2000); x }
  }

  def sum(xs: Iterator[Int]) = xs.foldLeft(0) { _ + _ }

  sum(slow(Iterator(1, 2, 3)))
}