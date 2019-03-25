package com.poudel.subash.svgparser

import android.content.Context
import android.graphics.*
import kotlin.math.min

class SVGHelper {

    companion object {

        fun getBitmap(context: Context, svgStr: String, rect: RectF): Bitmap? {
            val svgParser = SVGParser()
            val paths = svgParser.parse(svgStr)
            val path = Path()
            for (p in paths) {
                p.appendElementToPath(path)
            }
            val pathBounds = RectF()
            path.computeBounds(pathBounds, true)
            val bitmap = Bitmap.createBitmap(rect.width().toInt(), rect.height().toInt(), Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            val scale = calculateScale(rect, pathBounds)
            val matrix = Matrix()
            matrix.setTranslate(-pathBounds.left, -pathBounds.top)
            matrix.setScale(scale, scale)
            path.transform(matrix)
            canvas.drawPath(path, getPaint(context))
            return bitmap
        }

        private fun getPaint(context: Context): Paint {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.strokeWidth = context.resources.getDimension(R.dimen.dimen_1dp)
            paint.style = Paint.Style.STROKE
            paint.color = Color.BLACK
            paint.strokeCap = Paint.Cap.ROUND
            paint.strokeJoin = Paint.Join.ROUND
            return paint
        }

        private fun calculateScale(one: RectF, two: RectF): Float {
            val scaleX = one.width() / two.width()
            val scaleY = one.height() / two.height()
            return min(scaleX, scaleY)
        }

    }

}