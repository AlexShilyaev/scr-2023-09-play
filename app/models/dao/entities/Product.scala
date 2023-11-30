package models.dao.entities

import org.squeryl.KeyedEntity

case class Product(id: String,
                   title: String,
                   description: String) extends KeyedEntity[String]

case class ProductItem(id: String,
                       productId: String,
                       priceValue: Int,
                       count: Int,
                       isExists: Boolean
                       ) extends KeyedEntity[String]
