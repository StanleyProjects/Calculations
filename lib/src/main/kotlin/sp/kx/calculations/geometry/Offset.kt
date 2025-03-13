package sp.kx.calculations.geometry

interface Offset {
    val dX: Double
    val dY: Double
    val dZ: Double
}

fun Offset.copy(
    dX: Double = this.dX,
    dY: Double = this.dY,
    dZ: Double = this.dZ,
): Offset {
    return MutableOffset(
        dX = dX,
        dY = dY,
        dZ = dZ,
    )
}
