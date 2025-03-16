package sp.kx.calculations.geometry

import java.util.Objects

class MutableOffset(
    override var dX: Double,
    override var dY: Double,
    override var dZ: Double,
) : Offset {
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Offset -> dX == other.dX && dY == other.dY && dZ == other.dZ
            else -> false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(dX, dY, dZ)
    }

    override fun toString(): String {
        return "Offset(dX: ${String.format("%.2f", dX)}, dY: ${String.format("%.2f", dY)}, dZ: ${String.format("%.2f", dZ)})"
    }

    fun set(
        dX: Double,
        dY: Double,
        dZ: Double,
    ) {
        this.dX = dX
        this.dY = dY
        this.dZ = dZ
    }

    fun set(other: Offset) {
        dX = other.dX
        dY = other.dY
        dZ = other.dZ
    }
}

fun Offset.mut(): MutableOffset {
    return MutableOffset(
        dX = dX,
        dY = dY,
        dZ = dZ,
    )
}
