package sp.kx.calculations

import java.util.Objects

class MutableCell(
    override val x: Int,
    override val y: Int,
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
