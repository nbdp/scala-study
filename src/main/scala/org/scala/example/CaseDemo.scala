package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/5
 */
object CaseDemo {


  def main(args: Array[String]): Unit = {

  }


  def matchTest(i: Int): String = {
    var ii = i match {
      case 0 => "one"
      case 1 => "first"
      case _ => "neg"
    }
    ii
  }

  print(matchTest(0))
}
