/*
 * Copyright © 2012 - 2016 Lightbend, Inc. All rights reserved.
 */

package com.rainmakeross.training.scalatrain

import com.rainmakeross.training.scalatrain.TestData._
import org.scalatest.{Matchers, WordSpec}

class JourneyPlannerSpec extends WordSpec with Matchers {

  "stations" should {
    "be initialized correctly" in {
      planner.stations shouldEqual Set(munich, nuremberg, cologne, essen)
    }
  }
}
