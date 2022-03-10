package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/10
 */
object TupleDemo {

  def main(args: Array[String]): Unit = {

  }

  val t = (1, 2, 3)
  //  println(t._3)


  val f1 = (_: Int) + (_: Int)

  println(f1(2, 2))
}
