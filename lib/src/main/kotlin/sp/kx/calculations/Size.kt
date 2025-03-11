package sp.kx.calculations

import sp.kx.calculations.geometry.MutableOffset
import sp.kx.calculations.geometry.Offset

interface Size {
    val width: Double
    val height: Double
}

fun Size.center(dZ: Double): Offset {
    return MutableOffset(
        dX = width / 2,
        dY = height / 2,
        dZ = dZ,
    )
}
