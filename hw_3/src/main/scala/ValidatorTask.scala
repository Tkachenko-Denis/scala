trait Validator[T] {
  def validate(value: T): Boolean
}

object ValidatorTask {
  implicit val stringValidator: Validator[String] = new Validator[String] {
    override def validate(value: String): Boolean = value.nonEmpty
  }

  implicit val intValidator: Validator[Int] = new Validator[Int] {
    override def validate(value: Int): Boolean = value > 0
  }

  def check[T](value: T)(implicit validator: Validator[T]): Unit = {
    if (validator.validate(value)) println("OK")
    else println("Error")
  }

  implicit class ValidatorOps[T](value: T) {
    def isValid(implicit validator: Validator[T]): Boolean = {
      validator.validate(value)
    }
  }
}
