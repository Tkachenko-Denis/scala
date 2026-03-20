object MergeSort {
  def sort(values: Vector[Int]): Vector[Int] = {
    if (values.length <= 1) values
    else {
      val middle = values.length / 2
      val left = sort(values.take(middle))
      val right = sort(values.drop(middle))

      merge(left, right)
    }
  }

  private def merge(left: Vector[Int], right: Vector[Int]): Vector[Int] = {
    @annotation.tailrec
    def loop(
      leftIndex: Int,
      rightIndex: Int,
      result: Vector[Int]
    ): Vector[Int] = {
      if (leftIndex >= left.length) result ++ right.drop(rightIndex)
      else if (rightIndex >= right.length) result ++ left.drop(leftIndex)
      else if (left(leftIndex) <= right(rightIndex)) {
        loop(leftIndex + 1, rightIndex, result :+ left(leftIndex))
      } else {
        loop(leftIndex, rightIndex + 1, result :+ right(rightIndex))
      }
    }

    loop(0, 0, Vector.empty)
  }
}
