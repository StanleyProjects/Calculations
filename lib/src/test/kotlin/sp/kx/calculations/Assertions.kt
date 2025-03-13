package sp.kx.calculations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import sp.kx.calculations.algebra.Matrix
import sp.kx.calculations.comparisons.eq
import sp.kx.calculations.geometry.Vertex

internal object Assertions {
    fun assertEquals(
        expected: Vertex,
        actual: Vertex,
        delta: Double,
        exponent: Int,
        message: String,
    ) {
        assertEquals(expected.x, actual.x, delta, message)
        assertEquals(expected.y, actual.y, delta, message)
        assertEquals(expected.z, actual.z, delta, message)
        assertTrue(actual.eq(expected, exponent), message)
    }

    @Suppress("ktlint:standard:wrapping")
    fun assertEquals(
        expected: Matrix,
        actual: Matrix,
        delta: Double,
        exponent: Int,
        message: String,
    ) {
        assertEquals(expected.m00, actual.m00, delta, message + "\n00"); assertEquals(expected.m10, actual.m10, delta, message + "\n10"); assertEquals(expected.m20, actual.m20, delta, message + "\n20"); assertEquals(expected.m30, actual.m30, delta, message + "\n30")
        assertEquals(expected.m01, actual.m01, delta, message + "\n01"); assertEquals(expected.m11, actual.m11, delta, message + "\n11"); assertEquals(expected.m21, actual.m21, delta, message + "\n21"); assertEquals(expected.m31, actual.m31, delta, message + "\n31")
        assertEquals(expected.m02, actual.m02, delta, message + "\n02"); assertEquals(expected.m12, actual.m12, delta, message + "\n12"); assertEquals(expected.m22, actual.m22, delta, message + "\n22"); assertEquals(expected.m32, actual.m32, delta, message + "\n32")
        assertEquals(expected.m03, actual.m03, delta, message + "\n03"); assertEquals(expected.m13, actual.m13, delta, message + "\n13"); assertEquals(expected.m23, actual.m23, delta, message + "\n23"); assertEquals(expected.m33, actual.m33, delta, message + "\n33")
        assertTrue(actual.eq(expected, exponent), message)
    }
}
