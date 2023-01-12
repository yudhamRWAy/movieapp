package com.yudha.techtest.ui.views.genrelist


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yudha.techtest.R
import kotlinx.android.synthetic.main.genre_item.view.*

class GenreAdapter(
    private val listItem: ArrayList<com.yudha.techtest.data.model.Genre>,
    private val listener: (com.yudha.techtest.data.model.Genre) -> Unit
) : RecyclerView.Adapter<GenreAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = listItem.size

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(listItem[position], listener)
    }

    inner class ItemViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindItem(
            data: com.yudha.techtest.data.model.Genre,
            listener: (com.yudha.techtest.data.model.Genre) -> Unit
        ) {
            itemView.tv_genre.text = data.name
            itemView.setOnClickListener {
                listener(data)
            }
        }
    }

    fun setData(data: List<com.yudha.techtest.data.model.Genre>) {
        listItem.clear()
        listItem.addAll(data)
        notifyDataSetChanged()
    }
}

