package sp.kx.calculations.rotations

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.geometry.Rotation
import sp.kx.calculations.geometry.Vertex

internal class VertexRotationsTest {
    @Test
    fun rxTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.X,
            getActual = { vertex: Vertex, radians: Double ->
                rx(vertex = vertex, radians = radians)
            },
        )
    }

    @Test
    fun ryTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Y,
            getActual = { vertex: Vertex, radians: Double ->
                ry(vertex = vertex, radians = radians)
            },
        )
    }

    @Test
    fun rzTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Z,
            getActual = { vertex: Vertex, radians: Double ->
                rz(vertex = vertex, radians = radians)
            },
        )
    }

    @Test
    fun rxyzTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex: Vertex, rotation: Rotation ->
                rxyz(
                    vertex = vertex,
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
            getActual = { vertex: Vertex, rotation: Rotation ->
                rzyx(
                    vertex = vertex,
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
                    vertex = vertex,
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
                    vertex = vertex,
                    rotation = rotation,
                )
            },
        )
    }
}
