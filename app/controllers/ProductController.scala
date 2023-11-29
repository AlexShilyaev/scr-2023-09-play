package controllers

import controllers.actions.authAction
import models.dto.ProductDTO
import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent, Controller}
import models.services.ProductService

class ProductController extends Controller{
  def list() = authAction{ ur =>
    Ok(views.html.products.list(List(
      ProductDTO("1", "foo1", "bar1"),
      ProductDTO("2", "foo2", "bar2"),
      ProductDTO("3", "foo3", "bar3"),
      ProductDTO("4", "foo4", "bar4")
    )))
  }

  def list2() = Action {
    Ok(views.html.products.list(List(
      ProductDTO("1", "foo1", "bar1"),
      ProductDTO("2", "foo2", "bar2"),
      ProductDTO("3", "foo3", "bar3"),
      ProductDTO("4", "foo4", "bar4")
    )))
  }

  def create() = Action(parse.json[ProductDTO]) { rc =>
    val product = rc.body
    ProductService.create(product)
    //Ok(Json.toJson(product))
    Ok("OK")
    }

  def search(title: String) = Action{
    Ok(Json.toJson(ProductService.search(title)))
    //Ok("OK")
  }

  def delete(id: String) = Action {
    ProductService.delete(id)
    NoContent
    //Ok("OK")
  }

  def update() = Action(parse.json[ProductDTO]) { rc =>
    val product = rc.body
    ProductService.create(product)
    //Ok(Json.toJson(product))
    Ok("OK")
  }
}
