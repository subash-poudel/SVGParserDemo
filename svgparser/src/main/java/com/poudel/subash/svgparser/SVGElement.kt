package com.poudel.subash.svgparser

import android.graphics.Path

open class SVGElement(var svgCommand: Char) {

    val points = ArrayList<Float>()

    fun getComputedPath(): String {
        val builder = StringBuilder()
        builder.append(svgCommand)
        for ((index, point) in points.withIndex()) {
            builder.append(point)
            if (points.size > 0 && index + 1 != points.size) {
                if (index % 2 == 0) {
                    builder.append(',')
                } else {
                    builder.append(' ')
                }
            }
        }
        return builder.toString().trim()
    }

    fun appendElementToPath(path: Path) {
        when (svgCommand) {
            'M' -> {
                path.moveTo(points[0], points[1])
            }
            'c' -> {
                if (points.size % 6 != 0) {
                    throw Throwable("Invalid points")
                }
                for (i in 0..((points.size / 6) - 1)) {
                    val x1 = points[i * 6 + 0]
                    val y1 = points[i * 6 + 1]
                    val x2 = points[i * 6 + 2]
                    val y2 = points[i * 6 + 3]
                    val x3 = points[i * 6 + 4]
                    val y3 = points[i * 6 + 5]
                    path.rCubicTo(x1, y1, x2, y2, x3, y3)
                }
            }
            else -> {
                throw Throwable("Weird svg command $svgCommand not handled")
            }
        }
    }
}