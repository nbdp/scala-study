package org.scala.operator

/**
 * unapply 作为测试方法
 * User: shijingui
 * Date: 2017/1/25
 */
object IsCompound {

  def unapply(input:String)= input.contains("")
}
