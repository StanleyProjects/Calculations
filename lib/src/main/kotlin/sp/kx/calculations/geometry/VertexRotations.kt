package sp.kx.calculations.geometry

private fun aa(
    issuer: MutableVertex,
    axis: Vertex,
    radians: Double,
) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val m00 = c + (1 - c) * axis.x * axis.x;          val m01 = (1 - c) * axis.x * axis.y - s * axis.z; val m02 = (1 - c) * axis.x * axis.z + s * axis.y
    val m10 = (1 - c) * axis.y * axis.x + s * axis.z; val m11 = c + (1 - c) * axis.y * axis.y;          val m12 = (1 - c) * axis.y * axis.z - s * axis.x
    val m20 = (1 - c) * axis.z * axis.x - s * axis.y; val m21 = (1 - c) * axis.z * axis.y + s * axis.x; val m22 = c + (1 - c) * axis.z * axis.z
    issuer.set(
        x = m00 * issuer.x + m01 * issuer.y + m02 * issuer.z,
        y = m10 * issuer.x + m11 * issuer.y + m12 * issuer.z,
        z = m20 * issuer.x + m21 * issuer.y + m22 * issuer.z,
    )
}

fun rx(
    x: Double,
    y: Double,
    z: Double,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
//    val _x = 1.0
//    val _y = 0.0
//    val _z = 0.0
//    val m00 = c + (1 - c) * _x * _x;     val m01 = (1 - c) * _x * _y + s * _z; val m02 = (1 - c) * _x * _z + s * _y
//    val m10 = (1 - c) * _y * _x + s * _z; val m11 = c + (1 - c) * _y * _y;     val m12 = (1 - c) * _y * _z + s * _x
//    val m20 = (1 - c) * _z * _x + s * _y; val m21 = (1 - c) * _z * _y + s * _x; val m22 = c + (1 - c) * _z * _z
    //
//    val axis = MutableVertex(1.0, 0.0, 0.0)
//    val m00 = c + (1 - c) * axis.x * axis.x;          val m01 = (1 - c) * axis.x * axis.y - s * axis.z; val m02 = (1 - c) * axis.x * axis.z + s * axis.y
//    val m10 = (1 - c) * axis.y * axis.x + s * axis.z; val m11 = c + (1 - c) * axis.y * axis.y;          val m12 = (1 - c) * axis.y * axis.z - s * axis.x
//    val m20 = (1 - c) * axis.z * axis.x - s * axis.y; val m21 = (1 - c) * axis.z * axis.y + s * axis.x; val m22 = c + (1 - c) * axis.z * axis.z
//    return MutableVertex(
//        x = m00 * x + m01 * y + m02 * z,
//        y = m10 * x + m11 * y + m12 * z,
//        z = m20 * x + m21 * y + m22 * z,
//    )
    //
    val issuer = MutableVertex(x, y, z)
    aa(issuer, MutableVertex(1.0, 0.0, 0.0), radians = radians)
    return issuer
}

fun ry(
    x: Double,
    y: Double,
    z: Double,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val _x = 0.0
    val _y = 1.0
    val _z = 0.0
    val m00 = c + (1 - c) * _x * _x;     val m01 = (1 - c) * _x * _y + s * _z; val m02 = (1 - c) * _x * _z + s * _y
    val m10 = (1 - c) * _y * _x + s * _z; val m11 = c + (1 - c) * _y * _y;     val m12 = (1 - c) * _y * _z + s * _x
    val m20 = (1 - c) * _z * _x + s * _y; val m21 = (1 - c) * _z * _y + s * _x; val m22 = c + (1 - c) * _z * _z
    return MutableVertex(
        x = m00 * x + m01 * y + m02 * z,
        y = m10 * x + m11 * y + m12 * z,
        z = m20 * x + m21 * y + m22 * z,
    )
}

fun rz(
    x: Double,
    y: Double,
    z: Double,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val _x = 0.0
    val _y = 0.0
    val _z = 1.0
    val m00 = c + (1 - c) * _x * _x;     val m01 = (1 - c) * _x * _y + s * _z; val m02 = (1 - c) * _x * _z + s * _y
    val m10 = (1 - c) * _y * _x + s * _z; val m11 = c + (1 - c) * _y * _y;     val m12 = (1 - c) * _y * _z + s * _x
    val m20 = (1 - c) * _z * _x + s * _y; val m21 = (1 - c) * _z * _y + s * _x; val m22 = c + (1 - c) * _z * _z
    return MutableVertex(
        x = m00 * x + m01 * y + m02 * z,
        y = m10 * x + m11 * y + m12 * z,
        z = m20 * x + m21 * y + m22 * z,
    )
}

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
