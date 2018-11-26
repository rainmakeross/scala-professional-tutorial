package com.rainmakeross.training.scalatrain

object Application extends App {


  val time1 = new Time(12, 34)
  val time2 = new Time(11,34)

  println(time1.minus(time2))
  println(time1 - time2)

  val time3 = new Time()
  val time4 = new Time(minutes = 45) // 0 hour, first variable can not be left blank
  val time5 = new Time(12) // if without identifier, only first variable can be set while others become default

  println(Time.fromMinutes(360).hours)
  println(Time.fromMinutes(360).minutes)

  // Case class features
  val time6 = Time(9) // Class creation without New keyword
  Time.apply(9) // Returns the instance just like above line

  // Case classes generate toString, equals and hashCode
  println(time6 == Time.apply(9)) // True
  println(time6 == Time.apply(9,30)) // False
  println(time6.copy(minutes=30) == Time.apply(9,30)) // True Using copy method we created a new instance of Time class with 30 minutes

}
