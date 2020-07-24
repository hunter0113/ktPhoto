package com.user.ktphoto


import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class CustomDecoration :
    RecyclerView.ItemDecoration() {
    private var borderColor: ColorDrawable? = null
    private val borderOffset = 10

    //設定每一個item的偏移量(間隔)
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val layoutManager = parent.layoutManager as StaggeredGridLayoutManager
        val layoutParams = view.layoutParams as StaggeredGridLayoutManager.LayoutParams

        val spanCount = layoutManager.spanCount
        val spanIndex = layoutParams.spanIndex
        val position = parent.getChildAdapterPosition(view)

        if (spanIndex == 0) {
            // 最左邊留offset
            outRect.left = borderOffset
        }

        if (position < spanCount) {
            // 第一個row，加上Top的Offset
            outRect.top = borderOffset
        }

        outRect.right = borderOffset
        outRect.bottom = borderOffset
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        if ( borderColor == null ){
            borderColor = ColorDrawable(ContextCompat.getColor(parent.context, R.color.design_default_color_background))
        }

        //取得RecyclerView下項目個數
        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)

            //參數
            val params = child.layoutParams as StaggeredGridLayoutManager.LayoutParams
            val spanIndex = params.spanIndex

            val childTop = child.top - params.topMargin
            val childBottom = child.bottom + params.bottomMargin
            val childLeft = child.left
            val childRight = child.right

            //Span= 2，每行有2個，所以spanIndex0為左邊，1為右邊

            if (spanIndex == 0) {
                // 畫左邊垂直的線
                val right = childLeft - params.leftMargin
                val left = right - borderOffset
                val top = childTop
                val bottom = childBottom + borderOffset

                borderColor!!.setBounds(left, top, right, bottom)
                borderColor!!.draw(c)
            }

            // 畫右邊垂直的線
            val left = childRight + params.rightMargin
            val right = left + borderOffset
            val top = childTop
            val bottom = childBottom + borderOffset

            borderColor!!.setBounds(left, top, right, bottom)
            borderColor!!.draw(c)

            // 畫底部的線
            borderColor!!.setBounds(childLeft, childBottom, childRight, childBottom + borderOffset)
            borderColor!!.draw(c)
        }
    }
}