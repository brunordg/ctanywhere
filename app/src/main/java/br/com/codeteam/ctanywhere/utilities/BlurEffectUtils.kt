package br.com.codeteam.ctanywhere.utilities

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur

/**
 * Classe para adicinoar efeito de blur nas imagens
 * Para utilizar seguir o seguinte exemplo:<br/><br/>
 *
 *  Picasso.get()
 *      .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSs1C7ObDV677Sy0A5GJLbPSBycdRPBhD0BcXoyBfgiVa4t1ff_")
 *      .transform(BlurEffectUtils(context, 24))
 *      .into(ImageView)
 */
class BlurEffectUtils(val context: Context, var radius: Int) {

    companion object {
        const val UP_LIMIT = 25
        const val LOW_LIMIT = 1
    }


    fun transform(source: Bitmap): Bitmap {
        val blurredBitmap = Bitmap.createBitmap(source)

        val renderScript = RenderScript.create(context)

        val input = Allocation.createFromBitmap(renderScript, source, Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SCRIPT)

        val output = Allocation.createTyped(renderScript, input.type)

        val script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

        script.setInput(input)
        script.setRadius(radius.toFloat())

        script.forEach(output)
        output.copyTo(blurredBitmap)

        return blurredBitmap
    }

    private fun defineRadius(radius: Int): Int {
        return when {
            radius < LOW_LIMIT -> LOW_LIMIT
            radius > UP_LIMIT -> UP_LIMIT
            else -> radius
        }
    }


}