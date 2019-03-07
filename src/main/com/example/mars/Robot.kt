package main.com.example.mars

class Robot(private var direction: Direction) {
    fun isDirection(direction: Direction): Boolean {
        return this.direction == direction
    }
}