package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/6
 */
object ObjectNestingDemo {

  def main(args: Array[String]): Unit = {

  }

  object A {
    var name: String = ""
  }

  object B {
    var age: Int = 0
  }


  object C {
    var txt: Any = ""
  }

  A.name = "22"
  println(A.name)

}
