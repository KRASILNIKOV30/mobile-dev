package com.example.mobile_dev.cookies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile_dev.databinding.CookieShopItemBinding

class ShopItemViewHolder(view: View): RecyclerView.ViewHolder(view)

class ShopItemAdapter(
    private val onItemClick: (ShopItem) -> Unit
): RecyclerView.Adapter<ShopItemViewHolder>() {
    var shopItemList = listOf<ShopItem>()

    override fun getItemCount(): Int = shopItemList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = CookieShopItemBinding.inflate(inflater, parent, false)

        return ShopItemViewHolder(view.root)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val itemBinding = CookieShopItemBinding.bind(holder.itemView)
        val shopItem = shopItemList[position]

        itemBinding.title.text = shopItem.title
        itemBinding.price.text = shopItem.price.toString()
        itemBinding.image.setImageResource(shopItem.resId)

        itemBinding.container.setOnClickListener {
            onItemClick(shopItem)
        }
    }
}