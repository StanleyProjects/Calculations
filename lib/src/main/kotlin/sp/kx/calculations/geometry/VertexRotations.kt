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
    var _y = x * s + y * c
    var _x = x * c - y * s
    c = kotlin.math.cos(aY)
    s = kotlin.math.sin(aY)
    var _z = _x * s + z * c
    _x = _x * c - z * s
    return MutableVertex(
        x = _x,
        y = _y,
        z = _z,
    )
}
