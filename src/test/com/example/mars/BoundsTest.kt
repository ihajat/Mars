package test.com.example.mars

import main.com.example.mars.Bounds
import main.com.example.mars.Position

import org.junit.Assert.*
import org.junit.jupiter.api.Test

class BoundsTest {
    private var bounds = Bounds(Position(2, 2))

    //Test 1: Test the Bounds, independently of the robot , to test the X upper limit
    @Test
    fun return_true_on_IsInsideXUpperLimit() {
        assertEquals(true,bounds.lessThanXUpperLimit(1))
    }

    //Test 2: Test the Bounds, independently of the robot , to test the X upper limit
    @Test
    fun return_true_on_IsNotInsideXUpperLimit() {
        assertEquals(false,bounds.lessThanXUpperLimit(2))
    }
}