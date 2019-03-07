package main.com.example.mars

data class Direction(private val direction: String) {
    companion object {
        val WEST = Direction("W")
        val SOUTH = Direction("S")
        val EAST = Direction("E")
        val NORTH = Direction("N")
    }
}