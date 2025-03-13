package sp.kx.calculations

interface Cell {
    val x: Int
    val y: Int
}

fun Cell.copy(
    x: Int = this.x,
    y: Int = this.y,
): Cell {
    return MutableCell(
        x = x,
        y = y,
    )
}
