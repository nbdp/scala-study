package org.scala.string

/**
 * String operate use
 * Scala的解释器在解析函数参数(function arguments)时有两种方式：先计算参数表达式的值(reduce the arguments)，再应用到函数内部；
 * 或者是将未计算的参数表达式直接应用到函数内部。前者叫做传值调用（call-by-value），后者叫做传名调用（call-by-name）。
 */
object StringTest {
  var money = 10
  var num = 11;

  def main(args: Array[String]) {

    val str1 = "scala";
    val str2 = "Welcome scala world!"

    //intersect方法输出两个字符串共同的一组字符
    val retVal = str1.intersect(str2);
    println("intersect:" + retVal);

    //toLowerCase 输出小写形式
    println("输出小写形式toLowerCase：" + str1.toLowerCase());

    //toUpperCase 输出大写形式
    println("输出大写形式toUpperCase：" + str1.toUpperCase());

    //concat 字符串连接
    println("Hello ".concat(str1).concat("!"))

    println("distinct去重:" + str1.distinct)
    println("get char:" + str1(1))
    println("scala patch:" + str1.patch(0, "K", 1))


    //类型转换
    var a: Int = 11;
    var b: Long = a.toLong;
    var c: Double = b.toDouble;
    var d: String = c.toString;
    println("类型转换：" + c);
    println("类型转换：" + d);

    //操作符重载
    //val e = 8 + 5;
    var e = (8).+(5)
    println("操作符重载:" + e)

    //测试两种传参方式
    transmitParaByName(num)
    transmitParaByValue(count)
  }

  /**
   * 传递参数方式：按名称传递
   * @param x
   */
  def transmitParaByName(x: => Int): Unit = {
    for (i <- 0 until 10) {
      println("按名称传参:" + x)
    }
  }

  /**
   * 传递参数方式:按值传递
   * @param x
   */
  def transmitParaByValue(x: Int): Unit = {
    for (i <- 0 until 10) {
      println("按值传参：" + x)
    }
  }

  /**
   * 喝一次减1
   */
  def drink: Unit = {
    money -= 1;
  }

  /**
   * 计数
   * @return
   */
  def count: Int = {
    drink
    money
  }
}

