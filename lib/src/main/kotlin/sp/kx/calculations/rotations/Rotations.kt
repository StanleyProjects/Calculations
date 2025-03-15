package sp.kx.calculations.rotations

import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.geometry.Vertex

internal fun aa(
    x: Double,
    y: Double,
    z: Double,
    _x: Double,
    _y: Double,
    _z: Double,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val m00 = c + (1 - c) * _x * _x;      val m01 = (1 - c) * _x * _y - s * _z; val m02 = (1 - c) * _x * _z + s * _y
    val m10 = (1 - c) * _y * _x + s * _z; val m11 = c + (1 - c) * _y * _y;      val m12 = (1 - c) * _y * _z - s * _x
    val m20 = (1 - c) * _z * _x - s * _y; val m21 = (1 - c) * _z * _y + s * _x; val m22 = c + (1 - c) * _z * _z
    return MutableVertex(
        x = m00 * x + m01 * y + m02 * z,
        y = m10 * x + m11 * y + m12 * z,
        z = m20 * x + m21 * y + m22 * z,
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
    //
//    val m00 = c + (1 - c) * 1.0 * 1.0;      val m01 = (1 - c) * 1.0 * 0.0 - s * 0.0; val m02 = (1 - c) * 1.0 * 0.0 + s * 0.0
//    val m10 = (1 - c) * 0.0 * 1.0 + s * 0.0; val m11 = c + (1 - c) * 0.0 * 0.0;      val m12 = (1 - c) * 0.0 * 0.0 - s * 1.0
//    val m20 = (1 - c) * 0.0 * 1.0 - s * 0.0; val m21 = (1 - c) * 0.0 * 0.0 + s * 1.0; val m22 = c + (1 - c) * 0.0 * 0.0
//    return MutableVertex(
//        x = m00 * x + m01 * y + m02 * z,
//        y = m10 * x + m11 * y + m12 * z,
//        z = m20 * x + m21 * y + m22 * z,
//    )
    //
//    val m00 = 1.0; val m01 = 0.0; val m02 = 0.0
//    val m10 = 0.0; val m11 = c;   val m12 = -s
//    val m20 = 0.0; val m21 = s;   val m22 = c
//    return MutableVertex(
//        x = m00 * x + m01 * y + m02 * z,
//        y = m10 * x + m11 * y + m12 * z,
//        z = m20 * x + m21 * y + m22 * z,
//    )
    //
    return MutableVertex(
        x = x,
        y = y * c - z * s,
        z = y * s + z * c,
    )
}

fun ry(
    x: Double,
    y: Double,
    z: Double,
    radians: Double,
): Vertex {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    return MutableVertex(
        x = z * s + x * c,
        y = y,
        z = z * c - x * s,
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
    return MutableVertex(
        x = x * c - y * s,
        y = x * s + y * c,
        z = z,
    )
}
