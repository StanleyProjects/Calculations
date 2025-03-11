package sp.kx.calculations.operators

import sp.kx.calculations.MutableSize
import sp.kx.calculations.Size

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
