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

    fun assertEquals(
        expected: Matrix,
        actual: Matrix,
        delta: Double,
        exponent: Int,
        message: String,
    ) {
        assertEquals(expected.m00, actual.m00, delta, message + "\nm00"); assertEquals(expected.m10, actual.m10, delta, message + "\nm10"); assertEquals(expected.m20, actual.m20, delta, message + "\nm20"); assertEquals(expected.m30, actual.m30, delta, message + "\nm30")
        assertEquals(expected.m01, actual.m01, delta, message + "\nm01"); assertEquals(expected.m11, actual.m11, delta, message + "\nm11"); assertEquals(expected.m21, actual.m21, delta, message + "\nm21"); assertEquals(expected.m31, actual.m31, delta, message + "\nm31")
        assertEquals(expected.m02, actual.m02, delta, message + "\nm02"); assertEquals(expected.m12, actual.m12, delta, message + "\nm12"); assertEquals(expected.m22, actual.m22, delta, message + "\nm22"); assertEquals(expected.m32, actual.m32, delta, message + "\nm32")
        assertEquals(expected.m03, actual.m03, delta, message + "\nm03"); assertEquals(expected.m13, actual.m13, delta, message + "\nm13"); assertEquals(expected.m23, actual.m23, delta, message + "\nm23"); assertEquals(expected.m33, actual.m33, delta, message + "\nm33")
        assertTrue(actual.eq(expected, exponent), message)
    }
}
