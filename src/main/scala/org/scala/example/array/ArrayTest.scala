package org.scala.example.array

import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting

/**
 * User: krisjin
 * Date: 2017/1/23
 */
object ArrayTest {
  def main(args: Array[String]) {

    val arr1 = new Array[String](4)
    val arr2 = Array("what", "is", "your")

    //array set value
    arr1(0) = "what"
    arr1(1) = "is"
    arr1(2) = "your"

    for (i <- arr1) print(i + " ")
    println()

    for (i <- arr2) print(i + " ")
    println()


    val arrBuf = new ArrayBuffer[Int]()
    ArrayBuffer()
    for (i <- 1 to 10) arrBuf += i
    println(arrBuf)

    //delete element with index
    arrBuf -= arrBuf(1)
    println(arrBuf)

    arrBuf += (11, 12, 13, 14)
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
    convertArrBuf += (13, 14, 15)
    println(convertArrBuf)


    convertArrBuf.clear()
    arrBuf.insert(1, 2, 3, 4)
    arrBuf.trimEnd(2)

    println(arrBuf)
    println(convertArrBuf)

    for (i <- 0 until(arrBuf.length, 2)) print(i + " ")
    println()

    for (j <- (0 until arrBuf.length).reverse) print(arrBuf(j) + " ")

    val arrEle = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val newArr = for (ele <- arrEle) yield ele * 2

    println()
    for (e <- arrEle) print(e + " ")
    println()

    for (e <- newArr) print(e + " ")

    val conditionOper = for (e <- arrEle if e % 2 == 0) yield e * 2
    println()
    for (c <- conditionOper) print(c + " ")

    val filterArr = arrEle.filter(_ % 2 == 0).map(2 * _)
    println()
    for (e <- filterArr) print(e + " ")

    test2()
    test3()
    arrayAlgorithms()


    val cc = new Array[String](3)
    cc(0) = "z 5:-1695.1587556681664 10:0.0 42:0.0 24:0.0 37:0.0 25:0.0 14:0.0 20:0.0 29:0.0 1:-56.69287399200037 6:-2265.3677855392025 28:0.0 38:0.0 21:0.0 33:0.0 9:0.0 13:0.0 41:0.0 2:-595.027916705325 32:0.0 34:0.0 45:0.0 17:0.0 22:0.0 44:0.0 27:0.0 12:0.0 7:0.0 39:0.0 3:-685.187375077008 35:0.0 18:0.0 16:0.0 31:0.0 11:0.0 43:0.0 40:0.0 26:0.0 23:0.0 8:0.0 36:0.0 30:0.0 19:0.0 4:-139.76111604978044 15:0.0"
    cc(1) = "n 5:1021.832473341197 10:0.0 42:0.0 24:0.0 37:0.0 25:0.0 14:0.0 20:0.0 29:0.0 1:21.502844130530338 6:2133.0616063929892 28:0.0 38:0.0 21:0.0 33:0.0 9:0.0 13:0.0 41:0.0 2:238.4056124502143 32:0.0 34:0.0 45:0.0 17:0.0 22:0.0 44:0.0 27:0.0 12:0.0 7:0.0 39:0.0 3:468.40528958713696 35:0.0 18:0.0 16:0.0 31:0.0 11:0.0 43:0.0 40:0.0 26:0.0 23:0.0 8:0.0 36:0.0 30:0.0 19:0.0 4:81.44714383761003 15:0.0"
    cc(2) = "w 5:5.140262228251576 1:1.0021553428806347 6:4.799796482614516 2:3.6164975596020454 3:3.024311429246889 4:1.3917668188372723"
    println(cc.mkString("\n"))
  }

  def test2() {
    var arr = new ArrayBuffer[Int]()
    arr += (1, 2, 3, -4, 5, 6, -7, 8, 9, -10)
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
    arr += (1, 2, 3, -4, 5, 6, -7, 8, 9, -10, 33, -322, 32, -123, 789)
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
