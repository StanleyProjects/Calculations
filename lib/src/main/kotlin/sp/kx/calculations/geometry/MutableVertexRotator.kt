package sp.kx.calculations.geometry

object MutableVertexRotator {
    private fun aa(
        issuer: MutableVertex,
        _x: Double, _y: Double, _z: Double,
        radians: Double,
    ) {
        val c = kotlin.math.cos(radians)
        val s = kotlin.math.sin(radians)
        val m00 = c + (1 - c) * _x * _x;      val m01 = (1 - c) * _x * _y + s * _z; val m02 = (1 - c) * _x * _z + s * _y
        val m10 = (1 - c) * _y * _x + s * _z; val m11 = c + (1 - c) * _y * _y;      val m12 = (1 - c) * _y * _z + s * _x
        val m20 = (1 - c) * _z * _x + s * _y; val m21 = (1 - c) * _z * _y + s * _x; val m22 = c + (1 - c) * _z * _z
        issuer.set(
            x = m00 * issuer.x + m01 * issuer.y + m02 * issuer.z,
            y = m10 * issuer.x + m11 * issuer.y + m12 * issuer.z,
            z = m20 * issuer.x + m21 * issuer.y + m22 * issuer.z,
        )
    }

    private fun rx(issuer: MutableVertex, radians: Double) {
        val c = kotlin.math.cos(radians)
        val s = kotlin.math.sin(radians)
        val x = 1.0
        val y = 0.0
        val z = 0.0
        val m00 = c + (1 - c) * x * x;     val m01 = (1 - c) * x * y + s * z; val m02 = (1 - c) * x * z + s * y
        val m10 = (1 - c) * y * x + s * z; val m11 = c + (1 - c) * y * y;     val m12 = (1 - c) * y * z + s * x
        val m20 = (1 - c) * z * x + s * y; val m21 = (1 - c) * z * y + s * x; val m22 = c + (1 - c) * z * z
        issuer.x = m00 * issuer.x + m01 * issuer.y + m02 * issuer.z
        issuer.y = m10 * issuer.x + m11 * issuer.y + m12 * issuer.z
        issuer.z = m20 * issuer.x + m21 * issuer.y + m22 * issuer.z
    }

    private fun ry(issuer: MutableVertex, radians: Double) {
        val c = kotlin.math.cos(radians)
        val s = kotlin.math.sin(radians)
        val x = 0.0
        val y = 1.0
        val z = 0.0
        val m00 = c + (1 - c) * x * x;     val m01 = (1 - c) * x * y + s * z; val m02 = (1 - c) * x * z + s * y
        val m10 = (1 - c) * y * x + s * z; val m11 = c + (1 - c) * y * y;     val m12 = (1 - c) * y * z + s * x
        val m20 = (1 - c) * z * x + s * y; val m21 = (1 - c) * z * y + s * x; val m22 = c + (1 - c) * z * z
        issuer.x = m00 * issuer.x + m01 * issuer.y + m02 * issuer.z
        issuer.y = m10 * issuer.x + m11 * issuer.y + m12 * issuer.z
        issuer.z = m20 * issuer.x + m21 * issuer.y + m22 * issuer.z
    }

    private fun rz(issuer: MutableVertex, radians: Double) {
        val c = kotlin.math.cos(radians)
        val s = kotlin.math.sin(radians)
        val x = 0.0
        val y = 0.0
        val z = 1.0
        val m00 = c + (1 - c) * x * x;     val m01 = (1 - c) * x * y + s * z; val m02 = (1 - c) * x * z + s * y
        val m10 = (1 - c) * y * x + s * z; val m11 = c + (1 - c) * y * y;     val m12 = (1 - c) * y * z + s * x
        val m20 = (1 - c) * z * x + s * y; val m21 = (1 - c) * z * y + s * x; val m22 = c + (1 - c) * z * z
        issuer.x = m00 * issuer.x + m01 * issuer.y + m02 * issuer.z
        issuer.y = m10 * issuer.x + m11 * issuer.y + m12 * issuer.z
        issuer.z = m20 * issuer.x + m21 * issuer.y + m22 * issuer.z
    }

    val XYZ = object : Rotator<MutableVertex> {
        override fun rotate(issuer: MutableVertex, aX: Double, aY: Double, aZ: Double) {
            val axis = MutableVertex(0.0, 0.0, 0.0)
            axis.x = 1.0
            axis.y = 0.0
            axis.z = 0.0
            aa(issuer, axis.x, axis.y, axis.z, aX)
            axis.x = 0.0
            axis.y = 1.0
            axis.z = 0.0
//            aa(axis, 1.0, 0.0, 0.0, -aX)
            aa(issuer, axis.x, axis.y, axis.z, aY)
            axis.x = 0.0
            axis.y = 0.0
            axis.z = 1.0
//            aa(axis, 0.0, 1.0, 0.0, -aY)
            aa(issuer, axis.x, axis.y, axis.z, aZ)
            //
//            var c = kotlin.math.cos(aZ)
//            var s = kotlin.math.sin(aZ)
//            val y = issuer.x * s + issuer.y * c
//            var x = issuer.x * c - issuer.y * s
//            c = kotlin.math.cos(aY)
//            s = kotlin.math.sin(aY)
//            val z = x * s + issuer.z * c
//            x = x * c - issuer.z * s
//            c = kotlin.math.cos(aX)
//            s = kotlin.math.sin(aX)
//            issuer.x = x
//            issuer.y = y * c - z * s
//            issuer.z = y * s + z * c
            //
//            var c = kotlin.math.cos(aX)
//            var s = kotlin.math.sin(aX)
//            var y = issuer.y * c - issuer.z * s
//            var z = issuer.y * s + issuer.z * c
//            c = kotlin.math.cos(aY)
//            s = kotlin.math.sin(aY)
//            var x = issuer.x * c - z * s
//            z = issuer.x * s + z * c
//            c = kotlin.math.cos(aZ)
//            s = kotlin.math.sin(aZ)
//            issuer.x = x * c - y * s
//            issuer.y = x * s + y * c
//            issuer.z = z
            //
//            rotateX(issuer, aX)
//            rotateY(issuer, aY)
//            rotateZ(issuer, aZ)
        }
    }

    val ZYX = object : Rotator<MutableVertex> {
        override fun rotate(issuer: MutableVertex, aX: Double, aY: Double, aZ: Double) {
            val axis = MutableVertex(0.0, 0.0, 0.0)
            axis.x = 0.0
            axis.y = 0.0
            axis.z = 1.0
            aa(issuer, axis.x, axis.y, axis.z, aZ)
            axis.x = 0.0
            axis.y = 1.0
            axis.z = 0.0
            aa(issuer, axis.x, axis.y, axis.z, aY)
            axis.x = 1.0
            axis.y = 0.0
            axis.z = 0.0
            aa(issuer, axis.x, axis.y, axis.z, aX)
            //
//            var c = kotlin.math.cos(aX)
//            var s = kotlin.math.sin(aX)
//            var y = issuer.y * c - issuer.z * s
//            var z = issuer.y * s + issuer.z * c
//            c = kotlin.math.cos(aY)
//            s = kotlin.math.sin(aY)
//            var x = issuer.x * c - z * s
//            z = issuer.x * s + z * c
//            c = kotlin.math.cos(aZ)
//            s = kotlin.math.sin(aZ)
//            issuer.x = x * c - y * s
//            issuer.y = x * s + y * c
//            issuer.z = z
        }
    }
}
