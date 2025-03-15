package sp.kx.calculations.rotations

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.geometry.Rotation
import sp.kx.calculations.geometry.Vertex

internal class RotationsTest {
    @Test
    fun rxTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.X,
            getActual = { vertex, radians ->
                rx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                )
            },
        )
    }

    @Test
    fun ryTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Y,
            getActual = { vertex, radians ->
                ry(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                )
            },
        )
    }

    @Test
    fun rzTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Z,
            getActual = { vertex, radians ->
                rz(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                )
            },
        )
    }

    @Test
    fun rxyzTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex, rotation ->
                rxyz(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
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
                rzyx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
            },
        )
    }

    @Test
    fun rxyzRotationTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex: Vertex, rotation: Rotation ->
                rxyz(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    rotation = rotation,
                )
            },
        )
    }

    @Test
    fun rzyxRotationTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.ZYX,
            getActual = { vertex: Vertex, rotation: Rotation ->
                rzyx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    rotation = rotation,
                )
            },
        )
    }
}
