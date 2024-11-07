package com.example.mobile_dev.movies

import android.content.res.Resources
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class Decoration(
    private val resources: Resources
): ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)

        if (position % 2 == 0) {
            outRect.left = 16.px()
            outRect.right = 16.px() / 2
        } else {
            outRect.left = 16.px() / 2
            outRect.right = 16.px()
        }

        outRect.bottom = 14.px()

        if (position == 0 || position == 1) {
            outRect.top = 20.px()
        }
    }

    private fun Int.px(): Int {
        val floatPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            resources.displayMetrics
        )

        return floatPx.toInt()
    }
}