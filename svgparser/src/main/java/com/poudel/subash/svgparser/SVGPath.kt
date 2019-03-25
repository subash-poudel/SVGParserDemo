package com.poudel.subash.svgparser

import android.graphics.Path
import android.text.TextUtils

class SVGPath(val strokeWidth: Float, var pathData: String) {

    var pathElementArray = ArrayList<SVGElement>()
    var pathSVGElement: SVGElement? = null
    var numberSegment: String = ""

    init {
        pathData = pathData.trim()
        parsePathData()
    }

    private fun parsePathData() {
        for (c in pathData.toCharArray()) {
            when (c) {
                'M', 'c' -> {
                    resetTempVariables()
                    pathSVGElement = SVGElement(c)
                }
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.' -> {
                    numberSegment = "$numberSegment$c"
                }
                '-' -> {
                    numberSegment = "$c"
                }
                ',' -> {
                    addNumberSegment()
                }
                ' ' -> {
                    addNumberSegment()
                }
                else -> {
                    throw RuntimeException("Not implemented character -> $c")
                }
            }

        }
        resetTempVariables()
    }

    fun getSVGPath(): String {
        val builder = StringBuilder()
        for (element in pathElementArray) {
            builder.append(element.getComputedPath())
        }
        return builder.toString().trim()
    }

    private fun addNumberSegment() {
        if (!TextUtils.isEmpty(numberSegment) && pathSVGElement != null) {
            pathSVGElement!!.points.add(numberSegment.toFloat())
            numberSegment = ""
        }
    }

    private fun resetTempVariables() {
        if (pathSVGElement != null) {
            pathElementArray.add(pathSVGElement!!)
            addNumberSegment()
        }
        numberSegment = ""
    }

    fun appendElementToPath(path: Path) {
        for (element in pathElementArray) {
            element.appendElementToPath(path)
        }
    }
}


