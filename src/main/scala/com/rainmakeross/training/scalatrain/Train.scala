package com.rainmakeross.training.scalatrain

case class Train(kind: String, number: Int,  schedule: Seq[(Time, Station)]) {
  val stations: Seq[Station] = schedule.map(stop=> stop._2)
  require(schedule.length >= 2, "At least a beginning and ending station must be given")
}

case class Station(name: String) {

}