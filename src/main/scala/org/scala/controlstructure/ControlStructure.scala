package org.scala.controlstructure

/**
 * 控制结构和函数
 * User: shijingui
 * Date: 2017/2/4
 */
object ControlStructure {

  def main(args: Array[String]) {

    //if表达式有值
    val x = 1
    val v1 = if (x > 0) 1 else 0
    //不带else的if表达式
    val v2 = if (x > 0) 1 else ()

    //scala同样拥有与java一样的for循环和while
    val v3 = "Hello"
    for (i <- 1 to 10) print(i + " ") // <- 左边是变量，右边是表达式，左边的变量并没有定义具体的类型，类型推断根据右边的集合中的类型
    println()

    for (i <- 0 until v3.length) print(v3(i) + " ") //until 返回一个不包含上限的区间
    for (i <- v3) print(i + " ") //直接遍历字符串序列
    println()
    for (i <- 1 to 3; j <- 1 to 3) print((i * 10) + j + " ") //使用多个生成器
    for (i <- 1 to 3; j <- 1 to 3 if i != j) println((i * 10 + j) + " ") //使用守卫条件判断
    for (i <- 1 to 10) yield i * 10 // 循环体一yield开始，则该循环会构造一个集合，每次迭代生成集合中的一个值，这类循环叫for推导式

  }
}
