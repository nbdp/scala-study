package org.scala.base

import java.io.File

import scala.io.Source

/**
 * User: shijingui
 * Date: 2017/1/23
 */
class RichFile(val file: File) {

  def read = Source.fromFile(file.getPath).mkString

}
