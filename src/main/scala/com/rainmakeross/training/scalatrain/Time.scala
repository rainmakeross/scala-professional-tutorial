package com.rainmakeross.training.scalatrain

class Time(val hours: Int = 0, val minutes: Int = 0) {
  // TODO verify hours is from 0 to 23
  // TODO verify minutes is from 0 to 59

  val asMinutes:Int = hours*60 + minutes

  def minus(that: Time) = {
    this.asMinutes - that.asMinutes
  }

  def -(that:Time) = {
    minus(that)
  }
}

object Time {
  def fromMinutes(minutes: Int) = {
    val actualMin = minutes % 60
    val actualHrs = minutes / 60

    new Time(actualHrs, actualMin)
  }
}
