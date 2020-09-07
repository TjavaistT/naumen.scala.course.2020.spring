package homework_3

object Test extends TestSuite{

    val tests = Tests{
        'prettyBooleanFormatter - {
            val trueStr = "правда"
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter1(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter1(9.23) == 9.23)

            assert(Exercises.prettyBooleanFormatter2(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter2(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter2(101L) == 101L)

            assert(Exercises.prettyBooleanFormatter3(true) == trueStr)
            assert(Exercises.prettyBooleanFormatter3(false) == falseStr)
            assert(Exercises.prettyBooleanFormatter3("some") == "some")
        },
        'max - {
            assert(max2(Seq[Int](-4, -18, -2)))
            assert(max1(Seq[Int]()))

            assert(max2(Seq[Int](-4, -18, -2)))
            assert(max2(Seq[Int]()))

            assert(max3(Seq[Int](-4, -18, -2)))
            assert(max3(Seq[Int]()))
        },
        'sum - {
            println(sum1(3, 4))
            println(sum2(3, 4))
            println(sum3(3, 4))
        }
    }
}
