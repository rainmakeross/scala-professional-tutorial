package com.rainmakeross.training.scalatrain

import play.api.libs.json._

import scala.util.{Failure, Success, Try}

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

  def toJson(): JsValue = {
    Json.obj("hours" -> hours, "minutes" -> minutes)
  }




}

object Time {
  def fromMinutes(minutes: Int) = {
    val actualMin = minutes % 60
    val actualHrs = minutes / 60

    Time(actualHrs, actualMin)
  }

  def fromJson(jsVal: JsValue): Option[Time] = {
    val hours = Try((jsVal \ "hours").as[Int]) match {
      case Success(n) => n
      case Failure(e) => -1
    }

    val minutes = Try((jsVal \ "minutes").as[Int]) match {
      case Success(n) => n
      case Failure(e) => 0
    }

    hours match {
      case -1 => None
      case _ => Some(Time(hours, minutes))
    }
  }
}
