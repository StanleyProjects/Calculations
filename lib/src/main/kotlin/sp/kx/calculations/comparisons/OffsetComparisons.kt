package sp.kx.calculations.comparisons

import sp.kx.calculations.geometry.Offset

fun Offset.isEmpty(): Boolean {
    return dX == 0.0 && dY == 0.0 && dZ == 0.0
}

fun Offset.isEmpty(exponent: Int): Boolean {
    return dX.eq(0.0, exponent) && dY.eq(0.0, exponent) && dZ.eq(0.0, exponent)
}
