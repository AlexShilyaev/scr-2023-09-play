package models.dao.schema

import models.dao.entities.{Product, ProductItem}
import org.squeryl.Schema

object ProductSchema extends Schema {
  val productRecords = table[Product]

  val productItemRecords = table[ProductItem]
}
