package com.poudel.subash.svgparser

import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

@RunWith(AndroidJUnit4::class)
class PathDataParserTest {

    fun test_PathData(svgPath: SVGPath) {
        assertEquals(svgPath.pathData, svgPath.getSVGPath())
    }

    @Test fun test_path() {
        val pathData = "M532,142c0,0 0,0 0,0 "
        val svgPath = SVGPath(12f, pathData)
        test_PathData(svgPath)
    }

    @Test
    fun test_svgPaths() {
        val url = this.javaClass.getClassLoader().getResource("svg1.xml")
        val svgStr = getString(url)
        val paths = SVGParser().parse(svgStr)
        for (path in paths) {
            test_PathData(path)
        }
    }

    private fun getString(url: URL): String {
        val builder = StringBuilder()
        try {
            val reader = BufferedReader(InputStreamReader(url.openStream()))
            var line: String?
            line = reader.readLine()
            while (line != null) {
                builder.append(line)
                line = reader.readLine()
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return builder.toString()
    }

}