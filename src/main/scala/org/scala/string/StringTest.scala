package org.scala.string

/**
 * String operate use
 * Scala�Ľ������ڽ�����������(function arguments)ʱ�����ַ�ʽ���ȼ���������ʽ��ֵ(reduce the arguments)����Ӧ�õ������ڲ���
 * �����ǽ�δ����Ĳ������ʽֱ��Ӧ�õ������ڲ���ǰ�߽�����ֵ���ã�call-by-value�������߽����������ã�call-by-name����
 */
object StringTest {
  var money = 10
  var num = 11;

  def main(args: Array[String]) {

    val str1 = "scala";
    val str2 = "Welcome scala world!"

    //intersect������������ַ�����ͬ��һ���ַ�
    val retVal = str1.intersect(str2);
    println("intersect:" + retVal);

    //toLowerCase ���Сд��ʽ
    println("���Сд��ʽtoLowerCase��" + str1.toLowerCase());

    //toUpperCase �����д��ʽ
    println("�����д��ʽtoUpperCase��" + str1.toUpperCase());

    //concat �ַ�������
    println("Hello ".concat(str1).concat("!"))

    println("distinctȥ��:" + str1.distinct)
    println("get char:" + str1(1))
    println("scala patch:" + str1.patch(0, "K", 1))


    //����ת��
    var a: Int = 11;
    var b: Long = a.toLong;
    var c: Double = b.toDouble;
    var d: String = c.toString;
    println("����ת����" + c);
    println("����ת����" + d);

    //����������
    //val e = 8 + 5;
    var e = (8).+(5)
    println("����������:" + e)

    //�������ִ��η�ʽ
    transmitParaByName(num)
    transmitParaByValue(count)
  }

  /**
   * ���ݲ�����ʽ�������ƴ���
   * @param x
   */
  def transmitParaByName(x: => Int): Unit = {
    for (i <- 0 until 10) {
      println("�����ƴ���:" + x)
    }
  }

  /**
   * ���ݲ�����ʽ:��ֵ����
   * @param x
   */
  def transmitParaByValue(x: Int): Unit = {
    for (i <- 0 until 10) {
      println("��ֵ���Σ�" + x)
    }
  }

  /**
   * ��һ�μ�1
   */
  def drink: Unit = {
    money -= 1;
  }

  /**
   * ����
   * @return
   */
  def count: Int = {
    drink
    money
  }
}
