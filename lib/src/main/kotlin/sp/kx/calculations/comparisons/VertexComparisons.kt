package sp.kx.calculations.comparisons

import sp.kx.calculations.geometry.Vertex

fun Vertex.eq(other: Vertex, exponent: Int): Boolean {
    return x.eq(other.x, exponent) && y.eq(other.y, exponent) && z.eq(other.z, exponent)
}
