package org.scala.operator


/**
 * 提取序列
 * User: shijingui
 * Date: 2017/1/25
 */
object NameSeq {


  def unapplySeq(input: String): Option[Seq[String]] = {
    if (input.trim == "") None else Some(input.trim.split("\\s+"))
  }
}
