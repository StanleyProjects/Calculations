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

    @Test
    fun rxyzTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex, rotation ->
                vertex.rxyz(
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
            },
        )
    }

    @Test
    fun rzyxTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.ZYX,
            getActual = { vertex, rotation ->
                vertex.rzyx(
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
            },
        )
    }
}
