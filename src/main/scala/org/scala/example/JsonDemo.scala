package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/6
 */
object JsonDemo {

  def main(args: Array[String]): Unit = {

  }

  case class Person(name:String,age:Int)

  def output(x: Any): Unit = {
    JsonUtil.transObjToJson(Person("kris",11))
  }
}
