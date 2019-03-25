package com.poudel.subash.svgparserdemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

open class SVGView : View {

    public var path: Path? = null
        set(value) {
            field = value
            invalidate()
        }

    val paint: Paint

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        init(context)
    }

    private fun init(context: Context) {
        paint.strokeWidth = 12f
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeJoin = Paint.Join.ROUND
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (path != null) {
            canvas?.drawPath(path, paint)
        }
    }


}