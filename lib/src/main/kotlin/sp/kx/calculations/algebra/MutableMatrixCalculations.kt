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
fun MutableMatrix.scale(value: Double) {
    m00 *= value; m01 *= value; m02 *= value
    m10 *= value; m11 *= value; m12 *= value
    m20 *= value; m21 *= value; m22 *= value
    m30 *= value; m31 *= value; m32 *= value
}
