package sp.kx.calculations.geometry

// https://en.wikipedia.org/wiki/Rotation_matrix
fun rotate(
    x: Double,
    y: Double,
    z: Double,
    aX: Double,
    aY: Double,
    aZ: Double,
): Vertex {
    val c = kotlin.math.cos(aZ)
    val s = kotlin.math.sin(aZ)
    return MutableVertex(
        x = x * c - y * s,
        y = x * s + y * c,
        z = 0.0,
    )
}
