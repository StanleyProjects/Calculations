package sp.kx.calculations.geometry

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.Assertions.assertEquals

internal class VertexRotationsTest {
    @Test
    fun rxTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI * 2 - pi12
        val pi42 = kotlin.math.PI * 2
        listOf(
            MutableVertex(0.0, 1.0, 0.0) to listOf(
                Pair(
                    0.0,
                    MutableVertex(0.0, 1.0, 0.0),
                ), // 00
                Pair(
                    pi12,
                    MutableVertex(0.0, 0.0, 1.0),
                ), // 01
                Pair(
                    pi22,
                    MutableVertex(0.0, -1.0, 0.0),
                ), // 02
                Pair(
                    pi32,
                    MutableVertex(0.0, 0.0, -1.0),
                ), // 03
                Pair(
                    pi42,
                    MutableVertex(0.0, 1.0, 0.0),
                ), // 04
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians, expected) ->
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
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI * 2 - pi12
        val pi42 = kotlin.math.PI * 2
        listOf(
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                Pair(
                    0.0,
                    MutableVertex(1.0, 0.0, 0.0),
                ), // 00
                Pair(
                    pi12,
                    MutableVertex(0.0, 0.0, 1.0),
                ), // 01
                Pair(
                    pi22,
                    MutableVertex(-1.0, 0.0, 0.0),
                ), // 02
                Pair(
                    pi32,
                    MutableVertex(0.0, 0.0, -1.0),
                ), // 03
                Pair(
                    pi42,
                    MutableVertex(1.0, 0.0, 0.0),
                ), // 04
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians, expected) ->
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

    @Test
    fun rzTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI * 2 - pi12
        val pi42 = kotlin.math.PI * 2
        listOf(
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                Pair(
                    0.0,
                    MutableVertex(1.0, 0.0, 0.0),
                ), // 00
                Pair(
                    pi12,
                    MutableVertex(0.0, 1.0, 0.0),
                ), // 01
                Pair(
                    pi22,
                    MutableVertex(-1.0, 0.0, 0.0),
                ), // 02
                Pair(
                    pi32,
                    MutableVertex(0.0, -1.0, 0.0),
                ), // 03
                Pair(
                    pi42,
                    MutableVertex(1.0, 0.0, 0.0),
                ), // 04
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (radians, expected) ->
                val actual = rz(
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
    fun rxyzTest() {
        val delta = 0.00000001
        val exponent = 8
        Assertions.Rotations.Issues.XYZ.forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (rotation, expected) ->
                //
                val vx = rx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = rotation.aX,
                )
                val vy = ry(
                    x = vx.x,
                    y = vx.y,
                    z = vx.z,
                    radians = rotation.aY,
                )
                val actual = rz(
                    x = vy.x,
                    y = vy.y,
                    z = vy.z,
                    radians = rotation.aZ,
                )
                //
//                val vz = rz(
//                    x = vertex.x,
//                    y = vertex.y,
//                    z = vertex.z,
//                    radians = rotation.aZ,
//                )
//                val vy = ry(
//                    x = vz.x,
//                    y = vz.y,
//                    z = vz.z,
//                    radians = rotation.aY,
//                )
//                val actual = rx(
//                    x = vy.x,
//                    y = vy.y,
//                    z = vy.z,
//                    radians = rotation.aX,
//                )
                //
                val message = """
                    $i/$j
                    v: $vertex
                    r: $rotation
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
    fun rotateTest() {
        val delta = 0.00000001
        val exponent = 8
        Assertions.Rotations.Issues.ZYX.forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, (rotation, expected) ->
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
                    v: $vertex
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

    @Test
    fun rotateAboutTest() {
        val delta = 0.00000001
        val exponent = 8
        val pi12 = kotlin.math.PI / 2
        val pi22 = kotlin.math.PI
        val pi32 = kotlin.math.PI / 2 * 3
        listOf(
            MutableVertex(0.0, 0.0, 0.0) to listOf(
                Triple(
                    MutableRotation(0.0, 0.0, 0.0),
                    MutableVertex(0.0, 0.0, 0.0),
                    MutableVertex(0.0, 0.0, 0.0),
                ),
            ),
            MutableVertex(1.0, 0.0, 0.0) to listOf(
                Triple(
                    MutableRotation(0.0, 0.0, 0.0),
                    MutableVertex(0.0, 0.0, 0.0),
                    MutableVertex(1.0, 0.0, 0.0),
                ),
            ),
            MutableVertex(2.0, 0.0, 0.0) to listOf(
                Triple(
                    MutableRotation(0.0, 0.0, pi12),
                    MutableVertex(1.0, 0.0, 0.0),
                    MutableVertex(1.0, 1.0, 0.0),
                ),
                Triple(
                    MutableRotation(0.0, 0.0, pi22),
                    MutableVertex(1.0, 0.0, 0.0),
                    MutableVertex(0.0, 0.0, 0.0),
                ),
                Triple(
                    MutableRotation(0.0, 0.0, pi32),
                    MutableVertex(1.0, 0.0, 0.0),
                    MutableVertex(1.0, -1.0, 0.0),
                ),
            ),
            MutableVertex(5.0, 0.0, 0.0) to listOf(
                Triple(
                    MutableRotation(0.0, 0.0, pi12),
                    MutableVertex(3.0, 0.0, 0.0),
                    MutableVertex(3.0, 2.0, 0.0),
                ),
                Triple(
                    MutableRotation(0.0, 0.0, pi22),
                    MutableVertex(3.0, 0.0, 0.0),
                    MutableVertex(1.0, 0.0, 0.0),
                ),
                Triple(
                    MutableRotation(0.0, 0.0, pi32),
                    MutableVertex(3.0, 0.0, 0.0),
                    MutableVertex(3.0, -2.0, 0.0),
                ),
                //
                Triple(
                    MutableRotation(0.0, pi12, 0.0),
                    MutableVertex(3.0, 0.0, 0.0),
                    MutableVertex(3.0, 0.0, 2.0),
                ),
                Triple(
                    MutableRotation(0.0, pi22, 0.0),
                    MutableVertex(3.0, 0.0, 0.0),
                    MutableVertex(1.0, 0.0, 0.0),
                ),
                Triple(
                    MutableRotation(0.0, pi32, 0.0),
                    MutableVertex(3.0, 0.0, 0.0),
                    MutableVertex(3.0, 0.0, -2.0),
                ),
            ),
            MutableVertex(0.0, 5.0, 0.0) to listOf(
                Triple(
                    MutableRotation(pi12, 0.0, 0.0),
                    MutableVertex(0.0, 3.0, 0.0),
                    MutableVertex(0.0, 3.0, 2.0),
                ),
                Triple(
                    MutableRotation(pi22, 0.0, 0.0),
                    MutableVertex(0.0, 3.0, 0.0),
                    MutableVertex(0.0, 1.0, 0.0),
                ),
                Triple(
                    MutableRotation(pi32, 0.0, 0.0),
                    MutableVertex(0.0, 3.0, 0.0),
                    MutableVertex(0.0, 3.0, -2.0),
                ),
            ),
        ).forEachIndexed { i, (vertex, issues) ->
            issues.forEachIndexed { j, issue ->
                val (rotation, about, expected) = issue
                val actual = rotate(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                    rX = about.x,
                    rY = about.y,
                    rZ = about.z,
                )
                val message = """
                    $i/$j
                    v: $vertex
                    e: $expected
                    a: $actual
                    r: $rotation
                    about: $about
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
