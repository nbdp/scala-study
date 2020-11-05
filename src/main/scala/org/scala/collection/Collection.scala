package org.scala.collection

import scala.collection.{SortedMap, SortedSet}

/**
 * 统一创建原则
 *
 * @author krisjin on 2017/2/23
 */
object Collection {

  def main(args: Array[String]): Unit = {
    val set1 = Set("name", "address") //set
    val map = Map("name" -> "kris", "address" -> "beijing") //map
    val sortedMap = SortedSet("hello", "world")
    println(set1)

  }
}
