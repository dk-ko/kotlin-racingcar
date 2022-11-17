package racingcar

class Car(
    private val _name: String,
    private var _status: Int = 0,
) {
    val name: String
        get() {
            return this._name
        }
    var status: Int
        get() {
            return this._status
        }
        set(value) {
            _status = value
        }

    init {
        if (name.length > NAME_LENGTH_CONDITION) {
            throw IllegalArgumentException("자동자 이름은 ${NAME_LENGTH_CONDITION}자를 넘을 수 없습니다.")
        }
    }

    fun move(condition: Int): Car {
        if (condition >= MOVE_CONDITION) {
            status++
        }
        return this
    }

    fun isWinner(max: Int): Boolean {
        return this.status == max
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Car) return false

        if (status != other.status) return false

        return true
    }

    override fun hashCode(): Int {
        return status
    }

    override fun toString(): String {
        return "$name"
    }

    companion object {
        private const val MOVE_CONDITION = 4
        private const val NAME_LENGTH_CONDITION = 5
    }
}
