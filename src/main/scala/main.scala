import zio._
import zio.Console._
import scala.io.BufferedSource

object MyApp extends ZIOAppDefault {

  def acquire = ZIO.attempt(scala.io.Source.fromFile("src/test/resources/day1_input.txt"))
  def release = (buffer :BufferedSource) => ZIO.succeed(buffer.close)
  def process = (buffer :BufferedSource)=> ZIO.attempt(buffer.getLines.toList)
  val readFile : Task[List[String]] = ZIO.acquireReleaseWith(acquire)(release)(process)

  def run =
    for {
      v    <- readFile
      _    <- printLine(v)
    } yield ()
}