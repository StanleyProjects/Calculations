package sp.kx.calculations.algebra

@Suppress("ktlint:standard:wrapping")
interface Matrix {
    val m00: Double; val m01: Double; val m02: Double; val m03: Double
    val m10: Double; val m11: Double; val m12: Double; val m13: Double
    val m20: Double; val m21: Double; val m22: Double; val m23: Double
    val m30: Double; val m31: Double; val m32: Double; val m33: Double

    companion object {
        val Id = MutableMatrix(
            m00 = 1.0, m01 = 0.0, m02 = 0.0, m03 = 0.0,
            m10 = 0.0, m11 = 1.0, m12 = 0.0, m13 = 0.0,
            m20 = 0.0, m21 = 0.0, m22 = 1.0, m23 = 0.0,
            m30 = 0.0, m31 = 0.0, m32 = 0.0, m33 = 1.0,
        )
    }
}

@Suppress("ktlint:standard:parameter-list-wrapping")
fun Matrix.copy(
    m00: Double = this.m00, m01: Double = this.m01, m02: Double = this.m02, m03: Double = this.m03,
    m10: Double = this.m10, m11: Double = this.m11, m12: Double = this.m12, m13: Double = this.m13,
    m20: Double = this.m20, m21: Double = this.m21, m22: Double = this.m22, m23: Double = this.m23,
    m30: Double = this.m30, m31: Double = this.m31, m32: Double = this.m32, m33: Double = this.m33,
): Matrix {
    return MutableMatrix(
        m00 = m00, m01 = m01, m02 = m02, m03 = m03,
        m10 = m10, m11 = m11, m12 = m12, m13 = m13,
        m20 = m20, m21 = m21, m22 = m22, m23 = m23,
        m30 = m30, m31 = m31, m32 = m32, m33 = m33,
    )
}
