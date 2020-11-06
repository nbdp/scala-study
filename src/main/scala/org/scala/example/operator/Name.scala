package org.scala.example.operator

/**
 * Name 字符串提取器
 * User: krisjin
 * Date: 2017/1/25
 */
object Name {

  def unapply(input: String) = {
    val index = input.indexOf(" ")
    if (index == -1) None
    else Some((input.substring(0, index)), input.substring(index + 1))
  }
}
