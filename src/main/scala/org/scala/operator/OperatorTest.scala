package org.scala.operator


import scala.collection.mutable

/**
 * 操作符
 * 变量，函数，类等都成为标识符
 * User: shijingui
 * Date: 2017/1/25
 */
object OperatorTest {

  val `val` = 42 //scala 提供反引号的方式使用特殊的关键字

  val o@d = 222


  def main(args: Array[String]) {
    Thread.`yield` //java中的方法和关键字有冲突，反引号就起到了作用

    val seq = 1 to 10 // 中置操作符表达式使用 1.to(10) ,中间是字母
    val seq2 = 1 -> 10 -> 100 //中间是操作符

    val num = 123
    val num2 = num.unary_- + 2 //num.unary_- 等于 -123
    var a, b = 3 //给多个变量赋值相同的值
    a = a + b //

    val nt = 1 + 3 -> 5
    val c = 12 + 2 - 3 //相同优先级的操作符时，所有操作符都是左结合的，除了：和 =

    val list1 = 1 :: 2 :: 3 :: Nil //构造列表的:: 是右结合
    val list2 = 2 :: Nil //该写法等同于下面的写法
    val list3 = Nil.::(2)

    val scores = new mutable.HashMap[String, Int]
    scores += ("joe" -> 22)
    scores("kimi") = 32
    scores.update("joe", 33) //update 应用于数组或映射

    //apply方法同样经常用于伴生对象，用来构造对象而不用显示的使用new
    val result = Fraction(2, 33)

    val author = "Jingui shi"
    val Name(first, last) = author //unapply 提取器应用，unapply 方法返回一Option【（String,String）】

    val Number(number) = "1234" //单参数字提取器

    val matchFlag = author match {
      case Name(first, last@IsCompound()) => "ddd"
      case Name(first, last) => "noe"
    }

    val sentence = "Happy new Year! what is you wish?"

    val NameSeq(one, two, three, four, five, six, seven) = sentence

   

    println(`val`)
    println(seq)
    println(seq2)
    println(num2)
    println(b)
    println(a)
    println(list1)
    println(list2)
    println(list3)
    println(scores("joe"))
    println(nt)

    println(first)
    println("单参数数字提取:" + number)
    println(one)
  }

}
