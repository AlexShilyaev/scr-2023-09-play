package models.dao.repositories

import models.dao.entities.{Product, ProductItem}
import models.dao.schema.ProductSchema

class ProductRepository {
  private val productRecords = ProductSchema.productRecords
  private val productItemRecords = ProductSchema.productItemRecords

  import org.squeryl.PrimitiveTypeMode._

  def insert(product: Product, items: List[ProductItem]) = transaction {
    productRecords.insert(product)
    items.foreach(it => productItemRecords.insert(it))
  }

  def findByTitle(title: String): List[(Product, List[ProductItem])] = transaction {
    productRecords.filter(_.title == title).map(
      p => (p, productItemRecords.filter(pi => pi.productId == p.id).toList)
    ).toList
  }

  def update(product: Product, items: List[ProductItem]) = transaction {
    productRecords.update(product)
    items.foreach(it => productItemRecords.update(it))
  }

  def delete(productId: String): Unit = transaction {
    productRecords.delete(productId)
  }
}
