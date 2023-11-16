import org.junit.Test
import org.junit.Assert._

class Day1Test {
  val snacks = List("1000","2000","3000","","4000","","5000","6000","","7000","8000","9000","","10000")

  val calories = MyApp.calories(snacks)


  @Test def testPart1(): Unit = {
    assertEquals(24000, MyApp.part1(calories))
  }

  @Test def testPart2(): Unit = {
    assertEquals(45000, MyApp.part2(calories))
  }
}