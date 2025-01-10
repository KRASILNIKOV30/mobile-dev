package com.example.mobile_dev.db

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_dev.databinding.DbListItemBinding

class DbItemViewHolder(view: View): RecyclerView.ViewHolder(view)

class DbItemAdapter(
    private val onItemClick: (DbItem) -> Unit,
    private val onDelete: (DbItem) -> Unit,
): RecyclerView.Adapter<DbItemViewHolder>() {
    var dbItemList = mutableListOf<DbItem>()

    override fun getItemCount(): Int = dbItemList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DbItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DbListItemBinding.inflate(inflater, parent, false)

        return DbItemViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: DbItemViewHolder, position: Int) {
        val itemBinding = DbListItemBinding.bind(holder.itemView)
        val dbItem = dbItemList[position]

        itemBinding.title.text = dbItem.title
        itemBinding.description.text = dbItem.text
        itemBinding.date.text = dbItem.date

        itemBinding.container.setOnClickListener {
            onItemClick(dbItem)
        }

        itemBinding.trash.setOnClickListener {
            onDelete(dbItem)
            dbItemList.removeAt(position)
            notifyDataSetChanged()
        }
    }
}