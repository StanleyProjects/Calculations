package sp.kx.calculations

import java.util.Objects

class MutableCell(
    override var x: Int,
    override var y: Int,
) : Cell {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Cell -> x == other.x && y == other.y
            else -> false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y)
    }
}
