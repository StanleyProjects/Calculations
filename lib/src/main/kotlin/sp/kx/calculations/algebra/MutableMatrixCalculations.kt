package sp.kx.calculations.algebra

@Suppress("ktlint:standard:wrapping")
fun MutableMatrix.identity() {
    m00 = 1.0; m01 = 0.0; m02 = 0.0; m03 = 0.0
    m10 = 0.0; m11 = 1.0; m12 = 0.0; m13 = 0.0
    m20 = 0.0; m21 = 0.0; m22 = 1.0; m23 = 0.0
    m30 = 0.0; m31 = 0.0; m32 = 0.0; m33 = 1.0
}

fun MutableMatrix.translate(dX: Double, dY: Double, dZ: Double) {
    m03 += m00 * dX + m01 * dY + m02 * dZ
    m13 += m10 * dX + m11 * dY + m12 * dZ
    m23 += m20 * dX + m21 * dY + m22 * dZ
    m33 += m30 * dX + m31 * dY + m32 * dZ
}

@Suppress("ktlint:standard:wrapping")
fun MutableMatrix.rx(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val m01 = this.m01 * c + this.m02 * s
    val m02 = this.m02 * c - this.m01 * s
    //
    val m11 = this.m11 * c + this.m12 * s
    val m12 = this.m12 * c - this.m11 * s
    //
    val m21 = this.m21 * c + this.m22 * s
    val m22 = this.m22 * c - this.m21 * s
    //
    val m31 = this.m31 * c + this.m32 * s
    val m32 = this.m32 * c - this.m31 * s
    //
    this.m01 = m01; this.m02 = m02
    this.m11 = m11; this.m12 = m12
    this.m21 = m21; this.m22 = m22
    this.m31 = m31; this.m32 = m32
}

@Suppress("ktlint:standard:wrapping")
fun MutableMatrix.ry(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val n00 = c; val n01 = 0.0; val n02 = -s
    val n20 = s; val n21 = 0.0; val n22 = c
    //
    val m00 = this.m00 * n00 + this.m02 * n20
    val m01 = this.m00 * n01 + this.m01 + this.m02 * n21
    val m02 = this.m00 * n02 + this.m02 * n22
    //
    val m10 = this.m10 * n00 + this.m12 * n20
    val m11 = this.m10 * n01 + this.m11 + this.m12 * n21
    val m12 = this.m10 * n02 + this.m12 * n22
    //
    val m20 = this.m20 * n00 + this.m22 * n20
    val m21 = this.m20 * n01 + this.m21 + this.m22 * n21
    val m22 = this.m20 * n02 + this.m22 * n22
    //
    val m30 = this.m30 * n00 + this.m32 * n20
    val m31 = this.m30 * n01 + this.m31 + this.m32 * n21
    val m32 = this.m30 * n02 + this.m32 * n22
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}

@Suppress("ktlint:standard:wrapping")
fun MutableMatrix.rz(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val n00 = c; val n01 = -s
    val n10 = s; val n11 = c
    //
    val m00 = this.m00 * n00 + this.m01 * n10
    val m01 = this.m00 * n01 + this.m01 * n11
    val m02 = this.m02
    //
    val m10 = this.m10 * n00 + this.m11 * n10
    val m11 = this.m10 * n01 + this.m11 * n11
    val m12 = this.m12
    //
    val m20 = this.m20 * n00 + this.m21 * n10
    val m21 = this.m20 * n01 + this.m21 * n11
    val m22 = this.m22
    //
    val m30 = this.m30 * n00 + this.m31 * n10
    val m31 = this.m30 * n01 + this.m31 * n11
    val m32 = this.m32
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02
    this.m10 = m10; this.m11 = m11; this.m12 = m12
    this.m20 = m20; this.m21 = m21; this.m22 = m22
    this.m30 = m30; this.m31 = m31; this.m32 = m32
}

@Suppress("ktlint:standard:wrapping")
fun MutableMatrix.rotate(aX: Double, aY: Double, aZ: Double) {
    val cX = kotlin.math.cos(aX)
    val cY = kotlin.math.cos(aY)
    val cZ = kotlin.math.cos(aZ)
    val sX = kotlin.math.sin(aX)
    val sY = kotlin.math.sin(aY)
    val sZ = kotlin.math.sin(aZ)
    //
    val n00 = cY * cZ; val n01 = cY * -sZ; val n02 = -sY
    val n10 = -sX * sY * cZ + cX * sZ; val n11 = -sX * sY * -sZ + cX * cZ; val n12 = -sX * cY
    val n20 = cX * sY * cZ + sX * sZ; val n21 = cX * sY * -sZ + sX * cZ; val n22 = cX * cY
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

@Suppress("ktlint:standard:wrapping")
fun MutableMatrix.scale(value: Double) {
    m00 *= value; m01 *= value; m02 *= value
    m10 *= value; m11 *= value; m12 *= value
    m20 *= value; m21 *= value; m22 *= value
    m30 *= value; m31 *= value; m32 *= value
}

@Suppress("ktlint:standard:wrapping")
private fun MutableMatrix.rotateZYX(aX: Double, aY: Double, aZ: Double) {
    val cX = kotlin.math.cos(aX)
    val cY = kotlin.math.cos(aY)
    val cZ = kotlin.math.cos(aZ)
    val sX = kotlin.math.sin(aX)
    val sY = kotlin.math.sin(aY)
    val sZ = kotlin.math.sin(aZ)
    //
    val x00 = 1.0; val x01 = 0.0; val x02 = 0.0; val x03 = 0.0
    val x10 = 0.0; val x11 = cX; val x12 = -sX; val x13 = 0.0
    val x20 = 0.0; val x21 = sX; val x22 = cX; val x23 = 0.0
    val x30 = 0.0; val x31 = 0.0; val x32 = 0.0; val x33 = 1.0
//    //
    val y00 = cY; val y01 = 0.0; val y02 = -sY; val y03 = 0.0
    val y10 = 0.0; val y11 = 1.0; val y12 = 0.0; val y13 = 0.0
    val y20 = sY; val y21 = 0.0; val y22 = cY; val y23 = 0.0
    val y30 = 0.0; val y31 = 0.0; val y32 = 0.0; val y33 = 1.0
//    //
    val z00 = cZ; val z01 = -sZ; val z02 = 0.0; val z03 = 0.0
    val z10 = sZ; val z11 = cZ; val z12 = 0.0; val z13 = 0.0
    val z20 = 0.0; val z21 = 0.0; val z22 = 1.0; val z23 = 0.0
    val z30 = 0.0; val z31 = 0.0; val z32 = 0.0; val z33 = 1.0
    //
//    val n00 = cZ;  val n01 = -sZ; val n02 = 0.0; val n03 = 0.0;
//    val n10 = sZ;  val n11 = cZ;  val n12 = 0.0; val n13 = 0.0;
//    val n20 = 0.0; val n21 = 0.0; val n22 = 1.0; val n23 = 0.0;
//    val n30 = 0.0; val n31 = 0.0; val n32 = 0.0; val n33 = 1.0;
    //
//    val n00 = cZ * cY; val n01 = cZ * sY * sX - sZ * cX; val n02 = cZ * sY * cX + sZ * sX; val n03 = 0.0;
//    val n10 = sZ * cY; val n11 = sZ * sY * sX + cZ * cX; val n12 = sZ * sY * cX - cZ * sX; val n13 = 0.0;
//    val n20 = -sY;     val n21 = cY * sX;                val n22 = cY * cX;                val n23 = 0.0;
//    val n30 = 0.0;     val n31 = 0.0;                    val n32 = 0.0;                    val n33 = 1.0;
    //
//    val n00 = z00 * y00 + z01 * y10 + z02 * y20 + z03 * y30
//    val n01 = z00 * y01 + z01 * y11 + z02 * y21 + z03 * y31
//    val n02 = z00 * y02 + z01 * y12 + z02 * y22 + z03 * y32
//    val n03 = z00 * y03 + z01 * y13 + z02 * y23 + z03 * y33
    //
//    val a00 = 1.0 * y00 + 0.0 * y10 + 0.0 * y20 + 0.0 * y30
//    val a01 = 1.0 * y01 + 0.0 * y11 + 0.0 * y21 + 0.0 * y31
//    val a02 = 1.0 * y02 + 0.0 * y12 + 0.0 * y22 + 0.0 * y32
//    val a03 = 1.0 * y03 + 0.0 * y13 + 0.0 * y23 + 0.0 * y33
//    val a10 = 0.0 * y00 + x11 * y10 + x12 * y20 + 0.0 * y30
//    val a11 = 0.0 * y01 + x11 * y11 + x12 * y21 + 0.0 * y31
//    val a12 = 0.0 * y02 + x11 * y12 + x12 * y22 + 0.0 * y32
//    val a13 = 0.0 * y03 + x11 * y13 + x12 * y23 + 0.0 * y33
//    val a20 = 0.0 * y00 + x21 * y10 + x22 * y20 + 0.0 * y30
//    val a21 = 0.0 * y01 + x21 * y11 + x22 * y21 + 0.0 * y31
//    val a22 = 0.0 * y02 + x21 * y12 + x22 * y22 + 0.0 * y32
//    val a23 = 0.0 * y03 + x21 * y13 + x22 * y23 + 0.0 * y33
//    val a30 = 0.0 * y00 + 0.0 * y10 + 0.0 * y20 + 1.0 * y30
//    val a31 = 0.0 * y01 + 0.0 * y11 + 0.0 * y21 + 1.0 * y31
//    val a32 = 0.0 * y02 + 0.0 * y12 + 0.0 * y22 + 1.0 * y32
//    val a33 = 0.0 * y03 + 0.0 * y13 + 0.0 * y23 + 1.0 * y33
    //
    val a00 = y00; val a01 = 0.0; val a02 = y02; val a03 = 0.0
    val a10 = x12 * y20; val a11 = x11; val a12 = x12 * y22; val a13 = 0.0
    val a20 = x22 * y20; val a21 = x21; val a22 = x22 * y22; val a23 = 0.0
    val a30 = 0.0; val a31 = 0.0; val a32 = 0.0; val a33 = 1.0
    //
//    val a00 = z00 * y00; val a01 = z01; val a02 = z00 * y02; val a03 = 0.0
//    val a10 = z10 * y00; val a11 = z11; val a12 = z10 * y02; val a13 = 0.0
//    val a20 = y20;       val a21 = 0.0; val a22 = y22;       val a23 = 0.0
//    val a30 = 0.0;       val a31 = 0.0; val a32 = 0.0;       val a33 = 1.0
    //
//    val n00 = z00 * y00 + z01 * 0.0 + 0.0 * y20 + 0.0 * 0.0
//    val n01 = z00 * 0.0 + z01 * 1.0 + 0.0 * 0.0 + 0.0 * 0.0
//    val n02 = z00 * y02 + z01 * 0.0 + 0.0 * y22 + 0.0 * 0.0
//    val n03 = z00 * 0.0 + z01 * 0.0 + 0.0 * 0.0 + 0.0 * 1.0
//    val n10 = z10 * y00 + z11 * 0.0 + 0.0 * y20 + 0.0 * 0.0
//    val n11 = z10 * 0.0 + z11 * 1.0 + 0.0 * 0.0 + 0.0 * 0.0
//    val n12 = z10 * y02 + z11 * 0.0 + 0.0 * y22 + 0.0 * 0.0
//    val n13 = z10 * 0.0 + z11 * 0.0 + 0.0 * 0.0 + 0.0 * 1.0
//    val n20 = 0.0 * y00 + 0.0 * 0.0 + 1.0 * y20 + 0.0 * 0.0
//    val n21 = 0.0 * 0.0 + 0.0 * 1.0 + 1.0 * 0.0 + 0.0 * 0.0
//    val n22 = 0.0 * y02 + 0.0 * 0.0 + 1.0 * y22 + 0.0 * 0.0
//    val n23 = 0.0 * 0.0 + 0.0 * 0.0 + 1.0 * 0.0 + 0.0 * 1.0
//    val n30 = 0.0 * y00 + 0.0 * 0.0 + 0.0 * y20 + 1.0 * 0.0
//    val n31 = 0.0 * 0.0 + 0.0 * 1.0 + 0.0 * 0.0 + 1.0 * 0.0
//    val n32 = 0.0 * y02 + 0.0 * 0.0 + 0.0 * y22 + 1.0 * 0.0
//    val n33 = 0.0 * 0.0 + 0.0 * 0.0 + 0.0 * 0.0 + 1.0 * 1.0
    //
//    val n00 = z00 * y00 + z01 * y10 + z02 * y20 + z03 * y30
//    val n01 = z00 * y01 + z01 * y11 + z02 * y21 + z03 * y31
//    val n02 = z00 * y02 + z01 * y12 + z02 * y22 + z03 * y32
//    val n03 = z00 * y03 + z01 * y13 + z02 * y23 + z03 * y33
//    val n10 = z10 * y00 + z11 * y10 + z12 * y20 + z13 * y30
//    val n11 = z10 * y01 + z11 * y11 + z12 * y21 + z13 * y31
//    val n12 = z10 * y02 + z11 * y12 + z12 * y22 + z13 * y32
//    val n13 = z10 * y03 + z11 * y13 + z12 * y23 + z13 * y33
//    val n20 = z20 * y00 + z21 * y10 + z22 * y20 + z23 * y30
//    val n21 = z20 * y01 + z21 * y11 + z22 * y21 + z23 * y31
//    val n22 = z20 * y02 + z21 * y12 + z22 * y22 + z23 * y32
//    val n23 = z20 * y03 + z21 * y13 + z22 * y23 + z23 * y33
//    val n30 = z30 * y00 + z31 * y10 + z32 * y20 + z33 * y30
//    val n31 = z30 * y01 + z31 * y11 + z32 * y21 + z33 * y31
//    val n32 = z30 * y02 + z31 * y12 + z32 * y22 + z33 * y32
//    val n33 = z30 * y03 + z31 * y13 + z32 * y23 + z33 * y33
    //
//    val n00 = a00 * z00 + a01 * z10 + a02 * z20 + a03 * z30
//    val n01 = a00 * z01 + a01 * z11 + a02 * z21 + a03 * z31
//    val n02 = a00 * z02 + a01 * z12 + a02 * z22 + a03 * z32
//    val n03 = a00 * z03 + a01 * z13 + a02 * z23 + a03 * z33
//    val n10 = a10 * z00 + a11 * z10 + a12 * z20 + a13 * z30
//    val n11 = a10 * z01 + a11 * z11 + a12 * z21 + a13 * z31
//    val n12 = a10 * z02 + a11 * z12 + a12 * z22 + a13 * z32
//    val n13 = a10 * z03 + a11 * z13 + a12 * z23 + a13 * z33
//    val n20 = a20 * z00 + a21 * z10 + a22 * z20 + a23 * z30
//    val n21 = a20 * z01 + a21 * z11 + a22 * z21 + a23 * z31
//    val n22 = a20 * z02 + a21 * z12 + a22 * z22 + a23 * z32
//    val n23 = a20 * z03 + a21 * z13 + a22 * z23 + a23 * z33
//    val n30 = a30 * z00 + a31 * z10 + a32 * z20 + a33 * z30
//    val n31 = a30 * z01 + a31 * z11 + a32 * z21 + a33 * z31
//    val n32 = a30 * z02 + a31 * z12 + a32 * z22 + a33 * z32
//    val n33 = a30 * z03 + a31 * z13 + a32 * z23 + a33 * z33
    //
    val n00 = y00 * z00; val n01 = y00 * z01; val n02 = y02
    val n10 = x12 * y20 * z00 + x11 * z10; val n11 = x12 * y20 * z01 + x11 * z11; val n12 = x12 * y22
    val n20 = x22 * y20 * z00 + x21 * z10; val n21 = x22 * y20 * z01 + x21 * z11; val n22 = x22 * y22
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
