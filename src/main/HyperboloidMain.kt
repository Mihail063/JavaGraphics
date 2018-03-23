package main

import main.shape.Hyperboloid
import main.shape.Point
import main.shape.Sphere
import main.shape.Triangle
import main.utils.ImageUtils
import main.utils.OrtoManager
import main.utils.Parser
import main.utils.Plotter
import main.utils.vectors.E
import main.utils.vectors.R0
import main.utils.vectors.RP0
import java.awt.Color

import java.awt.image.BufferedImage
import java.util.*
import kotlin.math.sqrt

object HyperboloidMain {
    internal var x0: Double = 0.0
    internal var y0: Double = 0.0
    internal var z0: Double = 0.0
    internal var ex: Double = 1.0
    internal var ey: Double = 1.0
    internal var ez: Double = 0.0
    internal var rpx0: Double = 3.0
    internal var rpy0: Double = 4.0
    internal var rpz0: Double = .0
    internal var a: Double = 4.0
    internal var b: Double = 2.0
    internal var c: Double = 1.0
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
            val hype = Hyperboloid(RP0(rpx0,rpy0,rpz0),a,b,c)
            val ray = R0(x0,y0,z0)
            val e = E(ex,ey,ez)
            printCoords(true)
            plotRayXHyperboloidReflection(hype, Color.WHITE,ray, e, Color.RED)
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
//        val absN = sqrt(nx * nx + ny * ny + nz * nz)
//        val absE = sqrt(ex * ex + ey * ey + ez * ez)
//        R0 = doubleArrayOf(x0, y0, z0)
//        E = doubleArrayOf(ex / absE, ey / absE, ez / absE)
//        RP0 = doubleArrayOf(rpx0, rpy0, rpz0)
//        N = doubleArrayOf(nx / absN, ny / absN, nz / absN)
    }
}
