object SumJava extends App {
  def sum(xs: Iterator[Int]) = {
    var acc = 0
    for (x <- xs) acc += x
    acc
  }

  println(sum(Iterator(1, 2, 3)))
}