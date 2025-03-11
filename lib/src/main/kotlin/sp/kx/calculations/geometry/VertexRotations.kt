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
