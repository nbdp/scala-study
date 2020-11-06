package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/6
 */
object CaseClassDemo {

  def main(args: Array[String]): Unit = {
    var aa = Person("zhangsan", 22)

    print(aa.age)
  }
  case class Person(name: String, age: Int)

}
