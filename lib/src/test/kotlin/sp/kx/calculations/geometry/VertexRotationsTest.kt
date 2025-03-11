package sp.kx.calculations.geometry

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import sp.kx.calculations.comparisons.eq

internal class VertexRotationsTest {
    @Test
    fun rotateTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        listOf(
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                Pair(
                    MutableRotation(0.0, 0.0, pi12),
                    MutableVertex(0.0, 1.0, 0.0),
                ),
                Pair(
                    MutableRotation(0.0, 0.0, pi22),
                    MutableVertex(-1.0, 0.0, 0.0),
                ),
                Pair(
                    MutableRotation(0.0, 0.0, pi32),
                    MutableVertex(0.0, -1.0, 0.0),
                ),
            ),
        ).forEach { (vertex, issues) ->
            issues.forEach { issue ->
                val (rotation, expected) = issue
                val actual = rotate(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                assertEquals(expected.x, actual.x, delta)
                assertEquals(expected.y, actual.y, delta)
                assertEquals(expected.z, actual.z, delta)
                assertTrue(actual.eq(expected, exponent))
            }
        }
    }
}
