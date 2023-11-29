package models.entities

case class Product(id: String,
                   title: String,
                   description: String)

case class ProductItem(id: String,
                       priceValue: Int,
                       count: Int,
                       isExists: Boolean,
                       productId: String = null)
