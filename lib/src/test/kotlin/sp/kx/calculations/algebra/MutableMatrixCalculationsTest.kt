package sp.kx.calculations.algebra

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions.assertEquals
import sp.kx.calculations.geometry.MutableRotation
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

    @Test
    fun rotateMatrixTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi13 = kotlin.math.PI / 3
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
//        val rotation = MutableRotation(0.0, 0.0, 0.0)
//        val rotation = MutableRotation(0.0, 0.0, pi12)
//        val rotation = MutableRotation(0.0, pi12, pi12)
//        val rotation = MutableRotation(pi12, pi12, pi12)
        val rotation = MutableRotation(pi13, pi13, pi13)
        val actual = MutableMatrix()
        actual.identity()
        actual.rotate(aX = rotation.aX, aY = rotation.aY, aZ = rotation.aZ)
        val expected = MutableMatrix()
        expected.identity()
        expected.rx(rotation.aX)
        expected.ry(rotation.aY)
        expected.rz(rotation.aZ)
//        expected.ry(rotation.aY)
//        expected.rx(rotation.aX)
        val message = """
            rotation: $rotation
        """.trimIndent()
        assertEquals(
            expected = expected,
            actual = actual,
            delta = delta,
            exponent = exponent,
            message = message,
        )
    }

    @Test
    fun rotateTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        val matrix = MutableMatrix()
        listOf(
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                // 00
                Pair(
                    MutableRotation(0.0, 0.0, 0.0),
                    MutableVertex(1.0, 0.0, 0.0),
                ),
                // 01
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
                // 04
                Pair(
                    MutableRotation(0.0, pi12, 0.0),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    MutableRotation(0.0, pi22, 0.0),
                    MutableVertex(-1.0, 0.0, 0.0),
                ),
                Pair(
                    MutableRotation(0.0, pi32, 0.0),
                    MutableVertex(0.0, 0.0, -1.0),
                ),
                // 07
                Pair(
                    MutableRotation(pi12, 0.0, pi12),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    MutableRotation(pi12, pi12, 0.0),
                    MutableVertex(0.0, -1.0, 0.0),
                ),
                Pair(
                    MutableRotation(-pi12, pi12, 0.0),
                    MutableVertex(0.0, 1.0, 0.0),
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
                //
                Pair(
                    MutableRotation(0.0, pi12, pi12),
                    MutableVertex(0.0, 0.0, -1.0),
                ),
                Pair(
                    MutableRotation(0.0, pi12, -pi12),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (rotation, expected) ->
                matrix.identity()
                matrix.rotate(aX = rotation.aX, aY = rotation.aY, aZ = rotation.aZ)
//                matrix.rotate(aX = rotation.aX, aY = 0.0, aZ = 0.0)
//                matrix.rotate(aX = 0.0, aY = rotation.aY, aZ = 0.0)
//                matrix.rotate(aX = 0.0, aY = 0.0, aZ = rotation.aZ)
//                matrix.rx(rotation.aX)
//                matrix.ry(rotation.aY)
//                matrix.rz(rotation.aZ)
                val actual = vertex * matrix
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    r: $rotation
                """.trimIndent()
                assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
            }
        }
    }

    @Test
    fun rzyxTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        val matrix = MutableMatrix()
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
                    MutableRotation(0.0, pi12, 0.0),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    MutableRotation(0.0, pi22, 0.0),
                    MutableVertex(-1.0, 0.0, 0.0),
                ),
                Pair(
                    MutableRotation(0.0, pi32, 0.0),
                    MutableVertex(0.0, 0.0, -1.0),
                ),
                //
                Pair(
                    MutableRotation(pi12, 0.0, pi12),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    MutableRotation(pi12, pi12, 0.0),
                    MutableVertex(0.0, -1.0, 0.0),
                ),
                Pair(
                    MutableRotation(-pi12, pi12, 0.0),
                    MutableVertex(0.0, 1.0, 0.0),
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
                //
                Pair(
                    MutableRotation(0.0, pi12, pi12),
                    MutableVertex(0.0, 0.0, -1.0),
                ),
                Pair(
                    MutableRotation(0.0, pi12, -pi12),
                    MutableVertex(0.0, 0.0, 1.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (rotation, expected) ->
                matrix.identity()
                matrix.rx(rotation.aX)
                matrix.ry(rotation.aY)
                matrix.rz(rotation.aZ)
                val actual = vertex * matrix
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    r: $rotation
                """.trimIndent()
                assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
            }
        }
    }

    @Test
    fun rxTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        val matrix = MutableMatrix()
        listOf(
            MutableVertex(0.0, 1.0, 0.0) to listOf(
                // 00
                Pair(
                    0.0,
                    MutableVertex(0.0, 1.0, 0.0),
                ),
                // 01
                Pair(
                    pi12,
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    pi22,
                    MutableVertex(0.0, -1.0, 0.0),
                ),
                Pair(
                    pi32,
                    MutableVertex(0.0, 0.0, -1.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians, expected) ->
                matrix.identity()
                matrix.rx(radians = radians)
                val actual = vertex * matrix
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    radians: $radians
                """.trimIndent()
                assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
            }
        }
    }

    @Test
    fun ryTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        val matrix = MutableMatrix()
        listOf(
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                // 00
                Pair(
                    0.0,
                    MutableVertex(1.0, 0.0, 0.0),
                ),
                // 01
                Pair(
                    pi12,
                    MutableVertex(0.0, 0.0, 1.0),
                ),
                Pair(
                    pi22,
                    MutableVertex(-1.0, 0.0, 0.0),
                ),
                Pair(
                    pi32,
                    MutableVertex(0.0, 0.0, -1.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians, expected) ->
                matrix.identity()
                matrix.ry(radians = radians)
                val actual = vertex * matrix
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    radians: $radians
                """.trimIndent()
                assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
            }
        }
    }

    @Test
    fun rzTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        val matrix = MutableMatrix()
        listOf(
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                // 00
                Pair(
                    0.0,
                    MutableVertex(1.0, 0.0, 0.0),
                ),
                // 01
                Pair(
                    pi12,
                    MutableVertex(0.0, 1.0, 0.0),
                ),
                Pair(
                    pi22,
                    MutableVertex(-1.0, 0.0, 0.0),
                ),
                Pair(
                    pi32,
                    MutableVertex(0.0, -1.0, 0.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians, expected) ->
                matrix.identity()
                matrix.rz(radians = radians)
                val actual = vertex * matrix
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    radians: $radians
                """.trimIndent()
                assertEquals(expected = expected, actual = actual, delta = delta, exponent = exponent, message = message)
            }
        }
    }
}
