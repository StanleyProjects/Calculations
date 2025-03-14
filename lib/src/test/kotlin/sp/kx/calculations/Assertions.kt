package sp.kx.calculations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import sp.kx.calculations.algebra.Matrix
import sp.kx.calculations.comparisons.eq
import sp.kx.calculations.geometry.MutableRotation
import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.geometry.Rotation
import sp.kx.calculations.geometry.Vertex

internal object Assertions {
    private const val _pi12 = kotlin.math.PI / 2
    private const val _pi22 = kotlin.math.PI
    private const val _pi32 = kotlin.math.PI / 2 * 3

    object Rotations {
        object Issues {
            val XYZ: List<Pair<Vertex, List<Pair<Rotation, Vertex>>>> = listOf(
                MutableVertex(1.0, 0.0, 0.0) to listOf(
                    Pair(
                        MutableRotation(0.0, 0.0, 0.0),
                        MutableVertex(1.0, 0.0, 0.0),
                    ), // 00
                    Pair(
                        MutableRotation(0.0, 0.0, _pi12),
                        MutableVertex(0.0, 1.0, 0.0),
                    ), // 01
                    Pair(
                        MutableRotation(0.0, _pi12, 0.0),
                        MutableVertex(0.0, 0.0, 1.0),
                    ), // 02
                    Pair(
                        MutableRotation(0.0, _pi12, _pi12),
                        MutableVertex(0.0, 0.0, 1.0),
                    ), // 03
                    Pair(
                        MutableRotation(_pi12, 0.0, 0.0),
                        MutableVertex(1.0, 0.0, 0.0),
                    ), // 04
                    Pair(
                        MutableRotation(_pi12, 0.0, _pi12),
                        MutableVertex(0.0, 1.0, 0.0),
                    ), // 05
                    Pair(
                        MutableRotation(_pi12, _pi12, 0.0),
                        MutableVertex(0.0, 0.0, 1.0),
                    ), // 06
                    Pair(
                        MutableRotation(_pi12, _pi12, _pi12),
                        MutableVertex(0.0, 0.0, 1.0),
                    ), // 07
                ),
                MutableVertex(0.0, 1.0, 0.0) to listOf(
                    Pair(
                        MutableRotation(0.0, 0.0, 0.0),
                        MutableVertex(0.0, 1.0, 0.0),
                    ), // 00
                    Pair(
                        MutableRotation(0.0, 0.0, _pi12),
                        MutableVertex(1.0, 0.0, 0.0),
                    ), // 01
                    Pair(
                        MutableRotation(0.0, _pi12, 0.0),
                        MutableVertex(0.0, 1.0, 0.0),
                    ), // 02
                    Pair(
                        MutableRotation(0.0, _pi12, _pi12),
                        MutableVertex(1.0, 0.0, 0.0),
                    ), // 03
                    Pair(
                        MutableRotation(_pi12, 0.0, 0.0),
                        MutableVertex(0.0, 0.0, 1.0),
                    ), // 04
                    Pair(
                        MutableRotation(_pi12, 0.0, _pi12),
                        MutableVertex(0.0, 0.0, 1.0),
                    ),
                    Pair(
                        MutableRotation(_pi12, _pi12, 0.0),
                        MutableVertex(1.0, 0.0, 0.0),
                    ),
                    Pair(
                        MutableRotation(_pi12, _pi12, _pi12),
                        MutableVertex(0.0, 1.0, 0.0),
                    ),
                ),
            )
            val ZYX: List<Pair<Vertex, List<Pair<Rotation, Vertex>>>> = listOf(
                MutableVertex(1.0, 0.0, 0.0) to listOf(
                    // 00
                    Pair(
                        MutableRotation(0.0, 0.0, 0.0),
                        MutableVertex(1.0, 0.0, 0.0),
                    ),
                    // 01
                    Pair(
                        MutableRotation(0.0, 0.0, _pi12),
                        MutableVertex(0.0, 1.0, 0.0),
                    ),
                    Pair(
                        MutableRotation(0.0, 0.0, _pi22),
                        MutableVertex(-1.0, 0.0, 0.0),
                    ),
                    Pair(
                        MutableRotation(0.0, 0.0, _pi32),
                        MutableVertex(0.0, -1.0, 0.0),
                    ),
                    // 04
                    Pair(
                        MutableRotation(0.0, _pi12, 0.0),
                        MutableVertex(0.0, 0.0, 1.0),
                    ),
                    Pair(
                        MutableRotation(0.0, _pi22, 0.0),
                        MutableVertex(-1.0, 0.0, 0.0),
                    ),
                    Pair(
                        MutableRotation(0.0, _pi32, 0.0),
                        MutableVertex(0.0, 0.0, -1.0),
                    ),
                    // 05
                    Pair(
                        MutableRotation(_pi12, 0.0, _pi12),
                        MutableVertex(0.0, 0.0, 1.0),
                    ),
                    Pair(
                        MutableRotation(_pi12, _pi12, 0.0),
                        MutableVertex(0.0, -1.0, 0.0),
                    ),
                    Pair(
                        MutableRotation(-_pi12, _pi12, 0.0),
                        MutableVertex(0.0, 1.0, 0.0),
                    ),
                ),
                MutableVertex(0.0, 1.0, 0.0) to listOf(
                    // 00
                    Pair(
                        MutableRotation(0.0, 0.0, 0.0),
                        MutableVertex(0.0, 1.0, 0.0),
                    ),
                ),
            )
        }
    }

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

    @Suppress("ktlint:standard:wrapping")
    fun assertEquals(
        expected: Matrix,
        actual: Matrix,
        delta: Double,
        exponent: Int,
        message: String,
    ) {
        assertEquals(expected.m00, actual.m00, delta, message + "\n00"); assertEquals(expected.m10, actual.m10, delta, message + "\n10"); assertEquals(expected.m20, actual.m20, delta, message + "\n20"); assertEquals(expected.m30, actual.m30, delta, message + "\n30")
        assertEquals(expected.m01, actual.m01, delta, message + "\n01"); assertEquals(expected.m11, actual.m11, delta, message + "\n11"); assertEquals(expected.m21, actual.m21, delta, message + "\n21"); assertEquals(expected.m31, actual.m31, delta, message + "\n31")
        assertEquals(expected.m02, actual.m02, delta, message + "\n02"); assertEquals(expected.m12, actual.m12, delta, message + "\n12"); assertEquals(expected.m22, actual.m22, delta, message + "\n22"); assertEquals(expected.m32, actual.m32, delta, message + "\n32")
        assertEquals(expected.m03, actual.m03, delta, message + "\n03"); assertEquals(expected.m13, actual.m13, delta, message + "\n13"); assertEquals(expected.m23, actual.m23, delta, message + "\n23"); assertEquals(expected.m33, actual.m33, delta, message + "\n33")
        assertTrue(actual.eq(expected, exponent), message)
    }
}
