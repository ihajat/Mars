package test.com.example.mars

import main.com.example.mars.Bounds
import main.com.example.mars.Position

import org.junit.Assert.*
import org.junit.jupiter.api.Test

class BoundsTest {
    private var bounds = Bounds(Position(2, 2))

    //Test 1: Test the Bounds, independently of the robot , to test the X upper limit
    @Test
    fun returnTrueInsideXUpperLimit() {
        assertEquals(true,bounds.lessThanXUpperLimit(1))
    }

    //Test 2: Test the Bounds, independently of the robot , to test the X upper limit
    @Test
    fun returnTrueNotInsideXUpperLimit() {
        assertEquals(false,bounds.lessThanXUpperLimit(2))
    }

    //Test 3: Test the Bounds, independently of the robot , to test the y upper limit
    @Test
    fun returnTrueInsideYUpperLimit() {
        assertEquals(true,bounds.lessThanYUpperLimit(1))
    }

    //Test 4: Test the Bounds, independently of the robot , to test the y upper limit
    @Test
    fun returnTrueNotInsideYUpperLimit() {
        assertEquals(false,bounds.lessThanYUpperLimit(2))
    }

    //Test 5: Test the Bounds, independently of the robot , to test the X lower limit
    @Test
    fun returnTrueInsideXLowerLimit() {
        assertEquals(true,bounds.greaterThanXLowerLimit(1))
    }

    //Test 6: Test the Bounds, independently of the robot , to test the X lower limit
    @Test
    fun returnTrueNotInsideXLowerLimit() {
        assertEquals(false,bounds.greaterThanXLowerLimit(0))
    }

    //Test 7: Test the Bounds, independently of the robot , to test the Y lower limit
    @Test
    fun returnTrueInsideYLowerLimit() {
        assertEquals(true,bounds.greaterThanYLowerLimit(1))
    }

    //Test 8: Test the Bounds, independently of the robot , to test the Y lower limit
    @Test
    fun returnTrueNotInsideYLowerLimit() {
        assertEquals(false,bounds.greaterThanYLowerLimit(0))
    }
}