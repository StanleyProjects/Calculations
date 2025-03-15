package sp.kx.calculations.rotations

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions

internal class VertexRotationsTest {
    @Test
    fun rxTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.X,
            getActual = { vertex, radians ->
                vertex.rx(radians = radians)
            },
        )
    }

    @Test
    fun ryTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Y,
            getActual = { vertex, radians ->
                vertex.ry(radians = radians)
            },
        )
    }

    @Test
    fun rzTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Z,
            getActual = { vertex, radians ->
                vertex.rz(radians = radians)
            },
        )
    }
}
