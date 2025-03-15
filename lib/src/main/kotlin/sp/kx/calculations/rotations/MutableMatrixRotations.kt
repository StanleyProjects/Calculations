package sp.kx.calculations.rotations

import sp.kx.calculations.algebra.MutableMatrix

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
    val x00 = 1.0; val x01 = 0.0; val x02 = 0.0; val x03 = 0.0
    val x10 = 0.0; val x11 = cX;  val x12 = -sX; val x13 = 0.0
    val x20 = 0.0; val x21 = sX;  val x22 = cX;  val x23 = 0.0
    val x30 = 0.0; val x31 = 0.0; val x32 = 0.0; val x33 = 1.0
    //
    val y00 = cY;  val y01 = 0.0; val y02 = sY;  val y03 = 0.0
    val y10 = 0.0; val y11 = 1.0; val y12 = 0.0; val y13 = 0.0
    val y20 = -sY; val y21 = 0.0; val y22 = cY;  val y23 = 0.0
    val y30 = 0.0; val y31 = 0.0; val y32 = 0.0; val y33 = 1.0
    //
    val z00 = cZ;  val z01 = -sZ; val z02 = 0.0; val z03 = 0.0
    val z10 = sZ;  val z11 = cZ;  val z12 = 0.0; val z13 = 0.0
    val z20 = 0.0; val z21 = 0.0; val z22 = 1.0; val z23 = 0.0
    val z30 = 0.0; val z31 = 0.0; val z32 = 0.0; val z33 = 1.0
    //
    val a00 = y00;       val a01 = 0.0; val a02 = y02;       val a03 = 0.0
    val a10 = x12 * y20; val a11 = x11; val a12 = x12 * y22; val a13 = 0.0
    val a20 = x22 * y20; val a21 = x21; val a22 = x22 * y22; val a23 = 0.0
    val a30 = 0.0;       val a31 = 0.0; val a32 = 0.0;       val a33 = 1.0
    //
    val n00 = a00 * z00 + a01 * z10 + a02 * z20 + a03 * z30
    val n01 = a00 * z01 + a01 * z11 + a02 * z21 + a03 * z31
    val n02 = a00 * z02 + a01 * z12 + a02 * z22 + a03 * z32
    val n03 = a00 * z03 + a01 * z13 + a02 * z23 + a03 * z33
    val n10 = a10 * z00 + a11 * z10 + a12 * z20 + a13 * z30
    val n11 = a10 * z01 + a11 * z11 + a12 * z21 + a13 * z31
    val n12 = a10 * z02 + a11 * z12 + a12 * z22 + a13 * z32
    val n13 = a10 * z03 + a11 * z13 + a12 * z23 + a13 * z33
    val n20 = a20 * z00 + a21 * z10 + a22 * z20 + a23 * z30
    val n21 = a20 * z01 + a21 * z11 + a22 * z21 + a23 * z31
    val n22 = a20 * z02 + a21 * z12 + a22 * z22 + a23 * z32
    val n23 = a20 * z03 + a21 * z13 + a22 * z23 + a23 * z33
    val n30 = a30 * z00 + a31 * z10 + a32 * z20 + a33 * z30
    val n31 = a30 * z01 + a31 * z11 + a32 * z21 + a33 * z31
    val n32 = a30 * z02 + a31 * z12 + a32 * z22 + a33 * z32
    val n33 = a30 * z03 + a31 * z13 + a32 * z23 + a33 * z33
    //
    val m00 = this.m00 * n00 + this.m01 * n10 + this.m02 * n20
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22
    //
    val m10 = this.m10 * n00 + this.m11 * n10 + this.m12 * n20
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22
    //
    val m20 = this.m20 * n00 + this.m21 * n10 + this.m22 * n20
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22
    //
    val m30 = this.m30 * n00 + this.m31 * n10 + this.m32 * n20
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}
