package com.user.ktphoto

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(
    var items: List<Photo>,
    private val context: Context
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ITEM = 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is ItemViewHolder) {

            val screenWidth = context.resources.displayMetrics.widthPixels
            val imageWidth = screenWidth / 2
            val imageHeight = (imageWidth / items[position].width * items[position].height).toInt()
            val params = viewHolder.imageView.layoutParams
            params.height = imageHeight
            params.width = imageWidth
            viewHolder.imageView.layoutParams = params
            Glide.with(context).load(items[position].url).into(viewHolder.imageView)

            viewHolder.imageView.setOnClickListener{
                val dialogView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet, null)
                Glide.with(context).load(items[position].url).into(dialogView.headerView)
                dialogView.titletext.text = items[position].title
                dialogView.tv.text = items[position].introduction
                val dialog = BottomSheetDialog(context)
                dialog.setContentView(dialogView)
                dialog.show()
            }
        }

    }

    override fun getItemCount(): Int {
        return items.count()
    }


    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_ITEM
    }


    private inner class ItemViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        //綁畫面元件
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}
