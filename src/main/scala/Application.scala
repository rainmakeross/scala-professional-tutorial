import com.lightbend.training.scalatrain.Train
import com.rainmakeross.training.scalatrain.{Time, Train}

object Application extends App {
  val train1 = new Train(10, kind="single track")
  println(train1.number)

  val time1 = new Time(12, 34)
  val time2 = new Time(11,34)

  println(time1.minus(time2))
  println(time1 - time2)

  val time3 = new Time()
  val time4 = new Time(minutes = 45) // 0 hour, first variable can not be left blank
  val time5 = new Time(12) // if without identifier, only first variable can be set while others become default

  println(Time.fromMinutes(360).hours)
  println(Time.fromMinutes(360).minutes)

}
