package sp.kx.calculations.rotations

import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.geometry.Vertex
import sp.kx.calculations.geometry.copy

fun rx(
    vertex: Vertex,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return vertex.copy(
        y = vertex.y * c - vertex.z * s,
        z = vertex.y * s + vertex.z * c,
    )
}

fun ry(
    vertex: Vertex,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return vertex.copy(
        x = vertex.z * s + vertex.x * c,
        z = vertex.z * c - vertex.x * s,
    )
}

fun rz(
    vertex: Vertex,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return vertex.copy(
        x = vertex.x * c - vertex.y * s,
        y = vertex.x * s + vertex.y * c,
    )
}

fun rxyz(
    vertex: Vertex,
    aX: Double,
    aY: Double,
    aZ: Double,
): Vertex {
    var c = kotlin.math.cos(aX)
    var s = kotlin.math.sin(aX)
    val _y = vertex.y * c - vertex.z * s
    var _z = vertex.y * s + vertex.z * c
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _x = _z * s + vertex.x * c
    _z = _z * c - vertex.x * s
    c = kotlin.math.cos(aZ)
    s = kotlin.math.sin(aZ)
    return MutableVertex(
        x = _x * c - _y * s,
        y = _x * s + _y * c,
        z = _z,
    )
}

fun rzyx(
    vertex: Vertex,
    aX: Double,
    aY: Double,
    aZ: Double,
): Vertex {
    var c = kotlin.math.cos(aZ)
    var s = kotlin.math.sin(aZ)
    var _x = vertex.x * c - vertex.y * s
    val _y = vertex.x * s + vertex.y * c
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _z = vertex.z * c - _x * s
    _x = vertex.z * s + _x * c
    c = kotlin.math.cos(aX)
    s = kotlin.math.sin(aX)
    return MutableVertex(
        x = _x,
        y = _y * c - _z * s,
        z = _y * s + _z * c,
    )
}
