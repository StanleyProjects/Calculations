package sp.kx.calculations.rotations

import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.geometry.Rotation
import sp.kx.calculations.geometry.Vertex

fun MutableVertex.rx(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val _y = y * c - z * s
    z = y * s + z * c
    y = _y
}

fun MutableVertex.ry(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val _x = z * s + x * c
    z = z * c - x * s
    x = _x
}

fun MutableVertex.rz(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val _x = x * c - y * s
    y = x * s + y * c
    x = _x
}

fun MutableVertex.rxyz(
    aX: Double,
    aY: Double,
    aZ: Double,
) {
    var c = kotlin.math.cos(aX)
    var s = kotlin.math.sin(aX)
    val _y = y * c - z * s
    val _z = y * s + z * c
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _x = _z * s + x * c
    z = _z * c - x * s
    c = kotlin.math.cos(aZ)
    s = kotlin.math.sin(aZ)
    x = _x * c - _y * s
    y = _x * s + _y * c
}

fun MutableVertex.rzyx(
    aX: Double,
    aY: Double,
    aZ: Double,
) {
    var c = kotlin.math.cos(aZ)
    var s = kotlin.math.sin(aZ)
    val _x = x * c - y * s
    val _y = x * s + y * c
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _z = z * c - _x * s
    x = z * s + _x * c
    c = kotlin.math.cos(aX)
    s = kotlin.math.sin(aX)
    y = _y * c - _z * s
    z = _y * s + _z * c
}

fun MutableVertex.rxyz(rotation: Rotation) {
    var c = kotlin.math.cos(rotation.aX)
    var s = kotlin.math.sin(rotation.aX)
    val _y = y * c - z * s
    val _z = y * s + z * c
    c = kotlin.math.cos(rotation.aY)
    s = kotlin.math.sin(rotation.aY)
    val _x = _z * s + x * c
    z = _z * c - x * s
    c = kotlin.math.cos(rotation.aZ)
    s = kotlin.math.sin(rotation.aZ)
    x = _x * c - _y * s
    y = _x * s + _y * c
}

fun MutableVertex.rzyx(rotation: Rotation) {
    var c = kotlin.math.cos(rotation.aZ)
    var s = kotlin.math.sin(rotation.aZ)
    val _x = x * c - y * s
    val _y = x * s + y * c
    c = kotlin.math.cos(rotation.aY)
    s = kotlin.math.sin(rotation.aY)
    val _z = z * c - _x * s
    x = z * s + _x * c
    c = kotlin.math.cos(rotation.aX)
    s = kotlin.math.sin(rotation.aX)
    y = _y * c - _z * s
    z = _y * s + _z * c
}

fun MutableVertex.rxyz(
    about: Vertex,
    rotation: Rotation,
) {
    var c = kotlin.math.cos(rotation.aX)
    var s = kotlin.math.sin(rotation.aX)
    val _y = (y - about.y) * c - (z - about.z) * s
    val _z = (y - about.y) * s + (z - about.z) * c
    c = kotlin.math.cos(rotation.aY)
    s = kotlin.math.sin(rotation.aY)
    val _x = _z * s + (x - about.x) * c
    z = _z * c - (x - about.x) * s + about.z
    c = kotlin.math.cos(rotation.aZ)
    s = kotlin.math.sin(rotation.aZ)
    x = _x * c - _y * s + about.x
    y = _x * s + _y * c + about.y
}

fun MutableVertex.rzyx(
    about: Vertex,
    rotation: Rotation,
) {
    var c = kotlin.math.cos(rotation.aZ)
    var s = kotlin.math.sin(rotation.aZ)
    val _x = (x - about.x) * c - (y - about.y) * s
    val _y = (x - about.x) * s + (y - about.y) * c
    c = kotlin.math.cos(rotation.aY)
    s = kotlin.math.sin(rotation.aY)
    val _z = (z - about.z) * c - _x * s
    x = (z - about.z) * s + _x * c + about.x
    c = kotlin.math.cos(rotation.aX)
    s = kotlin.math.sin(rotation.aX)
    y = _y * c - _z * s + about.y
    z = _y * s + _z * c + about.z
}
