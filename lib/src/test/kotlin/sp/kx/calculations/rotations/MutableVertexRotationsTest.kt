package sp.kx.calculations.rotations

import org.junit.jupiter.api.Test
import sp.kx.calculations.Assertions
import sp.kx.calculations.geometry.Rotation
import sp.kx.calculations.geometry.Vertex
import sp.kx.calculations.geometry.mut

internal class MutableVertexRotationsTest {
    @Test
    fun rxTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.X,
            getActual = { vertex, radians ->
                val actual = vertex.mut()
                actual.rx(radians = radians)
                actual
            },
        )
    }

    @Test
    fun ryTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Y,
            getActual = { vertex, radians ->
                val actual = vertex.mut()
                actual.ry(radians = radians)
                actual
            },
        )
    }

    @Test
    fun rzTest() {
        Assertions.Rotations.Issues.test1(
            issues = Assertions.Rotations.Issues.Z,
            getActual = { vertex, radians ->
                val actual = vertex.mut()
                actual.rz(radians = radians)
                actual
            },
        )
    }

    @Test
    fun rxyzTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex, rotation ->
                val actual = vertex.mut()
                actual.rxyz(
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                actual
            },
        )
    }

    @Test
    fun rzyxTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.ZYX,
            getActual = { vertex, rotation ->
                val actual = vertex.mut()
                actual.rzyx(
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                )
                actual
            },
        )
    }

    @Test
    fun rxyzRotationTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.XYZ,
            getActual = { vertex: Vertex, rotation: Rotation ->
                val actual = vertex.mut()
                actual.rxyz(rotation = rotation)
                actual
            },
        )
    }

    @Test
    fun rzyxRotationTest() {
        Assertions.Rotations.Issues.test3(
            issues = Assertions.Rotations.Issues.ZYX,
            getActual = { vertex: Vertex, rotation: Rotation ->
                val actual = vertex.mut()
                actual.rzyx(rotation = rotation)
                actual
            },
        )
    }

    @Test
    fun rxyzAboutTest() {
        Assertions.Rotations.Issues.test3About(
            issues = Assertions.Rotations.Issues.XYZAbout,
            getActual = { vertex, about, rotation ->
                val actual = vertex.mut()
                actual.rxyz(
                    about = about,
                    rotation = rotation,
                )
                actual
            },
        )
    }

    @Test
    fun rzyxAboutTest() {
        Assertions.Rotations.Issues.test3About(
            issues = Assertions.Rotations.Issues.ZYXAbout,
            getActual = { vertex, about, rotation ->
                val actual = vertex.mut()
                actual.rzyx(
                    about = about,
                    rotation = rotation,
                )
                actual
            },
        )
    }
}
