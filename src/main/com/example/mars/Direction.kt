package main.com.example.mars

data class Direction(private val direction: String) {

    private val INVALID_DIRECTION = "Invalid direction?"

    companion object {
        val WEST = Direction("W")
        val SOUTH = Direction("S")
        val EAST = Direction("E")
        val NORTH = Direction("N")
    }

    fun turnRight(): Direction {
        when (direction) {
            "E" -> return SOUTH
            "S" -> return WEST
            "N" -> return EAST
            "W" -> return NORTH
            else -> throw RuntimeException(INVALID_DIRECTION)
        }
    }

    fun turnLeft(): Direction {
        when (direction) {
            "N" -> return WEST
            "W" -> return SOUTH
            "S" -> return EAST
            "E" -> return NORTH
            else -> throw RuntimeException(INVALID_DIRECTION)
        }
    }
}