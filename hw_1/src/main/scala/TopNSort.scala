object TopNSort {
  def findSmallest(values: Vector[Int], n: Int): Vector[Int] = {
    if (n <= 0 || values.isEmpty) Vector.empty
    else {
      values.foldLeft(Vector.empty[Int]) { (current, value) =>
        val index = current.indexWhere(_ > value) match {
          case -1 => current.length
          case foundIndex => foundIndex
        }

        val updated = current.patch(index, Seq(value), 0)

        if (updated.length > n) updated.take(n) else updated
      }
    }
  }
}
