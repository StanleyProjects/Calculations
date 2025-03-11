package sp.kx.calculations.comparisons

import sp.kx.calculations.algebra.Matrix

fun Matrix.eq(other: Matrix, exponent: Int): Boolean {
    return m00.eq(other.m00, exponent) && m10.eq(other.m10, exponent) && m20.eq(other.m20, exponent) && m30.eq(other.m30, exponent) &&
           m01.eq(other.m01, exponent) && m11.eq(other.m11, exponent) && m21.eq(other.m21, exponent) && m31.eq(other.m31, exponent) &&
           m02.eq(other.m02, exponent) && m12.eq(other.m12, exponent) && m22.eq(other.m22, exponent) && m32.eq(other.m32, exponent) &&
           m03.eq(other.m03, exponent) && m13.eq(other.m13, exponent) && m23.eq(other.m23, exponent) && m33.eq(other.m33, exponent)
}
