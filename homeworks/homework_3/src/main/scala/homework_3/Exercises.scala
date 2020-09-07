import scala.collection._
import scala.runtime.Nothing$
package homework_3

object Exercises  {

    /**
     * Задание №1
     * Реализуйте функцию, которая принимает любой тип и преобразует его в строку.
     * Для всех типов кроме Boolean достаточно воспользоваться стандартной функцией .toString.
     * Для типа Boolean сделайте особое преобразование: true -> "правда", false -> "ложь".
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем, как определяется какой тип имеет значение переданное в аргументе.
     * Определение типа необходимо для реализации специальной логики работы с Boolean значениями, которая описана в условии выше.
     */
    def prettyBooleanFormatter1(x: Any): String = {
        stringFormater(x, checkBoolean1)
    }

    def prettyBooleanFormatter2(x: Any): String = {
        stringFormater(x, checkBoolean2)
    }

    def prettyBooleanFormatter3(x: Any): String = {
        stringFormater(x, checkBoolean3)
    }

    def checkBoolean1(x: Any): Boolean = {x == true || x == false}

    def checkBoolean2(x: Any): Boolean = x match {
       case x: Boolean => true
       case _ => false
    }

    def checkBoolean3(x: Any): Boolean = {x.isInstanceOf[Boolean]}

    def stringFormater(x: Any, isBoolean: Any => Boolean) :String =
    {
        if(isBoolean(x)){
            if(x == true){
                "правда"
            } else {
                "ложь"
            }
        } else {
            x.toString
        }
    }


    /**
     * Задание №2
     * Реализуйте функцию нахождения максимального числа в переданной коллекции интов (можно использовать все методы стандартной библиотеки).
     *
     * Реализуйте функцию тремя разными способами, отличающимися тем как функция себя ведет на пустой коллекции.
     * Обратите внимание на возвращаемые типы.
     */
    def max1(xs: Seq[Int]): Int = {
        if(xs.isEmpty) {
            0
        } else {
            xs.max
        }
    }

    def max2(xs: Seq[Int]): Seq[Int] = {
        if(xs.isEmpty) {
            Seq[Int]()
        } else {
            Seq[Int](xs.max)
        }
    }

    def max3(xs: Seq[Int]): Option[Int] = {
        xs.reduceOption(_ max _)
    }

    /**
     * Задание №3
     * Допустим дана функция sumIntegers, которая умеет суммировать числа.
     */
    def sumIntegers[CollectionType <: Iterable[Int]](xs: CollectionType): Int = xs.sum

    /**
     * Реализуйте на основе нее 3 варианта суммирования 2х чисел, отличающиеся способом передачи этих 2х чисел в функцию sumIntegers.
     * Как минимум одна из реализаций должна использовать тип данных (класс) написанный вами самостоятельно.
     */
    class customIter(x: Int, y: Int) extends Iterable[Int] {

        def iterator: Iterator[Int] = new AbstractIterator[Int] {
            private var current = 0
            def hasNext = current < 2
            def next(): Int = {
                val elem = if(current == 0) x else y
                current += 1
                elem
            }
        }
    }

    def sum1(x: Int, y: Int): Int = sumIntegers(new customIter(x, y))
    def sum2(x: Int, y: Int): Int = sumIntegers(List[Int](x, y))
    def sum3(x: Int, y: Int): Int = sumIntegers(Stream[Int](x, y))


    def sum4(x: Int, y: Int): Int = sumIntegers(new XYEnumerator(x, y))

    class XYEnumerator(x: Int, y: Int) extends Iterable[Int] {
        override def iterator: Iterator[Int] = new Iterator[Int] {
            var pos = 0

            override def hasNext: Boolean = pos < 2

            override def next(): Int = {
                val value = if (pos == 0) x else y
                pos += 1
                value
            }
        }
    }
}
