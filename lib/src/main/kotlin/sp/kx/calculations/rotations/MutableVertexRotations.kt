package sp.kx.calculations.rotations

import sp.kx.calculations.geometry.MutableVertex

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
