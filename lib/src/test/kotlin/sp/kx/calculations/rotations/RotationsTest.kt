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

    @Test
    fun rxAboutTest() {
        Assertions.Rotations.Issues.test1About(
            issues = Assertions.Rotations.Issues.XAbout,
            getActual = { vertex: Vertex, radians: Double, about: Vertex ->
                rx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                    rY = about.y,
                    rZ = about.z,
                )
            },
        )
    }

    @Test
    fun ryAboutTest() {
        Assertions.Rotations.Issues.test1About(
            issues = Assertions.Rotations.Issues.YAbout,
            getActual = { vertex: Vertex, radians: Double, about: Vertex ->
                ry(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                    rX = about.x,
                    rZ = about.z,
                )
            },
        )
    }

    @Test
    fun rzAboutTest() {
        Assertions.Rotations.Issues.test1About(
            issues = Assertions.Rotations.Issues.ZAbout,
            getActual = { vertex: Vertex, radians: Double, about: Vertex ->
                rz(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    radians = radians,
                    rX = about.x,
                    rY = about.y,
                )
            },
        )
    }

    @Test
    fun rxyzAboutTest() {
        Assertions.Rotations.Issues.test3About(
            issues = Assertions.Rotations.Issues.XYZAbout,
            getActual = { vertex: Vertex, rotation: Rotation, about: Vertex ->
                rxyz(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                    rX = about.x,
                    rY = about.y,
                    rZ = about.z,
                )
            },
        )
    }

    @Test
    fun rzyxAboutTest() {
        Assertions.Rotations.Issues.test3About(
            issues = Assertions.Rotations.Issues.ZYXAbout,
            getActual = { vertex: Vertex, rotation: Rotation, about: Vertex ->
                rzyx(
                    x = vertex.x,
                    y = vertex.y,
                    z = vertex.z,
                    aX = rotation.aX,
                    aY = rotation.aY,
                    aZ = rotation.aZ,
                    rX = about.x,
                    rY = about.y,
                    rZ = about.z,
                )
            },
        )
    }
}
