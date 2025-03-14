package sp.kx.calculations.geometry

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.Assertions.assertEquals

internal class MutableVertexRotatorTest {
    @Test
    fun rotateXYZTest() {
        val delta = 0.00000001
        val exponent = 8
        val rotator: Rotator<MutableVertex> = MutableVertexRotator.XYZ
        Assertions.Rotations.Issues.XYZ.forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (rotation, expected) ->
                val issuer = vertex.mut()
                rotator.rotate(
                    issuer = issuer,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                val message = """
                    $i/$j
                    v: $vertex
                    r: $rotation
                    e: $expected
                    a: $issuer
                """.trimIndent()
                assertEquals(
                    expected = expected,
                    actual = issuer,
                    delta = delta,
                    exponent = exponent,
                    message = message,
                )
            }
        }
    }

    @Test
    fun rotateZYXTest() {
        val delta = 0.00000001
        val exponent = 8
        val rotator: Rotator<MutableVertex> = MutableVertexRotator.ZYX
        Assertions.Rotations.Issues.ZYX.forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (rotation, expected) ->
                val issuer = vertex.mut()
                rotator.rotate(
                    issuer = issuer,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                val message = """
                    $i/$j
                    v: $vertex
                    r: $rotation
                    e: $expected
                    a: $issuer
                """.trimIndent()
                assertEquals(
                    expected = expected,
                    actual = issuer,
                    delta = delta,
                    exponent = exponent,
                    message = message,
                )
            }
        }
    }
}
