package sp.kx.calculations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
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
}
