package sp.kx.calculations.rotations

import sp.kx.calculations.geometry.Vertex
import sp.kx.calculations.geometry.copy

fun Vertex.rx(radians: Double): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return copy(
        y = y * c - z * s,
        z = y * s + z * c,
    )
}

fun Vertex.ry(radians: Double): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return copy(
        x = z * s + x * c,
        z = z * c - x * s,
    )
}

fun Vertex.rz(radians: Double): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return copy(
        x = x * c - y * s,
        y = x * s + y * c,
    )
}
