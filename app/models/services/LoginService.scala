package models.services

trait LoginService {
  def checkEmail(email: String): Boolean
}
