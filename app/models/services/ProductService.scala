package models.services

import models.dto.{ProductDTO, ProductItemDTO}
import models.repositories.ProductRepository
object ProductService {

  private val productRepository = new ProductRepository()
  def create(productDTO: ProductDTO) = {
productRepository.insert(ProductDTO.toProduct(productDTO), productDTO.productItems.map(e => ProductItemDTO.toProductItem(e)))
  }

  def update(productDTO: ProductDTO) = {
    productRepository.insert(ProductDTO.toProduct(productDTO), productDTO.productItems.map(e => ProductItemDTO.toProductItem(e)))
  }

  def delete(id: String) = {
    productRepository.delete(id)
  }

  def search(title: String) = {
    productRepository.findByTitle(title).map(e => ProductDTO.from(e._1, e._2))
  }

}
