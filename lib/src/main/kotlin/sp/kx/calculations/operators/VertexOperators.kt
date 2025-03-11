package sp.kx.calculations.operators

import sp.kx.calculations.algebra.Matrix
import sp.kx.calculations.geometry.MutableVertex
import sp.kx.calculations.geometry.Offset
import sp.kx.calculations.geometry.Vertex

operator fun Vertex.times(scale: Double): Vertex {
    return MutableVertex(
        x = x * scale,
        y = y * scale,
        z = z * scale,
    )
}

operator fun Vertex.div(scale: Double): Vertex {
    return MutableVertex(
        x = x / scale,
        y = y / scale,
        z = z / scale,
    )
}

operator fun Vertex.plus(offset: Offset): Vertex {
    return MutableVertex(
        x = x + offset.dX,
        y = y + offset.dY,
        z = z + offset.dZ,
    )
}

operator fun Vertex.times(matrix: Matrix): Vertex {
    return MutableVertex(
        x = matrix.m00 * x + matrix.m01 * y + matrix.m02 * z + matrix.m03,
        y = matrix.m10 * x + matrix.m11 * y + matrix.m12 * z + matrix.m13,
        z = matrix.m20 * x + matrix.m21 * y + matrix.m22 * z + matrix.m23,
    )
}
