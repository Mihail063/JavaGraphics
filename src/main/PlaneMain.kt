package main

import main.rendering.Luminosity
import main.shape.Point
import main.shape.Sphere
import main.shape.Triangle
import main.utils.ImageUtils
import main.utils.OrtoManager
import main.utils.Parser
import main.utils.Plotter
import java.awt.Color

import java.awt.image.BufferedImage
import java.util.*
import kotlin.math.sqrt

object PlaneMain {
    internal var x0: Double = 0.toDouble()
    internal var y0: Double = 0.toDouble()
    internal var z0: Double = 0.toDouble()
    internal var ex: Double = 0.toDouble()
    internal var ey: Double = 0.toDouble()
    internal var ez: Double = 0.toDouble()
    internal var rpx0: Double = 0.toDouble()
    internal var rpy0: Double = 0.toDouble()
    internal var rpz0: Double = 0.toDouble()
    internal var nx: Double = 0.toDouble()
    internal var ny: Double = 0.toDouble()
    internal var nz: Double = 0.toDouble()
    internal lateinit var R0: DoubleArray//ray
    internal lateinit var E: DoubleArray//rayDirection
    internal lateinit var RP0: DoubleArray//plane
    internal lateinit var N: DoubleArray//normal
    internal var width = 1000
    internal var height = 1000
    internal var image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)

    @JvmStatic
    fun main(args: Array<String>) {
        for (i in 0 until image.height - 1) {
            for (j in 0 until image.width - 1) {
                image.setRGB(j, i, Color.BLACK.rgb)
            }
        }
        val ortoManager = OrtoManager(-10.0, 10.0, -10.0, 10.0, image)
        val plotter = Plotter(ortoManager, image)
        plotter.apply {
            printCoords()
            plotRay(Point(0.0,0.0,0.0), Point(3.0,1.0,0.0),Color.RED)
            plotSphere(Sphere(Point(3.0,3.5,0.0),4.5), Color.WHITE)
        }
        ImageUtils.saveImage(image)
    }


    private fun initFromInput() {
        println("Параметры луча:")
        val scanner = Scanner(System.`in`)
        println("Координата начала луча по x:")
        x0 = scanner.nextDouble()
        println("Координата начала луча по y:")
        y0 = scanner.nextDouble()
        println("Координата начала луча по z:")
        z0 = scanner.nextDouble()
        println("Координата направления луча по x:")
        ex = scanner.nextDouble()
        println("Координата направления луча по y:")
        ey = scanner.nextDouble()
        println("Координата направления луча по z:")
        ez = scanner.nextDouble()
        println("Параметры плоскости:")
        println("Координата точки плоскости по x:")
        rpx0 = scanner.nextDouble()
        println("Координата точки плоскости по y:")
        rpy0 = scanner.nextDouble()
        println("Координата точки плоскости по z:")
        rpz0 = scanner.nextDouble()
        println("Координата нормали по x:")
        nx = scanner.nextDouble()
        println("Координата нормали по y:")
        ny = scanner.nextDouble()
        println("Координата нормали по z:")
        nz = scanner.nextDouble()
        val absN = sqrt(nx * nx + ny * ny + nz * nz)
        val absE = sqrt(ex * ex + ey * ey + ez * ez)
        R0 = doubleArrayOf(x0, y0, z0)
        E = doubleArrayOf(ex / absE, ey / absE, ez / absE)
        RP0 = doubleArrayOf(rpx0, rpy0, rpz0)
        N = doubleArrayOf(nx / absN, ny / absN, nz / absN)
    }
}
