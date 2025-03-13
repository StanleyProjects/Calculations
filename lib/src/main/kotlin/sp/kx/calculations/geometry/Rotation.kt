package sp.kx.calculations.geometry

interface Rotation {
    val aX: Double
    val aY: Double
    val aZ: Double
}

fun Rotation.copy(
    aX: Double = this.aX,
    aY: Double = this.aY,
    aZ: Double = this.aZ,
): Rotation {
    return MutableRotation(
        aX = aX,
        aY = aY,
        aZ = aZ,
    )
}
