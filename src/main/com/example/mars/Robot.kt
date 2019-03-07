package main.com.example.mars

class Robot(private val bounds: Bounds, val position: Position, private var direction: Direction) {

    private lateinit var last_known_position : Position
    private lateinit var last_known_direction : Direction
    var lost = false

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
                if(LostRobots.noScentsFound(this))lost = true
                this.position.xCoordinate = Bounds.LOWER_LIMIT
                LostRobots.lostRobots.add(last_known_position)
            }
        }
        else if (direction === Direction.EAST)
        {
            if (bounds.lessThanXUpperLimit(position.xCoordinate)) {
                this.position.xCoordinate++
            }
            else
            {
                if(LostRobots.noScentsFound(this))lost = true
                this.position.xCoordinate = bounds.xUpperLimit()
                LostRobots.lostRobots.add(last_known_position)
            }
        }

        else if (direction === Direction.NORTH){
            if (bounds.lessThanYUpperLimit(position.yCoordinate)) {
                this.position.yCoordinate++
            }
            else
            {
                if(LostRobots.noScentsFound(this))lost = true
                this.position.yCoordinate = bounds.yUpperLimit()
                LostRobots.lostRobots.add(last_known_position)
            }
        }
        else
        {
            if (bounds.greaterThanYLowerLimit(position.yCoordinate)) {
                this.position.yCoordinate--
            }
            else
            {
                if(LostRobots.noScentsFound(this))lost = true
                this.position.yCoordinate = Bounds.LOWER_LIMIT
                LostRobots.lostRobots.add(last_known_position)
            }
        }


        last_known_position = Position(this.position.xCoordinate,this.position.yCoordinate)
        last_known_direction = this.direction
    }


    fun isPosition(xPosition: Int, yPosition: Int): Boolean {
        return position.xCoordinate == xPosition && position.yCoordinate == yPosition
    }

    fun isLost(): Boolean
    {
        return lost
    }
}