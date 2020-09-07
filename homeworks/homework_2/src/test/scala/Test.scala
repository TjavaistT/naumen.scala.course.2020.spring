import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_divBy3Or7 - {
            assert(Exercises.divBy3Or7(1, 3) == Seq(3))
            assert(Exercises.divBy3Or7(5, 9) == Seq(6, 7, 9))
            assert(Exercises.divBy3Or7(0, 100) == Seq(0, 3, 6, 7, 9, 12, 14, 15, 18, 21, 24, 27, 28, 30, 33, 35, 36, 39, 42, 45, 48, 49, 51, 54, 56, 57, 60, 63, 66, 69, 70, 72, 75, 77, 78, 81, 84, 87, 90, 91, 93, 96, 98, 99))
        },
        'sumOfDivBy3Or5' - {
            assert(sumOfDivBy3Or5(1, 3) == 3)
            assert(sumOfDivBy3Or5(5, 9) == (5 + 6 + 9))
            assert(sumOfDivBy3Or5(0, 20) == (3 + 5 + 6 + 9 + 10 + 12 + 15 + 18 + 20))
        },
        'primeFactor' - {
            assert(primeFactor(98) == Seq[Int](2, 7, 7))
            assert(primeFactor(80) == Seq[Int](2, 2, 2, 2, 5))
            assert(primeFactor(21) == Seq[Int](3, 7))
        },
        'sumByFunc' - {
            assert(sumScalars(Vector2D(1, 2), Vector2D(3, 4), Vector2D(5, 6), Vector2D(7, 8)) == 94)
            assert(sumCosines(Vector2D(9, 9), Vector2D(9, 9), Vector2D(9, 9), Vector2D(9, 9)) == 2)
        },
        'sortByHeavyweight' - {
            var resultMaterials: Seq[String] = Seq[String](
                "Magnesium",
                "Cobalt",
                "Plutonium",
                "Potassium",
                "Gold",
                "Silver",
                "Tin",
                "Zirconium",
                "Tungsten",
                "Nickel",
                "Graphite",
                "Chrome",
                "Lithium",
                "Iron",
                "Copper",
                "Sodium",
                "Calcium",
                "Uranium",
                "Cesium",
                "Platinum",
                "Titanium",
                "Aluminum",
                "Lead"
            );

            assert(sortByHeavyweight(balls) == resultMaterials)
        },
    }
}
