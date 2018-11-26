/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.rainmakeross.training.scalatrain

import com.rainmakeross.training.scalatrain.TestData._
import org.scalatest.{Matchers, WordSpec}

class TrainSpec extends WordSpec with Matchers {

  "Creating a Train" should {
    "throw an IllegalArgumentException for a schedule with 0 or 1 elements" in {
      an[IllegalArgumentException] should be thrownBy Train("ICE", 724, Vector())
      an[IllegalArgumentException] should be thrownBy Train("ICE", 724, Vector(ice724MunichTime -> munich))
    }
  }

  "stations" should {
    "be initialized correctly" in {
      ice724.stations shouldEqual Vector(munich, nuremberg, cologne)
    }
  }
}
