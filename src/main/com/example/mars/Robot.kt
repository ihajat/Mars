package main.com.example.mars

class Robot(val position: Position, private var direction: Direction) {
    fun isDirection(direction: Direction): Boolean {
        return this.direction == direction
    }

    fun move(command: Char) {
        when (command) {
            'R' -> {
                moveRight()
            }
            'L' -> {
                moveLeft()
            }
            'F' -> {
                moveForward()
            }
        }
    }

    private fun moveRight() {
        direction = direction.turnRight()
    }

    private fun moveLeft() {
        direction = direction.turnLeft()
    }

    private fun moveForward() {
        if (direction === Direction.WEST)
        {
                this.position.xCoordinate--
        }
        else if (direction === Direction.EAST)
        {
                this.position.xCoordinate++
        }
        else if (direction === Direction.NORTH){
                this.position.yCoordinate++
        }
        else
        {
                this.position.yCoordinate--
        }
    }

    fun isPosition(xPosition: Int, yPosition: Int): Boolean {
        return position.xCoordinate == xPosition && position.yCoordinate == yPosition
    }
}