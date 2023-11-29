package models.dto

import models.entities.{ProductItem, Product}
import play.api.libs.json.{Json, Reads, Writes}
case class ProductDTO(id: String,
                   title: String,
                   description: String,
                   productItems: List[ProductItemDTO] = null)

object ProductDTO {

  def from(from: Product, items: List[ProductItem]): ProductDTO = ProductDTO(
    from.id,
    from.title,
    from.description,
    items.map(ProductItemDTO.from)
  )

  def toProduct(productDTO: ProductDTO): Product = Product(
    id = productDTO.id, title = productDTO.title, description = productDTO.description)


  implicit val reads: Reads[ProductDTO] = Json.reads[ProductDTO]

  implicit val writes: Writes[ProductDTO] = Json.writes[ProductDTO]

  /* implicit val reads: Reads[Product] = (
     (JsPath \ "id").read[String] and
       (JsPath \ "title").read[String] and
       (JsPath \ "description").read[String] and
       (JsPath \ "productItems").read[List[ProductItem]](ProductItem.reads[ProductItem])
     )(Product.apply _)*/
}
case class ProductItemDTO(id: String,
                       priceValue: Int,
                       count: Int,
                       isExists: Boolean)

object ProductItemDTO{

  def from(from: ProductItem): ProductItemDTO = ProductItemDTO(
    from.id,
    from.priceValue,
    from.count,
    from.isExists
  )
  def toProductItem(productItemDTO: ProductItemDTO, productId: String = null): ProductItem = ProductItem(
    productItemDTO.id, productItemDTO.priceValue, productItemDTO.count, productItemDTO.isExists, productId)

  implicit val reads: Reads[ProductItemDTO] = Json.reads[ProductItemDTO]

  implicit val writes: Writes[ProductItemDTO] = Json.writes[ProductItemDTO]

  /*implicit val reads: Reads[ProductItem] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "priceValue").read[Int] and
      (JsPath \ "count").read[Int] and
      (JsPath \ "isExists").read[Boolean] and
      (JsPath \ "productId").read[String]
    )(ProductItem.apply _)*/
}

