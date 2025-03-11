package sp.kx.calculations.algebra

import java.util.Objects

@Suppress("ktlint:standard:parameter-list-wrapping")
class MutableMatrix(
    override var m00: Double, override var m10: Double, override var m20: Double, override var m30: Double,
    override var m01: Double, override var m11: Double, override var m21: Double, override var m31: Double,
    override var m02: Double, override var m12: Double, override var m22: Double, override var m32: Double,
    override var m03: Double, override var m13: Double, override var m23: Double, override var m33: Double,
) : Matrix {
    constructor() : this(
        m00 = 0.0, m01 = 0.0, m02 = 0.0, m03 = 0.0,
        m10 = 0.0, m11 = 0.0, m12 = 0.0, m13 = 0.0,
        m20 = 0.0, m21 = 0.0, m22 = 0.0, m23 = 0.0,
        m30 = 0.0, m31 = 0.0, m32 = 0.0, m33 = 0.0,
    )

    @Suppress("ktlint:standard:indent")
    override fun equals(other: Any?): Boolean {
        return when (other) {
            is Matrix -> {
                m00 == other.m00 && m10 == other.m10 && m20 == other.m20 && m30 == other.m30 &&
                m01 == other.m01 && m11 == other.m11 && m21 == other.m21 && m31 == other.m31 &&
                m02 == other.m02 && m12 == other.m12 && m22 == other.m22 && m32 == other.m32 &&
                m03 == other.m03 && m13 == other.m13 && m23 == other.m23 && m33 == other.m33
            }
            else -> false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(
            m00, m10, m20, m30,
            m01, m11, m21, m31,
            m02, m12, m22, m32,
            m03, m13, m23, m33,
        )
    }

    fun set(other: Matrix) {
        m00 = other.m00; m01 = other.m01; m02 = other.m02; m03 = other.m03
        m10 = other.m10; m11 = other.m11; m12 = other.m12; m13 = other.m13
        m20 = other.m20; m21 = other.m21; m22 = other.m22; m23 = other.m23
        m30 = other.m30; m31 = other.m31; m32 = other.m32; m33 = other.m33
    }
}

fun Matrix.mut(): MutableMatrix {
    return MutableMatrix(
        m00 = m00, m01 = m01, m02 = m02, m03 = m03,
        m10 = m10, m11 = m11, m12 = m12, m13 = m13,
        m20 = m20, m21 = m21, m22 = m22, m23 = m23,
        m30 = m30, m31 = m31, m32 = m32, m33 = m33,
    )
}
