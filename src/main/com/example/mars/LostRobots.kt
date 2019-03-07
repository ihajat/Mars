package main.com.example.mars

object LostRobots {
    fun noScentsFound(robot: Robot): Boolean {
        if(lostRobots.contains(robot.position))
        {
            println("Found scent at: ${robot.position}")
        }
        return !lostRobots.contains(robot.position)
    }

    val lostRobots by lazy{
        arrayListOf<Position>()
    }

}