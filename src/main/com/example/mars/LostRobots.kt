package main.com.example.mars

object LostRobots {
    fun noScentsFound(robot: Robot): Boolean {
        return !lostRobots.contains(robot.position)
    }

    val lostRobots by lazy{
        arrayListOf<Position>()
    }

}