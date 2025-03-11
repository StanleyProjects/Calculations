package sp.kx.calculations.algebra

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions.assertEquals
import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.operators.times

internal class MutableMatrixCalculationsTest {
    @Test
    fun translateTest() {
        val delta = 0.00000001
        val exponent = 8
        val matrix = MutableMatrix()
        matrix.identity()
        matrix.translate(dX = 1.0, dY = 0.0, dZ = 0.0)
        matrix.translate(dX = 0.0, dY = 1.0, dZ = 0.0)
        matrix.translate(dX = 0.0, dY = 0.0, dZ = 2.0)
        matrix.translate(dX = 0.0, dY = -2.0, dZ = 0.0)
        val vertex = MutableVertex(0.0, 0.0, 0.0)
        val actual = vertex * matrix
        val expected = MutableVertex(1.0, -1.0, 2.0)
        val message = """
            e: $expected
            a: $actual
        """.trimIndent()
        assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
    }
}
