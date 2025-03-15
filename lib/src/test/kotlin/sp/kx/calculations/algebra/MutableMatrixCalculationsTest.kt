package sp.kx.calculations.algebra

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions.assertEquals
import sp.kx.calculations.geometry.MutableOffset
import sp.kx.calculations.geometry.MutableRotation
import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.operators.times
import sp.kx.calculations.rotations.rxyz

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

    @Test
    fun scaleTest() {
        val delta = 0.00000001
        val exponent = 8
        val matrix = MutableMatrix()
        listOf(
            MutableVertex(1.0, 2.0, 3.0) to listOf(
                Pair(
                    -1.0,
                    MutableVertex(-1.0, -2.0, -3.0),
                ),
                Pair(
                    0.0,
                    MutableVertex(0.0, 0.0, 0.0),
                ),
                Pair(
                    1.0,
                    MutableVertex(1.0, 2.0, 3.0),
                ),
                Pair(
                    2.0,
                    MutableVertex(2.0, 4.0, 6.0),
                ),
                Pair(
                    12.34,
                    MutableVertex(12.34, 24.68, 37.02),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (scale, expected) ->
                matrix.identity()
                matrix.scale(value = scale)
                val actual = vertex * matrix
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    scale: $scale
                """.trimIndent()
                assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
            }
        }
    }

    @Test
    fun rtsTest() {
        val delta = 0.00000001
        val exponent = 8
        val _pi12 = kotlin.math.PI / 2
        val vertex = MutableVertex(1.0, 0.0, 3.0)
        val offset = MutableOffset(0.0, 0.0, 4.0)
        val rotation = MutableRotation(_pi12, 0.0, _pi12)
        val scale = 3.0
        val matrix = MutableMatrix()
        matrix.identity()
        matrix.scale(scale)
        matrix.translate(offset.dX, offset.dY, offset.dZ)
        matrix.rxyz(rotation.aX, rotation.aY, rotation.aZ)
        val actual = vertex * matrix
        val expected = MutableVertex(9.0, 3.0, 12.0)
        val message = """
            v: $vertex
            e: $expected
            a: $actual
            offset: $offset
            rotation: $rotation
            scale: $scale
        """.trimIndent()
        assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
    }
}
