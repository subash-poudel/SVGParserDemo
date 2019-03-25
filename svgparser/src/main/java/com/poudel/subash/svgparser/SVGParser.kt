package com.poudel.subash.svgparser

import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import java.io.StringReader

class SVGParser {

    fun parse(svg: String): ArrayList<SVGPath> {
        val parser = Xml.newPullParser()
        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
        parser.setInput(StringReader(svg))
        return parseXML(parser)
    }

    private fun parseXML(parser: XmlPullParser): ArrayList<SVGPath> {
        val paths = ArrayList<SVGPath>()
        var path: SVGPath?
        var eventType = parser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {
                XmlPullParser.START_TAG -> {
                    if (parser.name.equals("path")) {
                        val strokeWidth = parser.getAttributeValue("", "stroke-width").toFloat()
                        val pathData = parser.getAttributeValue("", "d")
                        path = SVGPath(strokeWidth = strokeWidth, pathData = pathData)
                        paths.add(path)
                    }
                }
            }
            eventType = parser.next()
        }
        return paths
    }

}