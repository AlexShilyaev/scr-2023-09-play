package models.repositories

import models.entities.{Product, ProductItem}

import scala.collection.mutable

class ProductRepository {
  private val products = mutable.HashMap.empty[String, Product]
  private val productItems = mutable.HashMap.empty[(String, String), ProductItem]

  def insert(product: Product, items: List[ProductItem]) = {
    products.put(product.id, product)
    items.foreach(it => productItems.put((product.id, it.id), it))
  }

  def findByTitle(title: String): List[(Product, List[ProductItem])] =
    products.values.filter(_.title == title).map(p => (p, productItems.values.filter(pi => pi.productId == p.id).toList)).toList

  def update(product: Product, items: List[ProductItem]) = {
    products.put(product.id, product)
    items.foreach(it => productItems.put((product.id, it.id), it))
  }

  def delete(productId: String): Unit = {
    val items = productItems.filter(_._1 == productId).toList
    items.foreach(e => productItems.remove(e._1))
    products.remove(productId)
  }
}
