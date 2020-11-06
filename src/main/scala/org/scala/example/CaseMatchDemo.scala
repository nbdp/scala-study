package org.scala.example

/**
 *
 * @author krisjin
 * @date 2020/11/5
 */
object CaseMatchDemo {

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

  //use any type param
  def matchTest2(x: Any): Any = x match {
    case 1 => "one"
    case 2 => 2
    case "name" => "kris"
    case _ => "unknow1"
  }

  var book1 = Book("aa", 123)
  var book2 = Book("bb", 321)
  var book3 = Book("aa", 231)
  var bookList = List(book1, book2, book3)

  for (b <- bookList) {
    b match {
      case Book("aa", 123) => println("aa")
      case Book("bb", 3121) => println("bb")
      case _ => println("unknow2")
    }
  }


  case class Book(name: String, price: Int)


  println(matchTest(0))

  println(matchTest2("name"))
  println(matchTest2(2))
}
