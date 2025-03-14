package sp.kx.calculations.geometry

interface Rotator<T : Any> {
    fun rotate(issuer: T, aX: Double, aY: Double, aZ: Double)
}
