package sp.kx.calculations.physics

import kotlin.time.Duration

interface Speed {
    fun length(duration: Duration): Double
}
