object MyRange {
  def apply(n: Int, m: Int): List[Int] = {
    n match {
      case value if value > m => Nil
      case value => value :: apply(value + 1, m)
    }
  }
}
