package sp.kx.calculations.geometry

interface Vertex {
    val x: Double
    val y: Double
    val z: Double
}

fun Vertex.copy(
    x: Double = this.x,
    y: Double = this.y,
    z: Double = this.z,
): Vertex {
    return MutableVertex(
        x = x,
        y = y,
        z = z,
    )
}
