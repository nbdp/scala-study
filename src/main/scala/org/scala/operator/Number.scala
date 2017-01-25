package org.scala.operator

/**
 * 单参数数字提取器
 * User: shijingui
 * Date: 2017/1/25
 */
object Number {
  def unapply(input: String): Option[Int] = {
    try {
      Some(input.trim.toInt)
    } catch {
      case ex: NumberFormatException => None
    }
  }
}
