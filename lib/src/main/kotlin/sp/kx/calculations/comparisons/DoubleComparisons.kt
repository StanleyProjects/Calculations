package sp.kx.calculations.comparisons

fun Double.eq(other: Double, exponent: Int): Boolean {
    val delta = java.lang.Math.pow(10.0, exponent.toDouble())
    return minus(other).times(delta).toLong() == 0L
}
