package blatt6

case class Rocket(name: String, stages: Int, fuel: String)

object Main {
  def printRocket(rocket: Rocket): Unit = {
    println(rocket.name + ", Stages=" + rocket.stages + ", Fuel=" + rocket.fuel);
  }

  def printIf2Stages(rocket: Rocket) = {
    if(rocket.stages == 2) {
      printRocket(rocket)
    }
  }

  def printIfLH2LOX(rocket: Rocket) = {
    if(rocket.fuel.contains("LOX") && rocket.fuel.contains("LH2")) {
      printRocket(rocket)
    }
  }

  def printIfLOX(rocket: Rocket) = {
    if(rocket.fuel.contains("LOX")) {
      printRocket(rocket)
    }
  }

  def main(args: Array[String]): Unit = {
    val rockets = List(
      Rocket("Saturn V", 3, "LH2"),
      Rocket("Falcon 9", 2, "LH2, LOX"),
      Rocket("Falcon Heavy", 2, "RP-1"),
      Rocket("Falcon Starship", 2, "LOX"),
      Rocket("Ariane 5", 3, "LH2, LOX")
    )

    println("All rockets with 2 stages:")
    for (rocket <- rockets) {
      printIf2Stages(rocket)
    }

    println("All rockets with LH2/LOX:")
    for (rocket <- rockets) {
      printIfLH2LOX(rocket)
    }

    println("All rockets that use LOX as oxidizer:")
    for (rocket <- rockets) {
      printIfLOX(rocket)
    }
  }
}