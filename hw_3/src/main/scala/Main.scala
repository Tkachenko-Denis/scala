object Main {
  def main(args: Array[String]): Unit = {
    import ValidatorTask._

    println(s"First ten Fibonacci numbers divisible by 3: ${FibonacciTask.firstTenDivisibleByThree}")
    println(s"Discount for user 1: ${FoodOrderService.getUserDiscount(1)}")
    println(s"Discount for user 2: ${FoodOrderService.getUserDiscount(2)}")
    println(s"Discount for user 99: ${FoodOrderService.getUserDiscount(99)}")
    println(s"""Validation "Scala": ${"Scala".isValid(ValidatorTask.stringValidator)}""")
    println(s"Validation 42: ${42.isValid(ValidatorTask.intValidator)}")
    println(s"Validation 0: ${0.isValid(ValidatorTask.intValidator)}")
  }
}
