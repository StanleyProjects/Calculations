package sp.kx.calculations.rotations

import sp.kx.calculations.algebra.MutableMatrix
import sp.kx.calculations.algebra.translate
import sp.kx.calculations.geometry.Rotation
import sp.kx.calculations.geometry.Vertex

// https://en.wikipedia.org/wiki/Rotation_matrix

/*
fun MutableMatrix.rx(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val other = MutableMatrix(
        m00 = 1.0, m01 = 0.0, m02 = 0.0, m03 = 0.0,
        m10 = 0.0, m11 = c, m12 = -s,    m13 = 0.0,
        m20 = 0.0, m21 = s, m22 = c,     m23 = 0.0,
        m30 = 0.0, m31 = 0.0, m32 = 0.0, m33 = 1.0,
    )
    //
    val m00 = this.m00 * other.m00 + this.m01 * other.m10 + this.m02 * other.m20 + this.m03 * other.m30
    val m01 = this.m00 * other.m01 + this.m01 * other.m11 + this.m02 * other.m21 + this.m03 * other.m31
    val m02 = this.m00 * other.m02 + this.m01 * other.m12 + this.m02 * other.m22 + this.m03 * other.m32
    val m03 = this.m00 * other.m03 + this.m01 * other.m13 + this.m02 * other.m23 + this.m03 * other.m33
    //
    val m10 = this.m10 * other.m00 + this.m11 * other.m10 + this.m12 * other.m20 + this.m13 * other.m30
    val m11 = this.m10 * other.m01 + this.m11 * other.m11 + this.m12 * other.m21 + this.m13 * other.m31
    val m12 = this.m10 * other.m02 + this.m11 * other.m12 + this.m12 * other.m22 + this.m13 * other.m32
    val m13 = this.m10 * other.m03 + this.m11 * other.m13 + this.m12 * other.m23 + this.m13 * other.m33
    //
    val m20 = this.m20 * other.m00 + this.m21 * other.m10 + this.m22 * other.m20 + this.m23 * other.m30
    val m21 = this.m20 * other.m01 + this.m21 * other.m11 + this.m22 * other.m21 + this.m23 * other.m31
    val m22 = this.m20 * other.m02 + this.m21 * other.m12 + this.m22 * other.m22 + this.m23 * other.m32
    val m23 = this.m20 * other.m03 + this.m21 * other.m13 + this.m22 * other.m23 + this.m23 * other.m33
    //
    val m30 = this.m30 * other.m00 + this.m31 * other.m10 + this.m32 * other.m20 + this.m33 * other.m30
    val m31 = this.m30 * other.m01 + this.m31 * other.m11 + this.m32 * other.m21 + this.m33 * other.m31
    val m32 = this.m30 * other.m02 + this.m31 * other.m12 + this.m32 * other.m22 + this.m33 * other.m32
    val m33 = this.m30 * other.m03 + this.m31 * other.m13 + this.m32 * other.m23 + this.m33 * other.m33
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03
    this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13
    this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23
    this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33
}
*/

fun MutableMatrix.rx(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val m01 = this.m01 * c + this.m02 * s
    val m02 = this.m02 * c - this.m01 * s
    val m11 = this.m11 * c + this.m12 * s
    val m12 = this.m12 * c - this.m11 * s
    val m21 = this.m21 * c + this.m22 * s
    val m22 = this.m22 * c - this.m21 * s
    val m31 = this.m31 * c + this.m32 * s
    val m32 = this.m32 * c - this.m31 * s
    this.m01 = m01; this.m02 = m02
    this.m11 = m11; this.m12 = m12
    this.m21 = m21; this.m22 = m22
    this.m31 = m31; this.m32 = m32
}

fun MutableMatrix.ry(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val m00 = this.m00 * c - this.m02 * s
    val m02 = this.m00 * s + this.m02 * c
    val m10 = this.m10 * c - this.m12 * s
    val m12 = this.m10 * s + this.m12 * c
    val m20 = this.m20 * c - this.m22 * s
    val m22 = this.m20 * s + this.m22 * c
    val m30 = this.m30 * c - this.m32 * s
    val m32 = this.m30 * s + this.m32 * c
    this.m00 = m00; this.m02 = m02
    this.m10 = m10; this.m12 = m12
    this.m20 = m20; this.m22 = m22
    this.m30 = m30; this.m32 = m32
}

fun MutableMatrix.rz(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    val m00 = this.m00 * c + this.m01 * s
    val m01 = this.m01 * c - this.m00 * s
    val m10 = this.m10 * c + this.m11 * s
    val m11 = this.m11 * c - this.m10 * s
    val m20 = this.m20 * c + this.m21 * s
    val m21 = this.m21 * c - this.m20 * s
    val m30 = this.m30 * c + this.m31 * s
    val m31 = this.m31 * c - this.m30 * s
    this.m00 = m00; this.m01 = m01
    this.m10 = m10; this.m11 = m11
    this.m20 = m20; this.m21 = m21
    this.m30 = m30; this.m31 = m31
}

fun MutableMatrix.rxyz(
    aX: Double,
    aY: Double,
    aZ: Double,
) {
    val cX = kotlin.math.cos(aX)
    val cY = kotlin.math.cos(aY)
    val cZ = kotlin.math.cos(aZ)
    val sX = kotlin.math.sin(aX)
    val sY = kotlin.math.sin(aY)
    val sZ = kotlin.math.sin(aZ)
    //
    val n00 = cZ * cY
    val n01 = cZ * sY * sX - sZ * cX
    val n02 = cZ * sY * cX + sZ * sX
    val n10 = sZ * cY
    val n11 = cZ * cX + sZ * sY * sX
    val n12 = sZ * sY * cX - cZ * sX
    val n21 = cY * sX
    val n22 = cY * cX
    //
    val m00 = this.m00 * n00 + this.m01 * n10 - this.m02 * sY
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22
    val m10 = this.m10 * n00 + this.m11 * n10 - this.m12 * sY
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22
    val m20 = this.m20 * n00 + this.m21 * n10 - this.m22 * sY
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22
    val m30 = this.m30 * n00 + this.m31 * n10 - this.m32 * sY
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}

fun MutableMatrix.rzyx(
    aX: Double,
    aY: Double,
    aZ: Double,
) {
    val cX = kotlin.math.cos(aX)
    val cY = kotlin.math.cos(aY)
    val cZ = kotlin.math.cos(aZ)
    val sX = kotlin.math.sin(aX)
    val sY = kotlin.math.sin(aY)
    val sZ = kotlin.math.sin(aZ)
    //
    val n10 = cX * sZ + sX * sY * cZ
    val n11 = cX * cZ - sX * sY * sZ
    val n20 = sX * sZ - cX * sY * cZ
    val n21 = cX * sY * sZ + sX * cZ
    //
    val m00 = this.m00 * cY * cZ + this.m01 * n10 + this.m02 * n20
    val m01 = this.m01 * n11 + this.m02 * n21 - this.m00 * cY * sZ
    val m02 = this.m00 * sY - this.m01 * sX * cY + this.m02 * cX * cY
    val m10 = this.m10 * cY * cZ + this.m11 * n10 + this.m12 * n20
    val m11 = this.m11 * n11 + this.m12 * n21 - this.m10 * cY * sZ
    val m12 = this.m10 * sY - this.m11 * sX * cY + this.m12 * cX * cY
    val m20 = this.m20 * cY * cZ + this.m21 * n10 + this.m22 * n20
    val m21 = this.m21 * n11 + this.m22 * n21 - this.m20 * cY * sZ
    val m22 = this.m20 * sY - this.m21 * sX * cY + this.m22 * cX * cY
    val m30 = this.m30 * cY * cZ + this.m31 * n10 + this.m32 * n20
    val m31 = this.m31 * n11 + this.m32 * n21 - this.m30 * cY * sZ
    val m32 = this.m30 * sY - this.m31 * sX * cY + this.m32 * cX * cY
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}

fun MutableMatrix.rxyz(rotation: Rotation) {
    val cX = kotlin.math.cos(rotation.aX)
    val cY = kotlin.math.cos(rotation.aY)
    val cZ = kotlin.math.cos(rotation.aZ)
    val sX = kotlin.math.sin(rotation.aX)
    val sY = kotlin.math.sin(rotation.aY)
    val sZ = kotlin.math.sin(rotation.aZ)
    //
    val n00 = cZ * cY
    val n01 = cZ * sY * sX - sZ * cX
    val n02 = cZ * sY * cX + sZ * sX
    val n10 = sZ * cY
    val n11 = cZ * cX + sZ * sY * sX
    val n12 = sZ * sY * cX - cZ * sX
    val n21 = cY * sX
    val n22 = cY * cX
    //
    val m00 = this.m00 * n00 + this.m01 * n10 - this.m02 * sY
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22
    val m10 = this.m10 * n00 + this.m11 * n10 - this.m12 * sY
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22
    val m20 = this.m20 * n00 + this.m21 * n10 - this.m22 * sY
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22
    val m30 = this.m30 * n00 + this.m31 * n10 - this.m32 * sY
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}

fun MutableMatrix.rzyx(rotation: Rotation) {
    val cX = kotlin.math.cos(rotation.aX)
    val cY = kotlin.math.cos(rotation.aY)
    val cZ = kotlin.math.cos(rotation.aZ)
    val sX = kotlin.math.sin(rotation.aX)
    val sY = kotlin.math.sin(rotation.aY)
    val sZ = kotlin.math.sin(rotation.aZ)
    //
    val n10 = cX * sZ + sX * sY * cZ
    val n11 = cX * cZ - sX * sY * sZ
    val n20 = sX * sZ - cX * sY * cZ
    val n21 = cX * sY * sZ + sX * cZ
    //
    val m00 = this.m00 * cY * cZ + this.m01 * n10 + this.m02 * n20
    val m01 = this.m01 * n11 + this.m02 * n21 - this.m00 * cY * sZ
    val m02 = this.m00 * sY - this.m01 * sX * cY + this.m02 * cX * cY
    val m10 = this.m10 * cY * cZ + this.m11 * n10 + this.m12 * n20
    val m11 = this.m11 * n11 + this.m12 * n21 - this.m10 * cY * sZ
    val m12 = this.m10 * sY - this.m11 * sX * cY + this.m12 * cX * cY
    val m20 = this.m20 * cY * cZ + this.m21 * n10 + this.m22 * n20
    val m21 = this.m21 * n11 + this.m22 * n21 - this.m20 * cY * sZ
    val m22 = this.m20 * sY - this.m21 * sX * cY + this.m22 * cX * cY
    val m30 = this.m30 * cY * cZ + this.m31 * n10 + this.m32 * n20
    val m31 = this.m31 * n11 + this.m32 * n21 - this.m30 * cY * sZ
    val m32 = this.m30 * sY - this.m31 * sX * cY + this.m32 * cX * cY
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}

fun MutableMatrix.rxyz(
    rotation: Rotation,
    about: Vertex,
) {
    m03 += m00 * about.x + m01 * about.y + m02 * about.z
    m13 += m10 * about.x + m11 * about.y + m12 * about.z
    m23 += m20 * about.x + m21 * about.y + m22 * about.z
    m33 += m30 * about.x + m31 * about.y + m32 * about.z
    //
    val cX = kotlin.math.cos(rotation.aX)
    val cY = kotlin.math.cos(rotation.aY)
    val cZ = kotlin.math.cos(rotation.aZ)
    val sX = kotlin.math.sin(rotation.aX)
    val sY = kotlin.math.sin(rotation.aY)
    val sZ = kotlin.math.sin(rotation.aZ)
    //
    val n00 = cZ * cY
    val n01 = cZ * sY * sX - sZ * cX
    val n02 = cZ * sY * cX + sZ * sX
    val n10 = sZ * cY
    val n11 = cZ * cX + sZ * sY * sX
    val n12 = sZ * sY * cX - cZ * sX
    val n21 = cY * sX
    val n22 = cY * cX
    //
    val m00 = this.m00 * n00 + this.m01 * n10 - this.m02 * sY
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22
    val m10 = this.m10 * n00 + this.m11 * n10 - this.m12 * sY
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22
    val m20 = this.m20 * n00 + this.m21 * n10 - this.m22 * sY
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22
    val m30 = this.m30 * n00 + this.m31 * n10 - this.m32 * sY
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
    //
    m03 -= m00 * about.x + m01 * about.y + m02 * about.z
    m13 -= m10 * about.x + m11 * about.y + m12 * about.z
    m23 -= m20 * about.x + m21 * about.y + m22 * about.z
    m33 -= m30 * about.x + m31 * about.y + m32 * about.z
}

fun MutableMatrix.rzyx(
    rotation: Rotation,
    about: Vertex,
) {
    m03 += m00 * about.x + m01 * about.y + m02 * about.z
    m13 += m10 * about.x + m11 * about.y + m12 * about.z
    m23 += m20 * about.x + m21 * about.y + m22 * about.z
    m33 += m30 * about.x + m31 * about.y + m32 * about.z
    //
    val cX = kotlin.math.cos(rotation.aX)
    val cY = kotlin.math.cos(rotation.aY)
    val cZ = kotlin.math.cos(rotation.aZ)
    val sX = kotlin.math.sin(rotation.aX)
    val sY = kotlin.math.sin(rotation.aY)
    val sZ = kotlin.math.sin(rotation.aZ)
    //
    val n10 = cX * sZ + sX * sY * cZ
    val n11 = cX * cZ - sX * sY * sZ
    val n20 = sX * sZ - cX * sY * cZ
    val n21 = cX * sY * sZ + sX * cZ
    //
    val m00 = this.m00 * cY * cZ + this.m01 * n10 + this.m02 * n20
    val m01 = this.m01 * n11 + this.m02 * n21 - this.m00 * cY * sZ
    val m02 = this.m00 * sY - this.m01 * sX * cY + this.m02 * cX * cY
    val m10 = this.m10 * cY * cZ + this.m11 * n10 + this.m12 * n20
    val m11 = this.m11 * n11 + this.m12 * n21 - this.m10 * cY * sZ
    val m12 = this.m10 * sY - this.m11 * sX * cY + this.m12 * cX * cY
    val m20 = this.m20 * cY * cZ + this.m21 * n10 + this.m22 * n20
    val m21 = this.m21 * n11 + this.m22 * n21 - this.m20 * cY * sZ
    val m22 = this.m20 * sY - this.m21 * sX * cY + this.m22 * cX * cY
    val m30 = this.m30 * cY * cZ + this.m31 * n10 + this.m32 * n20
    val m31 = this.m31 * n11 + this.m32 * n21 - this.m30 * cY * sZ
    val m32 = this.m30 * sY - this.m31 * sX * cY + this.m32 * cX * cY
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
    //
    m03 -= m00 * about.x + m01 * about.y + m02 * about.z
    m13 -= m10 * about.x + m11 * about.y + m12 * about.z
    m23 -= m20 * about.x + m21 * about.y + m22 * about.z
    m33 -= m30 * about.x + m31 * about.y + m32 * about.z
}
