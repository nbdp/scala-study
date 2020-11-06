package org.scala.example

import org.json4s.DefaultFormats

object JsonUtil extends LogMan with Serializable {

  import org.json4s.native.Serialization.{read, write}

  implicit val formats: DefaultFormats.type = org.json4s.DefaultFormats

  def transObjToJson(obj: AnyRef): String = {
    write(obj)
  }

  def transJsonToObj[T: Manifest](json: String): T = {
    read[T](json)
  }

}
