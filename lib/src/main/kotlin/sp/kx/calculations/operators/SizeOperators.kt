package sp.kx.calculations.operators

import sp.kx.calculations.MutableSize
import sp.kx.calculations.Size
import sp.kx.calculations.geometry.MutableOffset
import sp.kx.calculations.geometry.Offset

operator fun Size.times(scale: Double): Size {
    return MutableSize(
        width = width * scale,
        height = height * scale,
    )
}

operator fun Size.div(scale: Double): Size {
    return MutableSize(
        width = width / scale,
        height = height / scale,
    )
}

fun Size.center(dZ: Double): Offset {
    return MutableOffset(
        dX = width / 2,
        dY = height / 2,
        dZ = dZ,
    )
}
