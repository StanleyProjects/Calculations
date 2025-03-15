package sp.kx.calculations.rotations

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.algebra.MutableMatrix
import sp.kx.calculations.algebra.identity
import sp.kx.calculations.operators.times

internal class MutableMatrixRotationsTest {
    @Test
    fun rxTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.X,
            getActual = { vertex, radians ->
                val matrix = MutableMatrix()
                matrix.identity()
                matrix.rx(radians = radians)
                vertex * matrix
            },
        )
    }

    @Test
    fun ryTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Y,
            getActual = { vertex, radians ->
                val matrix = MutableMatrix()
                matrix.identity()
                matrix.ry(radians = radians)
                vertex * matrix
            },
        )
    }

    @Test
    fun rzTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Z,
            getActual = { vertex, radians ->
                val matrix = MutableMatrix()
                matrix.identity()
                matrix.rz(radians = radians)
                vertex * matrix
            },
        )
    }

    @Test
    fun rxyzTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex, rotation ->
                val matrix = MutableMatrix()
                matrix.identity()
                matrix.rxyz(
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                vertex * matrix
            },
        )
    }

    @Test
    fun rzyxTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.ZYX,
            getActual = { vertex, rotation ->
                val matrix = MutableMatrix()
                matrix.identity()
                matrix.rzyx(
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                vertex * matrix
            },
        )
    }
}
