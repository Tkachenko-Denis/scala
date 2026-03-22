object FibonacciTask {
  def fibonacci: LazyList[BigInt] = {
    def loop(first: BigInt, second: BigInt): LazyList[BigInt] = {
      first #:: loop(second, first + second)
    }

    loop(0, 1)
  }

  def firstTenDivisibleByThree: Vector[BigInt] = {
    fibonacci
      .filter(_ % 3 == 0)
      .take(10)
      .toVector
  }
}
