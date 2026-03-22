case class User(id: Int, name: String)

case class Order(id: Int, userId: Int, totalAmount: Double, isActive: Boolean)

object FoodOrderService {
  private val users = List(
    User(1, "Denis"),
    User(2, "Anna"),
    User(3, "Oleg")
  )

  private val orders = List(
    Order(1, 1, 1200.0, isActive = true),
    Order(2, 2, 350.0, isActive = true),
    Order(3, 3, 900.0, isActive = false)
  )

  def findUser(id: Int): Option[User] = {
    users.find(_.id == id)
  }

  def getActiveOrder(user: User): Option[Order] = {
    orders.find(order => order.userId == user.id && order.isActive)
  }

  def calculateDiscount(order: Order): Either[String, Double] = {
    if (order.totalAmount < 500) Left("Слишком маленькая сумма для скидки")
    else Right(order.totalAmount * 0.1)
  }

  def getUserDiscount(userId: Int): Either[String, Double] = {
    for {
      user <- findUser(userId).toRight("Пользователь не найден")
      order <- getActiveOrder(user).toRight("Активный заказ не найден")
      discount <- calculateDiscount(order)
    } yield discount
  }
}
