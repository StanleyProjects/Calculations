package sp.kx.calculations.geometry

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions.assertEquals

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
                    MutableRotation(0.0, 0.0, 0.0),
                    MutableVertex(1.0, 0.0, 0.0),
                ),
                //
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
                //
                Pair(
                    MutableRotation(0.0, aY = pi12, 0.0),
                    MutableVertex(0.0, 0.0, z = 1.0),
                ),
                Pair(
                    MutableRotation(0.0, aY = pi22, 0.0),
                    MutableVertex(-1.0, 0.0, 0.0),
                ),
                Pair(
                    MutableRotation(0.0, aY = pi32, 0.0),
                    MutableVertex(0.0, 0.0, -1.0),
                ),
            ),
            MutableVertex(0.0, 1.0, 0.0) to listOf(
                Pair(
                    MutableRotation(0.0, 0.0, 0.0),
                    MutableVertex(0.0, 1.0, 0.0),
                ),
                //
                Pair(
                    MutableRotation(pi12, 0.0, 0.0),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    MutableRotation(pi22, 0.0, 0.0),
                    MutableVertex(0.0, -1.0, 0.0),
                ),
                Pair(
                    MutableRotation(pi32, 0.0, 0.0),
                    MutableVertex(0.0, 0.0, -1.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, issue ->
                val (rotation, expected) = issue
                val actual = rotate(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                val message = """
                    $i/$j
                    e: $expected
                    a: $actual
                    r: $rotation
                """.trimIndent()
                assertEquals(
                    expected = expected,
                    actual = actual,
                    delta = delta,
                    exponent = exponent,
                    message = message,
                )
            }
        }
    }
}
