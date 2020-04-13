object ParallelismMap2Test {

}

case class Par[A]()

object Par {
  def unit[A](a: => A): Par[A] = ???

  def get[A](a: Par[A]): A = ???

  def sum(ints: IndexedSeq[Int]): Par[Int] = {
    if (ints.size <= 1)
      unit(ints.headOption getOrElse 0)
    else {
      val (l, r) = ints.splitAt(ints.length/2)
      map2(sum(l), sum(r))(_ + _)
    }
  }

  def map2[A, B](in1: Par[A], in2: Par[A])(fun: (A, A)=>B): Par[B] = ???
}