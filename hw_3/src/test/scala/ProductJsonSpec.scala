import org.scalatest.funsuite.AnyFunSuite
import play.api.libs.json.Json

class ProductJsonSpec extends AnyFunSuite {
  test("deserialize product, increase price and serialize back") {
    import ProductJson._

    val jsonStr = """{"id": 1, "name": "Laptop", "price": 999.99, "tags": ["tech", "work"]}"""

    val product = Json.parse(jsonStr).as[Product]
    val updatedProduct = product.copy(price = product.price * 1.1)
    val updatedJson = Json.stringify(Json.toJson(updatedProduct))
    val parsedUpdatedProduct = Json.parse(updatedJson).as[Product]

    assert(product == Product(1, "Laptop", 999.99, List("tech", "work")))
    assert(parsedUpdatedProduct == updatedProduct)
  }
}
