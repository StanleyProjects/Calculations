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
    var c = kotlin.math.cos(aZ)
    var s = kotlin.math.sin(aZ)
    val _y = x * s + y * c
    var _x = x * c - y * s
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _z = _x * s + z * c
    _x = _x * c - z * s
    c = kotlin.math.cos(aX)
    s = kotlin.math.sin(aX)
    return MutableVertex(
        x = _x,
        y = _y * c - _z * s,
        z = _y * s + _z * c,
    )
}

fun rotate(
    x: Double,
    y: Double,
    z: Double,
    aX: Double,
    aY: Double,
    aZ: Double,
    rX: Double,
    rY: Double,
    rZ: Double,
): Vertex {
    val x0 = x - rX
    val y0 = y - rY
    val z0 = z - rZ
    var c = kotlin.math.cos(aZ)
    var s = kotlin.math.sin(aZ)
    val _y = x0 * s + y0 * c
    var _x = x0 * c - y0 * s
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    val _z = _x * s + z0 * c
    _x = _x * c - z0 * s
    c = kotlin.math.cos(aX)
    s = kotlin.math.sin(aX)
    return MutableVertex(
        x = _x + rX,
        y = _y * c - _z * s + rY,
        z = _y * s + _z * c + rZ,
    )
}
