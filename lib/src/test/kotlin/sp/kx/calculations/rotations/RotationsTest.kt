package sp.kx.calculations.rotations

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.Assertions.assertEquals

internal class RotationsTest {
    @Test
    fun rxTest() {
        val delta = 0.00000001
        val exponent = 8
        Assertions.Rotations.Issues.X.forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians: Double, expected) ->
                val actual = rx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                )
                val message = """
                    $i/$j
                    v: $vertex
                    r: $radians
                    e: $expected
                    a: $actual
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

    @Test
    fun ryTest() {
        val delta = 0.00000001
        val exponent = 8
        Assertions.Rotations.Issues.Y.forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians: Double, expected) ->
                val actual = ry(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                )
                val message = """
                    $i/$j
                    v: $vertex
                    r: $radians
                    e: $expected
                    a: $actual
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
