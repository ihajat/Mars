package main.com.example.mars

class Robot(private val bounds: Bounds, val position: Position, private var direction: Direction) {

    private var lost = false

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
                if(!lost)moveForward()
            }
        }
    }
    fun move(moves: String) {
        for (code in moves.toCharArray()) {
            move(code)
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
            if (bounds.greaterThanXLowerLimit(position.xCoordinate)) {
                this.position.xCoordinate--
            }
            else
            {
                lost = true
                this.position.xCoordinate = Bounds.LOWER_LIMIT
            }
        }
        else if (direction === Direction.EAST)
        {
            if (bounds.lessThanXUpperLimit(position.xCoordinate)) {
                this.position.xCoordinate++
            }
            else
            {
                lost = true
                this.position.xCoordinate = bounds.xUpperLimit()
            }
        }
        else if (direction === Direction.NORTH){
            if (bounds.lessThanYUpperLimit(position.yCoordinate)) {
                this.position.yCoordinate++
            }
            else
            {
                lost = true
                this.position.yCoordinate = bounds.yUpperLimit()
            }
        }
        else
        {
            if (bounds.greaterThanYLowerLimit(position.yCoordinate)) {
                this.position.yCoordinate--
            }
            else
            {
                lost = true
                this.position.yCoordinate = Bounds.LOWER_LIMIT
            }
        }
    }

    fun isPosition(xPosition: Int, yPosition: Int): Boolean {
        return position.xCoordinate == xPosition && position.yCoordinate == yPosition
    }
}