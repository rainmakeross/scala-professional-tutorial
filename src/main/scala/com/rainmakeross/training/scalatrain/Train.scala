package com.rainmakeross.training.scalatrain

case class Train(info:TrainInfo,  schedule: Seq[(Time, Station)]) {
  val stations: Seq[Station] = schedule.map(stop=> stop._2)
  require(schedule.length >= 2, "At least a beginning and ending station must be given")

  def timeAt(station: Station): Option[Time] = {
    // See if train stops at station by going over its schedule
    val sch1 = for {
        scheduleMember <- schedule
        if scheduleMember._2 == station
    } yield scheduleMember

    // Return option based on seq of schedule, return the very first entry
    if(sch1.nonEmpty) {
      Some(sch1.head._1)
    } else {
      None
    }

  }
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