package sp.kx.calculations

import sp.kx.calculations.geometry.MutableOffset
import sp.kx.calculations.geometry.Offset

interface Size {
    val width: Double
    val height: Double
}

fun Size.toOffset(dZ: Double, scale: Double): Offset {
    return MutableOffset(
        dX = width * scale,
        dY = height * scale,
        dZ = dZ,
    )
}
