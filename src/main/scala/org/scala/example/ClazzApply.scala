package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/13
 */
class ClazzApply {

  def sum(i: Int, j: Int): Unit = {
    println(i + j)
  }
}

object ClazzApply {
  def apply(): ClazzApply = new ClazzApply
}


object A {

  def main(args: Array[String]): Unit = {
    ClazzApply.apply().sum(1, 1)

  }
}