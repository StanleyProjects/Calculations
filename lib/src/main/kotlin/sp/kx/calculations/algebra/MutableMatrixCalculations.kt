package sp.kx.calculations.algebra

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

fun MutableMatrix.rx(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val n00 = 1.0; val n01 = 0.0; val n02 = 0.0; val n03 = 0.0;
    val n10 = 0.0; val n11 = c;   val n12 = -s;  val n13 = 0.0;
    val n20 = 0.0; val n21 = s;   val n22 = c;   val n23 = 0.0;
    val n30 = 0.0; val n31 = 0.0; val n32 = 0.0; val n33 = 1.0;
    //
    val m00 = this.m00 * n00 + this.m01 * n10 + this.m02 * n20 + this.m03 * n30
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21 + this.m03 * n31
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22 + this.m03 * n32
    val m03 = this.m00 * n03 + this.m01 * n13 + this.m02 * n23 + this.m03 * n33
    //
    val m10 = this.m10 * n00 + this.m11 * n10 + this.m12 * n20 + this.m13 * n30
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21 + this.m13 * n31
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22 + this.m13 * n32
    val m13 = this.m10 * n03 + this.m11 * n13 + this.m12 * n23 + this.m13 * n33
    //
    val m20 = this.m20 * n00 + this.m21 * n10 + this.m22 * n20 + this.m23 * n30
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21 + this.m23 * n31
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22 + this.m23 * n32
    val m23 = this.m20 * n03 + this.m21 * n13 + this.m22 * n23 + this.m23 * n33
    //
    val m30 = this.m30 * n00 + this.m31 * n10 + this.m32 * n20 + this.m33 * n30
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21 + this.m33 * n31
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22 + this.m33 * n32
    val m33 = this.m30 * n03 + this.m31 * n13 + this.m32 * n23 + this.m33 * n33
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03
    this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13
    this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23
    this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33
}

fun MutableMatrix.ry(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val n00 = c;   val n01 = 0.0; val n02 = -s;  val n03 = 0.0;
    val n10 = 0.0; val n11 = 1.0; val n12 = 0.0; val n13 = 0.0;
    val n20 = s;   val n21 = 0.0; val n22 = c;   val n23 = 0.0;
    val n30 = 0.0; val n31 = 0.0; val n32 = 0.0; val n33 = 1.0;
    //
    val m00 = this.m00 * n00 + this.m01 * n10 + this.m02 * n20 + this.m03 * n30
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21 + this.m03 * n31
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22 + this.m03 * n32
    val m03 = this.m00 * n03 + this.m01 * n13 + this.m02 * n23 + this.m03 * n33
    //
    val m10 = this.m10 * n00 + this.m11 * n10 + this.m12 * n20 + this.m13 * n30
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21 + this.m13 * n31
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22 + this.m13 * n32
    val m13 = this.m10 * n03 + this.m11 * n13 + this.m12 * n23 + this.m13 * n33
    //
    val m20 = this.m20 * n00 + this.m21 * n10 + this.m22 * n20 + this.m23 * n30
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21 + this.m23 * n31
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22 + this.m23 * n32
    val m23 = this.m20 * n03 + this.m21 * n13 + this.m22 * n23 + this.m23 * n33
    //
    val m30 = this.m30 * n00 + this.m31 * n10 + this.m32 * n20 + this.m33 * n30
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21 + this.m33 * n31
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22 + this.m33 * n32
    val m33 = this.m30 * n03 + this.m31 * n13 + this.m32 * n23 + this.m33 * n33
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03
    this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13
    this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23
    this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33
}

fun MutableMatrix.rz(radians: Double) {
    val c = kotlin.math.cos(radians)
    val s = kotlin.math.sin(radians)
    //
    val n00 = c;   val n01 = -s;  val n02 = 0.0; val n03 = 0.0;
    val n10 = s;   val n11 = c;   val n12 = 0.0; val n13 = 0.0;
    val n20 = 0.0; val n21 = 0.0; val n22 = 1.0; val n23 = 0.0;
    val n30 = 0.0; val n31 = 0.0; val n32 = 0.0; val n33 = 1.0;
    //
    val m00 = this.m00 * n00 + this.m01 * n10 + this.m02 * n20 + this.m03 * n30
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21 + this.m03 * n31
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22 + this.m03 * n32
    val m03 = this.m00 * n03 + this.m01 * n13 + this.m02 * n23 + this.m03 * n33
    //
    val m10 = this.m10 * n00 + this.m11 * n10 + this.m12 * n20 + this.m13 * n30
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21 + this.m13 * n31
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22 + this.m13 * n32
    val m13 = this.m10 * n03 + this.m11 * n13 + this.m12 * n23 + this.m13 * n33
    //
    val m20 = this.m20 * n00 + this.m21 * n10 + this.m22 * n20 + this.m23 * n30
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21 + this.m23 * n31
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22 + this.m23 * n32
    val m23 = this.m20 * n03 + this.m21 * n13 + this.m22 * n23 + this.m23 * n33
    //
    val m30 = this.m30 * n00 + this.m31 * n10 + this.m32 * n20 + this.m33 * n30
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21 + this.m33 * n31
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22 + this.m33 * n32
    val m33 = this.m30 * n03 + this.m31 * n13 + this.m32 * n23 + this.m33 * n33
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03
    this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13
    this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23
    this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33
}

fun MutableMatrix.rotate(aX: Double, aY: Double, aZ: Double) {
    val cX = kotlin.math.cos(aX)
    val cY = kotlin.math.cos(aY)
    val cZ = kotlin.math.cos(aZ)
    val sX = kotlin.math.sin(aX)
    val sY = -kotlin.math.sin(aY)
    val sZ = kotlin.math.sin(aZ)
    //
//    val x00 = 1.0; val x01 = 0.0; val x02 = 0.0; val x03 = 0.0;
//    val x10 = 0.0; val x11 = cX;  val x12 = -sX; val x13 = 0.0;
//    val x20 = 0.0; val x21 = sX;  val x22 = cX;  val x23 = 0.0;
//    val x30 = 0.0; val x31 = 0.0; val x32 = 0.0; val x33 = 1.0;
//    //
    val y00 = cY;  val y01 = 0.0; val y02 = -sY; val y03 = 0.0;
    val y10 = 0.0; val y11 = 1.0; val y12 = 0.0; val y13 = 0.0;
    val y20 = sY;  val y21 = 0.0; val y22 = cY;  val y23 = 0.0;
    val y30 = 0.0; val y31 = 0.0; val y32 = 0.0; val y33 = 1.0;
//    //
    val z00 = cZ;  val z01 = -sZ; val z02 = 0.0; val z03 = 0.0;
    val z10 = sZ;  val z11 = cZ;  val z12 = 0.0; val z13 = 0.0;
    val z20 = 0.0; val z21 = 0.0; val z22 = 1.0; val z23 = 0.0;
    val z30 = 0.0; val z31 = 0.0; val z32 = 0.0; val z33 = 1.0;
    //
//    val n00 = cZ * cY; val n01 = cZ * sY * sX - sZ * cX; val n02 = cZ * sY * cX + sZ * sX; val n03 = 0.0;
//    val n10 = sZ * cY; val n11 = sZ * sY * sX + cZ * cX; val n12 = sZ * sY * cX - cZ * sX; val n13 = 0.0;
//    val n20 = -sY;     val n21 = cY * sX;                val n22 = cY * cX;                val n23 = 0.0;
//    val n30 = 0.0;     val n31 = 0.0;                    val n32 = 0.0;                    val n33 = 1.0;
    //
    val n00 = cZ * cY; val n01 = cZ * sY * sX - sZ * cX; val n02 = cZ * sY * cX + sZ * sX; val n03 = 0.0;
    val n10 = sZ * cY; val n11 = sZ * sY * sX + cZ * cX; val n12 = sZ * sY * cX - cZ * sX; val n13 = 0.0;
    val n20 = -sY;     val n21 = cY * sX;                val n22 = cY * cX;                val n23 = 0.0;
    val n30 = 0.0;     val n31 = 0.0;                    val n32 = 0.0;                    val n33 = 1.0;
    //
    val m00 = this.m00 * n00 + this.m01 * n10 + this.m02 * n20 + this.m03 * n30
    val m01 = this.m00 * n01 + this.m01 * n11 + this.m02 * n21 + this.m03 * n31
    val m02 = this.m00 * n02 + this.m01 * n12 + this.m02 * n22 + this.m03 * n32
    val m03 = this.m00 * n03 + this.m01 * n13 + this.m02 * n23 + this.m03 * n33
    //
    val m10 = this.m10 * n00 + this.m11 * n10 + this.m12 * n20 + this.m13 * n30
    val m11 = this.m10 * n01 + this.m11 * n11 + this.m12 * n21 + this.m13 * n31
    val m12 = this.m10 * n02 + this.m11 * n12 + this.m12 * n22 + this.m13 * n32
    val m13 = this.m10 * n03 + this.m11 * n13 + this.m12 * n23 + this.m13 * n33
    //
    val m20 = this.m20 * n00 + this.m21 * n10 + this.m22 * n20 + this.m23 * n30
    val m21 = this.m20 * n01 + this.m21 * n11 + this.m22 * n21 + this.m23 * n31
    val m22 = this.m20 * n02 + this.m21 * n12 + this.m22 * n22 + this.m23 * n32
    val m23 = this.m20 * n03 + this.m21 * n13 + this.m22 * n23 + this.m23 * n33
    //
    val m30 = this.m30 * n00 + this.m31 * n10 + this.m32 * n20 + this.m33 * n30
    val m31 = this.m30 * n01 + this.m31 * n11 + this.m32 * n21 + this.m33 * n31
    val m32 = this.m30 * n02 + this.m31 * n12 + this.m32 * n22 + this.m33 * n32
    val m33 = this.m30 * n03 + this.m31 * n13 + this.m32 * n23 + this.m33 * n33
    //
    this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03
    this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13
    this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23
    this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33
}
