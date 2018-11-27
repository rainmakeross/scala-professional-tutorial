package com.rainmakeross.training.scalatrain

case class Time(hours: Int = 0, minutes: Int = 0)  extends Ordered[Time] {
  require(hours >=0 & hours <=23, "hours is from 0 to 23")
  require(minutes >=0 & minutes <=59, "minutes is from 0 to 59")

  val asMinutes:Int = hours*60 + minutes

  def minus(that: Time) = {
    this.asMinutes - that.asMinutes
  }

  def -(that:Time) = {
    minus(that)
  }

  override val toString: String = f"$hours%02d"+":"+f"$minutes%02d"

  override def compare(that: Time): Int = {
    if(this.asMinutes > that.asMinutes) {
      1
    } else if(this.asMinutes < that.asMinutes) {
      -1
    } else {
      0
    }
  }
}

object Time {
  def fromMinutes(minutes: Int) = {
    val actualMin = minutes % 60
    val actualHrs = minutes / 60

    Time(actualHrs, actualMin)
  }
}
