package com.rainmakeross.training.scalatrain

case class Train(info:TrainInfo,  schedule: Seq[(Time, Station)]) {
  val stations: Seq[Station] = schedule.map(stop=> stop._2)
  require(schedule.length >= 2, "At least a beginning and ending station must be given")
}

case class Station(name: String) {

}

sealed abstract class TrainInfo {
  def number : Int
}

case class InterCityExpress(number:Int, hasWifi: Boolean = false) extends TrainInfo {

}

case class RegionalExpress(number:Int) {

}

case class BavarianRegional(number:Int) {

}