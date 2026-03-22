import play.api.libs.functional.syntax._
import play.api.libs.json._

case class Product(id: Long, name: String, price: Double, tags: List[String])

object ProductJson {
  implicit val productFormat: Format[Product] = (
    (__ \ "id").format[Long] and
      (__ \ "name").format[String] and
      (__ \ "price").format[Double] and
      (__ \ "tags").format[List[String]]
  )(Product.apply, unlift(Product.unapply))
}
