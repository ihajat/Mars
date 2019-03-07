package test.com.example.mars

import main.com.example.mars.Robot
import org.junit.Assert.assertEquals
import org.junit.Test

class RobotTest {

    private val robot = Robot( Direction.Companion.NORTH)

    //Test 1: Test the robot direction is same as what is passed in to the
    @Test
    fun testOriginalDirection() {
        assertEquals(true,robot.isDirection(Direction.Companion.NORTH))
    }

}
