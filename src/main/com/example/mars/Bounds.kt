package main.com.example.mars
class Bounds(private val limit: Position) {

    fun lessThanXUpperLimit(xCoordinate: Int): Boolean {
        return xCoordinate < limit.xCoordinate
    }

    fun lessThanYUpperLimit(yCoordinate: Int): Boolean {
        return yCoordinate < limit.yCoordinate
    }
}
