package sp.kx.calculations.operators

import sp.kx.calculations.algebra.Matrix
import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.geometry.Vertex

operator fun Vertex.times(matrix: Matrix): Vertex {
    return MutableVertex(
        x = matrix.m00 * x + matrix.m01 * y + matrix.m02 * z + matrix.m03,
        y = matrix.m10 * x + matrix.m11 * y + matrix.m12 * z + matrix.m13,
        z = matrix.m20 * x + matrix.m21 * y + matrix.m22 * z + matrix.m23,
    )
}
