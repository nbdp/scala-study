package org.scala.base

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

/**
 * 数组示例测试
 * User: shijingui
 * Date: 2017/1/23
 */
object ArrayTest {
  def main(args: Array[String]) {
    //初始创建一个指定长度的数组,数组的长度是固定的，不容易扩展
    val array1 = new Array[String](3);
    val array2 = Array("what", "is", "your")
    array1(0) = "what"
    array1(1) = "is"
    array1(2) = "your"
    //array1(3)="name"//执行到这儿就会报数组越界的异常
    for (i <- array1) print(i + " ")
    println()

    for (i <- array2) print(i + " ")
    println()


    val arrBuf = new ArrayBuffer[Int]()
    ArrayBuffer()
    for (i <- 1 to 10) arrBuf += i
    println(arrBuf)
    arrBuf +=(11, 12, 13, 14)
    println(arrBuf)
    arrBuf ++= Array(15, 16, 17, 18)
    println(arrBuf)
    arrBuf.trimStart(3)
    arrBuf.trimEnd(5);
    println(arrBuf)
    arrBuf.insert(0, 1)
    println(arrBuf)
    arrBuf.insert(1, 2, 3)
    println(arrBuf)
    arrBuf.remove(arrBuf.length - 1)
    println(arrBuf)
    arrBuf.remove(arrBuf.head, 3)
    println(arrBuf)
    val convertArr = arrBuf.toArray;
    println(convertArr.getClass.getCanonicalName)
    val convertArrBuf = convertArr.toBuffer
    convertArrBuf +=(13, 14, 15)
    println(convertArrBuf)
    convertArrBuf.clear()
    arrBuf.insert(1, 2, 3, 4)
    arrBuf.trimEnd(2)
    println(arrBuf)
    println(convertArrBuf)
    for (i <- 0 until(arrBuf.length, 2)) print(i + " ")
    println()

    for (j <- (0 until arrBuf.length).reverse) print(arrBuf(j) + " ")

    val eles = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val newArr = for (ele <- eles) yield ele * 2
    println()
    print("原始集合：")
    for (e <- eles) print(e + " ")
    println()
    print("产生的新集合：")
    for (e <- newArr) print(e + " ")

    val conditionOper = for (e <- eles if e % 2 == 0) yield e * 2
    println()
    for (c <- conditionOper) print(c + " ")

    val filterArr = eles.filter(_ % 2 == 0).map(2 * _)
    println()
    for (e <- filterArr) print(e + " ")

    test2()
    test3()
    arrayAlgorithms()
  }

  def test2() {
    var arr = new ArrayBuffer[Int]()
    arr +=(1, 2, 3, -4, 5, 6, -7, 8, 9, -10)
    var first = true
    var n = arr.length
    var i = 0
    while (i < n) {
      if (arr(i) >= 0) i += 1
      else {
        if (first) {
          first = false;
          i += 1
        } else {
          arr.remove(i)
          n -= 1
        }
      }
    }
    println("\n" + arr)
  }

  def test3() {
    var arr = new ArrayBuffer[Int]()
    arr +=(1, 2, 3, -4, 5, 6, -7, 8, 9, -10, 33, -322, 32, -123, 789)
    var first = true
    val indexes = for (i <- 0 until arr.length if first || arr(i) >= 0) yield {
      if (arr(i) < 0) first = false
      i
    }
    for (j <- 0 until indexes.length) arr(j) = arr(indexes(j))
    arr.trimEnd(arr.length - indexes.length)
    println(arr)
  }

  def arrayAlgorithms() {
    val arr = Array(9, 8, 7, 6, 5, 4, 3, 2, 1)
    val arrBuf = ArrayBuffer(1, 9, 6, 4, 3, 8, 7, 5, 2, 10)
    val strArr = Array("year", "month", "day", "zoo")
    val newArr = arr.sorted
    val newArrBuf = arrBuf.sorted
    val arrSum = arr.sum
    val newArrBufSum = arrBuf.sum
    val arrMaxVal = arr.max
    val arrMinVal = arr.min
    val arrBufMaxVal = arrBuf.max
    val desc = ArrayBuffer(1, 2, 3, 44, 62, 3, 0).sortWith(_ > _)
    val newStrArr = strArr.sorted
    val descNewStrArr = strArr.sortWith(_ > _)
    val arryQuickSort = Sorting.quickSort(arr)
    println("Array Sort=" + newArr.mkString(" "))
    println("ArrayBuffer Sort=" + newArrBuf.mkString(" "))
    println("Array Sum()=" + arrSum)
    println("ArrayBuffer Sum()=" + newArrBufSum)
    println("Array Max()=" + arrMaxVal)
    println("Array Min()=" + arrMinVal)
    println("ArrayBuffer Max()=" + arrBufMaxVal)
    println("ArrayBuffer desc()=" + desc.mkString(" "))
    println("String Array Sort=" + newStrArr.mkString(" "))
    println("String Array Sort Desc=" + descNewStrArr.mkString(" "))
    Sorting.quickSort(arr)
    println("Array quick sort=" + arr.mkString(" "))
  }


}
