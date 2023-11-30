package models.services

import models.dao.repositories.ProductRepository
import models.dto.{ProductDTO, ProductItemDTO}
object ProductService {

  private val productRepository = new ProductRepository()
  def create(productDTO: ProductDTO) = {
productRepository.insert(ProductDTO.toProduct(productDTO), productDTO.productItems.map(e => ProductItemDTO.toProductItem(e, productDTO.id)))
  }

  def update(productDTO: ProductDTO) = {
    productRepository.insert(ProductDTO.toProduct(productDTO), productDTO.productItems.map(e => ProductItemDTO.toProductItem(e, productDTO.id)))
  }

  def delete(id: String) = {
    productRepository.delete(id)
  }

  def search(title: String) = {
    productRepository.findByTitle(title).map(e => ProductDTO.from(e._1, e._2))
  }

}
