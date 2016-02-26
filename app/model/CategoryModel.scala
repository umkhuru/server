package model

import java.util.UUID

import conf.util.Util
import domain.content.Category
import play.api.libs.json.Json

/**
 * Created by hashcode on 2015/04/16.
 */
case class CategoryModel (
                     name: String,
                     description:String
                      ){
  def getDomain():Category=CategoryModel.domain(this)
}

object CategoryModel {
  implicit val categoryFmt = Json.format[CategoryModel]
  def domain(model: CategoryModel) = {
    Category(
      Util.md5Hash(UUID.randomUUID().toString()),
      model.name,
      model.description)
  }
}
