package sp.kx.calculations.geometry

import java.util.Objects

class MutableVertex(
    override var x: Double,
    override var y: Double,
    override var z: Double,
) : Vertex {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Vertex -> x == other.x && y == other.y && z == other.z
            else -> false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(x, y, z)
    }

    override fun toString(): String {
        return "Vertex(x: ${String.format("%.2f", x)}, y: ${String.format("%.2f", y)}, z: ${String.format("%.2f", z)})"
    }
}
