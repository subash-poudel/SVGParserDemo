package com.poudel.subash.svgparserdemo

import android.graphics.RectF
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.poudel.subash.svgparser.SVGHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var svg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.2\" baseProfile=\"tiny\" height=\"849\" width=\"2052\">\n" +
            "    <g stroke-linejoin=\"round\" stroke-linecap=\"round\" fill=\"none\" stroke=\"black\">\n" +
            "        <path stroke-width=\"16\" d=\"M532,142c0,0 0,0 0,0 \" />\n" +
            "        <path stroke-width=\"18\" d=\"M532,142c0,-1 0,-1 0,-1 \" />\n" +
            "        <path stroke-width=\"17\" d=\"M532,141c-1,0 -1,0 -2,0 \" />\n" +
            "        <path stroke-width=\"16\" d=\"M530,141c-2,-1 -2,0 -4,0 \" />\n" +
            "        <path stroke-width=\"11\" d=\"M526,141c-12,0 -12,0 -24,0 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M502,141c-18,-1 -18,-2 -35,-3 -20,0 -20,-1 -40,-1 -26,0 -26,0 -51,2 -31,2 -31,2 -61,7 -29,5 -30,4 -58,13 -23,7 -24,7 -43,18 -12,7 -17,8 -20,19 -3,9 -1,13 6,21 15,18 18,16 37,30 30,21 31,20 62,40 36,24 38,22 72,49 30,25 33,24 57,54 19,24 22,26 28,54 6,23 5,27 -4,49 -10,26 -14,27 -34,47 -24,24 -25,23 -54,42 -28,19 -28,19 -59,33 -26,11 -27,14 -53,15 -22,1 -27,2 -43,-11 -16,-14 -18,-20 -21,-42 -6,-33 -3,-35 3,-69 9,-49 11,-49 27,-96 18,-55 19,-55 41,-109 19,-47 19,-47 39,-93 12,-28 13,-28 25,-56 4,-9 6,-14 9,-18 \" />\n" +
            "        <path stroke-width=\"10\" d=\"M332,136c1,-1 1,5 0,9 -5,23 -8,22 -14,46 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M318,191c-10,42 -11,42 -18,84 -7,50 -7,50 -10,100 -3,50 -3,51 -1,101 1,43 3,43 7,86 4,36 4,36 10,71 5,27 4,27 12,54 7,19 7,20 17,36 9,13 9,14 21,23 9,7 11,5 21,9 \" />\n" +
            "        <path stroke-width=\"12\" d=\"M537,496c0,0 0,0 0,0 \" />\n" +
            "        <path stroke-width=\"16\" d=\"M537,496c0,-2 0,-4 0,-3 \" />\n" +
            "        <path stroke-width=\"14\" d=\"M537,493c1,8 1,10 3,20 \" />\n" +
            "        <path stroke-width=\"10\" d=\"M540,513c3,17 2,18 6,35 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M546,548c5,23 5,23 11,47 5,23 5,24 11,47 5,20 4,20 10,39 3,9 3,11 8,17 \" />\n" +
            "        <path stroke-width=\"10\" d=\"M586,698c2,3 5,5 8,3 \" />\n" +
            "        <path stroke-width=\"11\" d=\"M594,701c4,-3 4,-6 6,-12 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M600,689c4,-19 4,-19 6,-38 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M606,651c4,-35 2,-35 5,-70 3,-30 3,-30 6,-60 3,-21 3,-21 5,-41 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M622,480c1,-6 1,-9 3,-12 \" />\n" +
            "        <path stroke-width=\"12\" d=\"M625,468c0,-1 1,2 1,3 \" />\n" +
            "        <path stroke-width=\"11\" d=\"M626,471c0,17 -2,17 -1,34 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M625,505c0,24 0,24 2,48 2,22 1,23 6,44 3,16 2,18 10,32 6,10 8,14 18,16 12,2 14,-1 26,-7 16,-8 17,-9 28,-22 17,-18 16,-20 28,-41 14,-23 14,-23 24,-48 11,-26 11,-27 17,-54 6,-24 7,-25 8,-49 1,-20 2,-21 -3,-39 -4,-15 -5,-16 -15,-28 -7,-9 -8,-9 -19,-14 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M755,343c-7,-2 -11,-4 -15,0 -6,4 -6,8 -5,17 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M735,360c1,22 3,23 10,45 9,31 9,31 21,60 11,27 10,28 25,53 13,20 14,20 31,36 12,12 13,13 27,19 13,5 14,6 27,4 11,-1 13,-2 21,-9 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M897,568c5,-4 8,-10 6,-13 -3,-4 -8,-4 -16,-3 -16,3 -17,4 -32,10 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M855,562c-26,12 -25,13 -50,26 -24,13 -24,12 -48,25 -16,10 -16,16 -32,22 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M725,635c-6,2 -11,-1 -13,-6 -3,-9 -1,-12 2,-23 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M714,606c6,-21 5,-23 18,-40 15,-22 16,-22 37,-39 24,-18 24,-23 51,-30 26,-7 30,-7 56,1 31,9 31,13 56,34 25,19 24,21 44,45 16,20 14,22 29,43 8,9 9,8 17,18 \" />\n" +
            "        <path stroke-width=\"11\" d=\"M1022,638c1,1 2,3 1,2 -3,-6 -5,-7 -8,-16 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M1015,624c-8,-23 -8,-23 -13,-46 -6,-30 -5,-30 -10,-60 -4,-29 -3,-29 -8,-58 -4,-21 0,-23 -8,-42 -4,-10 -6,-13 -16,-17 -13,-5 -16,-4 -29,0 -17,5 -18,7 -32,18 -15,13 -19,13 -25,31 -8,19 -9,22 -4,43 6,26 10,26 24,49 14,21 13,23 32,38 20,15 22,17 46,21 25,4 28,2 53,-4 28,-8 29,-9 54,-24 25,-16 25,-18 46,-39 18,-18 18,-19 32,-39 3,-6 6,-14 3,-14 -6,2 -14,7 -23,18 -21,26 -21,26 -37,55 -21,38 -20,38 -36,78 -14,34 -12,35 -24,70 -7,21 -5,23 -15,42 -3,7 -8,12 -11,11 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M1014,755c-3,-1 -1,-7 -1,-13 2,-27 2,-27 5,-54 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M1018,688c5,-48 4,-48 12,-95 8,-55 7,-55 19,-110 10,-49 8,-50 26,-97 11,-29 11,-33 32,-53 9,-9 18,-14 28,-6 21,16 21,25 34,53 19,40 17,42 29,84 10,35 8,36 16,72 5,19 6,19 10,38 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M1224,574c1,7 0,13 2,14 \" />\n" +
            "        <path stroke-width=\"10\" d=\"M1226,588c1,1 4,-5 5,-11 \" />\n" +
            "        <path stroke-width=\"9\" d=\"M1231,577c6,-24 5,-24 9,-50 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M1240,527c7,-38 4,-38 12,-76 8,-38 6,-39 21,-75 8,-20 9,-28 25,-36 12,-6 21,-3 33,8 23,22 18,29 36,59 21,37 20,37 42,74 18,32 16,35 38,63 14,17 15,20 34,28 13,6 16,6 30,1 18,-7 20,-10 34,-25 24,-24 22,-26 42,-53 26,-37 23,-39 50,-75 27,-34 26,-37 59,-64 25,-21 28,-21 59,-31 28,-8 30,-7 59,-6 30,2 31,3 60,14 29,11 28,15 56,30 24,14 24,14 48,28 19,10 19,10 38,21 \" />\n" +
            "        <path stroke-width=\"10\" d=\"M451,816c0,0 0,0 0,0 \" />\n" +
            "        <path stroke-width=\"14\" d=\"M451,816c1,-1 0,-1 1,-1 \" />\n" +
            "        <path stroke-width=\"15\" d=\"M452,815c2,-2 2,-2 5,-3 \" />\n" +
            "        <path stroke-width=\"13\" d=\"M457,812c4,-1 4,-1 9,-2 \" />\n" +
            "        <path stroke-width=\"10\" d=\"M466,810c34,-6 34,-7 68,-11 \" />\n" +
            "        <path stroke-width=\"8\" d=\"M534,799c34,-5 34,-5 68,-9 41,-5 41,-5 82,-10 47,-6 47,-6 95,-11 51,-6 52,-6 103,-12 55,-7 55,-7 109,-14 56,-7 56,-7 112,-14 55,-7 55,-5 110,-13 54,-8 54,-10 108,-19 50,-8 50,-9 100,-16 45,-7 45,-6 91,-12 39,-4 39,-4 79,-9 34,-3 34,-4 67,-7 27,-3 27,-3 54,-5 18,-2 18,-3 37,-5 6,-1 6,-1 13,-1 \" />\n" +
            "    </g>\n" +
            "</svg>"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_start.setOnClickListener({
            val rect = RectF(10f, 10f, 100f, 100f)
            val bitmap = SVGHelper.getBitmap(this, svg, rect)
            img_view.setImageBitmap(bitmap)
        })
    }
}
