import zio._
import zio.Console._
import scala.io.BufferedSource

object MyApp extends ZIOAppDefault {

  def acquire = ZIO.attempt(scala.io.Source.fromFile("src/test/resources/day1_input.txt"))
  def release = (buffer :BufferedSource) => ZIO.succeed(buffer.close)
  def process = (buffer :BufferedSource)=> ZIO.attempt(buffer.getLines.toList)
  val readFile : Task[List[String]] = ZIO.acquireReleaseWith(acquire)(release)(process)

  def calories(snacks:List[String]) =
    val fold = snacks.foldRight((List[Int](),0))((str,state) => (str,state) match
      case ("",(l,a)) => (a::l,0)
      case (v,(l,a)) => (l, a+v.toInt)
    )
    fold._2::fold._1

  def run =
    for {
      v    <- readFile
      c = calories(v)
      _    <- printLine(s"part1 = ${c.reduce(math.max)}")
      _    <- printLine(s"part2 = ${c.sortBy((x) => -x).take(3).sum}")
    } yield ()
}