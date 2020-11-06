package org.scala.example.higherfunc

/** 高阶函数
  * _可以将方法转换成函数
  * User: krisjin
  * Date: 2017/1/25
  */
object HigherOrderFunc {
  val num = 3.14
  val fun = math.ceil _ //将函数赋值给一个常量

  def main(args: Array[String]) {
    val value1 = fun(num) //调用函数

    val value2 = Array(3.14, 2.12, 4.3, 5.6, 1.3).map(fun) //将fun传递给另一个函数,map方法接受一个函数参数，将它应用于数组中的所有值，然后返回结果的数组

    val triple = (x: Double) => x * 3 //创建一个匿名函数，存放到一个常量中

    val value3 = Array(3.1, 2.3, 4.3, 5.4).map(x => x * 3).map(fun) //使用匿名函数 ,该匿名函数是简写方式，只有一个参数可以，类型推断

    val value4 = valueAtOneQuarter(math.ceil _)

    val value5 = mulBy(5)
    //高阶函数产出函数
    val value6 = value5(5)

    val value7 = valueAtOneQuarter(3 * _)

    val value8 = (1 to 9).map(0.1 * _).map(_ formatted ("%.1f")) //map 高阶函数应用,将匿名函数应用到集合中的所有元素

    (1 to 9).map("*" * _).foreach(println _) //foreach 没有返回值

    val value9 = (1 to 9).filter(_ % 2 == 0) //filter 方法输出所有匹配特定条件的元素

    val value10 = (1 to 9).reduceLeft(_ * _) //reduceLeft 方法接受一个二元的函数——即一个带有两个参数的函数

    val value11 = "Happy new year , what is you wish".split(" ").sortWith(_.length < _.length) //输出一个按长度递增排序的数组

    //********闭包********* 每一个返回的函数都有自己的factor的设置
    val value12 = mulBy(3)
    //闭包
    val value13 = mulBy(0.5)
    //闭包
    val value14 = value12(9)
    val value15 = value13(14)
    //********闭包********

    //********柯里化*******
    val value16 = (x: Int, y: Int) => x * y //接受两个参数的函数

    val value17 = mulOneAtATime(6)(7)
    //计算两个数的乘积
    val arr1 = Array("Hello", "World")
    val arr2 = Array("hello1", "World")
    val value18 = arr1.corresponds(arr2)(_.equalsIgnoreCase(_))

    test1
    val value19 = indexOf("hello", 'h')
    //********柯里化*******


    println(value1)
    println(math.floor(num))
    println("函数传递：" + value2.mkString(" "))
    println("匿名函数" + value3.mkString(" "))
    println("高阶函数:" + value4)
    println("高阶函数产出函数，调用：" + value6)
    println(value7)
    println("map 高阶函数" + value8)
    println("filter 方法输出所有匹配特定条件的元素:" + value9)
    println("reduceLeft:" + value10)
    println("sortWith:" + value11.mkString(" "))

    println("闭包:" + value14)
    println("闭包:" + value15)

    println(value16(3, 6))
    println("计算两个数的乘积：" + value17)
    println("Array柯里化corresponds是否一致：" + value18)
    println("柯里化：" + value19)
  }

  def triple(x: Double) = 3 * x //等同于上面的匿名函数

  /**
    * 代函数参数的函数，（参数类型）=>结果类型
    * 由于该函数是一个接受函数参数的函数，因此它被称为高阶函数
    *
    * @param f
    * @return
    */
  def valueAtOneQuarter(f: Double => Double) = f(0.01)

  /**
    * 高阶函数也可以产出另一个函数
    * 调用 mulBy(5)返回 (x:Double) =>5*x
    *
    * @param factor
    * @return
    */
  def mulBy(factor: Double) = (x: Double) => factor * x

  /**
    * 该函数接受一个参数，生成另一个接受单个参数的函数，柯里化函数
    *
    * @param x
    * @return
    */
  def mulOneAtATime(x: Int) = (y: Int) => x * y

  /**
    * 简写
    *
    * @param x
    * @param y
    * @return
    */
  def mulOneAtATime2(x: Int)(y: Int) = x * y

  def runInThread(block: () => Unit) {
    new Thread {
      override def run(): Unit = {
        block
      }
    }.start()
  }

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }

  def test1: Unit = {
    var x = 10
    until(x == 0) {
      x -= 1
      println("柯里化：：：：" + x)
    }
  }

  def indexOf(str: String, ch: Char): Int = {
    var i = 0
    until(i == str.length) {
      if (str(i) == ch) return i
      i += 1
    }
    return -1
  }
}
