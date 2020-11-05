package org.scala.array

/**
 *
 * User:krisjin
 * Date:2019-09-26
 */
object Test {
  val str = "z 5:0.0 10:0.0 42:0.0 24:0.0 37:0.0 25:0.0 14:0.0 20:0.0 29:0.0 1:0.0 6:0.0 28:0.0 38:0.0 21:0.0 33:0.0 9:0.0 13:0.0 41:0.0 2:0.0 32:0.0 34:0.0 45:0.0 17:0.0 22:0.0 44:0.0 27:0.0 12:0.0 7:0.0 39:0.0 3:0.0 35:0.0 18:0.0 16:\n" + "0.0 31:0.0 11:0.0 43:0.0 40:0.0 26:0.0 23:0.0 8:0.0 36:0.0 30:0.0 19:0.0 4:0.0 15:0.0\n" + "n 5:0.0 10:0.0 42:0.0 24:0.0 37:0.0 25:0.0 14:0.0 20:0.0 29:0.0 1:0.0 6:0.0 28:0.0 38:0.0 21:0.0 33:0.0 9:0.0 13:0.0 41:0.0 2:0.0 32:0.0 34:0.0 45:0.0 17:0.0 22:0.0 44:0.0 27:0.0 12:0.0 7:0.0 39:0.0 3:0.0 35:0.0 18:0.0 16:\n" + "0.0 31:0.0 11:0.0 43:0.0 40:0.0 26:0.0 23:0.0 8:0.0 36:0.0 30:0.0 19:0.0 4:0.0 15:0.0\n" + "w 1:2"

  def main(args: Array[String]): Unit = {
    val aa = sparseModel(parseModel(str), "w")
    println(1)
  }

  def sparseModel(modelStr: Array[String], flag: String): Array[(Long, Double)] = {
    modelStr.filter(str => str.contains(flag))(0)
      .split(" ")
      .tail
      .map { idVal =>
        val idValArr = idVal.split(":")
        (idValArr(0).toLong, idValArr(1).toDouble)
      }
  }


  def parseModel(str: String): Array[String] = {
    val model = new Array[String](3)
    val nIndex = str.indexOf("n")
    val wIndex = str.indexOf("w")
    val zStr = str.substring(0, nIndex)
    val nStr = str.substring(nIndex, wIndex)
    val wStr = str.substring(wIndex)
    model(0) = zStr.trim
    model(1) = nStr.trim
    model(2) = wStr.trim
    model
  }

}
