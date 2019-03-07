package main.com.example.mars
class Bounds(private val limit: Position) {

    fun lessThanXUpperLimit(xCoordinate: Int): Boolean {
        return xCoordinate < limit.xCoordinate
    }

    fun lessThanYUpperLimit(yCoordinate: Int): Boolean {
        return yCoordinate < limit.yCoordinate
    }

    fun greaterThanXLowerLimit(xCoordinate: Int): Boolean {
        return xCoordinate > LOWER_LIMIT
    }

    fun greaterThanYLowerLimit(yCoordinate: Int): Boolean {
        return yCoordinate > LOWER_LIMIT
    }

    fun xUpperLimit(): Int {
        return limit.xCoordinate
    }

    fun yUpperLimit(): Int {
        return limit.yCoordinate
    }

    companion object {
        val LOWER_LIMIT = 0
    }
}
