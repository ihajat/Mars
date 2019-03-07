package test.com.example.mars

import main.com.example.mars.Bounds
import main.com.example.mars.Direction
import main.com.example.mars.Position
import main.com.example.mars.Robot
import org.junit.Assert.assertEquals
import org.junit.Test

class RobotTest {
    private val xUpperLimit = 5
    private val yUpperLimit = 3
    private val bounds = Bounds(Position(xUpperLimit,yUpperLimit))
    private val defaultXCoordinate = 1
    private val defaultYCoordinate = 1
    private val robot = Robot(bounds, Position(defaultXCoordinate, defaultYCoordinate), Direction.Companion.EAST)

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

        robot.move('F')
        assertEquals(true,robot.isPosition(2, 1))
    }

    //Test 6: Test the robot position is incorrect after moving forward
    @Test
    fun testRobotPositionIncorrectAfterMovingForward() {

        robot.move('F')
        assertEquals(false,robot.isPosition(1, 1))
    }

    //Test 7: Test the robot position is correct after turning left and moving forward
    // By passing the combination of moves separately
    @Test
    fun testRobotPositionCorrectAfterTurningRightAndMovingForwardSeparately() {
        robot.move('R')
        robot.move('F')
        assertEquals(true,robot.isPosition(1, 0))
    }

    //Test 8: Test the robot position is correct after turning left and moving forward
    // By passing the combination of moves in one call
    @Test
    fun testRobotPositionCorrectAfterTurningRightAndMovingForwardTogether() {
        robot.move("RF")
        assertEquals(true,robot.isPosition(1, 0))
    }

    //Test 9: Test the robot doesn't move beyond West Bound
    @Test
    fun tesRobotDoeNotMoveBeyondWestBound() {
        //Given the Robot is Facing East, starting at co-ordinates ( 1, 1 )

        //Then Turn West And Move forward beyond the Western Boundary
        robot.move("RRFFFFFF")

        println(robot.position)
        assertEquals(true,robot.isPosition(0, 1))
    }

    //Test 10: Test the robot doesn't move beyond East Bound
    @Test
    fun tesRobotDoeNotMoveBeyondEastBound() {
        //Given the Robot is Facing East, starting at co-ordinates ( 1, 1 )

        //Then Turn West And Move forward beyond the Eastern Boundary
        robot.move("FFFFFF")

        println(robot.position)
        assertEquals(true,robot.isPosition(5, 1))
    }

    //Test 11: Test the robot doesn't move beyond North Bound
    @Test
    fun tesRobotDoeNotMoveBeyondNorthBound() {
        //Given the Robot is Facing East, starting at co-ordinates ( 1, 1 )

        //Then Turn North And Move forward beyond the Northen Boundary
        robot.move("LFFFFFF")

        println(robot.position)
        assertEquals(true,robot.isPosition(1, 3))
    }

    //Test 12: Test the robot doesn't move beyond South Bound
    @Test
    fun tesRobotDoeNotMoveBeyondSouthBound() {
        //Given the Robot is Facing East, starting at co-ordinates ( 1, 1 )

        //Then Turn North And Move forward beyond the Southern Boundary
        robot.move("RFFFFFF")

        // println(robot.position)
        assertEquals(true,robot.isPosition(1, 0))
    }

    //Test 13: Test the robot checks for previously lost robots , to prevent it from being lost
    @Test
    fun tesRobotChecksForPreviousLostRobots() {

        // Given 3 Robots, if the second robot is lost,
        // the third robot will checks for previously lost robots ,
        // to prevent it from being lost

        val robot1 = Robot(bounds, Position(1,1), Direction.Companion.EAST)
        val robot2 = Robot(bounds, Position(3,2), Direction.Companion.NORTH)
        val robot3 = Robot(bounds, Position(0,3), Direction.Companion.WEST)

        robot1.move("RFFFFFF")

        robot2.move("FRRFLLFFRRFLL")

        robot3.move("LLFFFLFLFL")

        assertEquals(true,robot1.isPosition(1, 1))
        assertEquals(true,robot1.isDirection(Direction.Companion.EAST))
        assertEquals(true,robot2.isPosition(3, 3))
        assertEquals(true,robot2.isDirection(Direction.Companion.NORTH))
        assertEquals(true,robot2.isLost())
        assertEquals(true,robot3.isPosition(2, 3))
        assertEquals(true,robot3.isDirection(Direction.Companion.SOUTH))

    }
}
