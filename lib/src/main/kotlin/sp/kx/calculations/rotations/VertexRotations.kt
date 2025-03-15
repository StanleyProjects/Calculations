package sp.kx.calculations.rotations

import sp.kx.calculations.geometry.MutableVertex
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

fun Vertex.rxyz(
    aX: Double,
    aY: Double,
    aZ: Double,
): Vertex {
    var c = kotlin.math.cos(aX)
    var s = kotlin.math.sin(aX)
    val _y = y * c - z * s
    var _z = y * s + z * c
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _x = _z * s + x * c
    _z = _z * c - x * s
    c = kotlin.math.cos(aZ)
    s = kotlin.math.sin(aZ)
    return MutableVertex(
        x = _x * c - _y * s,
        y = _x * s + _y * c,
        z = _z,
    )
}

fun Vertex.rzyx(
    aX: Double,
    aY: Double,
    aZ: Double,
): Vertex {
    var c = kotlin.math.cos(aZ)
    var s = kotlin.math.sin(aZ)
    var _x = x * c - y * s
    val _y = x * s + y * c
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _z = z * c - _x * s
    _x = z * s + _x * c
    c = kotlin.math.cos(aX)
    s = kotlin.math.sin(aX)
    return MutableVertex(
        x = _x,
        y = _y * c - _z * s,
        z = _y * s + _z * c,
    )
}
