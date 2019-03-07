package test.com.example.mars

import main.com.example.mars.Direction
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test

class DirectionTest {

    @Before
    fun setUp() {
    }

    //Test 1: Test the direction independently of the robot , to test the direction turn : Right
    @Test
    fun testRightTurnFromNorthToEast() {
        val direction = Direction("N")
        val expectedDirection = Direction("E")
        val actualDirection : Direction = direction.turnRight()

        assertEquals(actualDirection.equals(expectedDirection),true)
    }

}