package test.com.example.mars

import main.com.example.mars.Direction
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

    //Test 2: Test the robot direction is not facing a different direction to what was passed to it
    @Test
    fun testFalseDirectionReturnsFalse() {
        assertEquals(false,robot.isDirection(Direction.Companion.EAST))
    }

    //Test 3: Test the robot direction is correct after turning right
    @Test
    fun testRobotDirectionCorrectAfterTurningRight() {
        robot.move('R')
        assertEquals(true,robot.isDirection(Direction.Companion.EAST))
    }

    //Test 4: Test the robot direction is correct after turning left
    @Test
    fun testRobotDirectionCorrectAfterTurningLeft() {
        robot.move('L')
        assertEquals(true,robot.isDirection(Direction.Companion.WEST))
    }

    //Test 5: Test the robot position is correct after moving forward
    @Test
    fun testRobotPositionCorrectAfterMovingForward() {
        val robot = Robot(Position(defaultXCoordinate, defaultYCoordinate), Direction.Companion.EAST)
        robot.move("F")
        assertEquals(true,robot.isPosition(3, 2))
    }
}
