package com.example.mobile_dev.cookies

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import com.example.mobile_dev.cookies.shopItemList as baseShopItemList

data class State(
    val count: Long = 0,
    val cookiesPerSecond: Int = 1,
    val time: Int = 0,
    val avgSpeed: Int = 0,
    val shopItemList: List<ShopItem> = baseShopItemList,
    val isStatsSelected: Boolean = true
)

sealed interface Event {
    data object NotEnoughCookies : Event
    data object CookieMessage : Event
}

class CookiesViewModel: ViewModel() {
    val state = MutableStateFlow(State())
    val event = MutableSharedFlow<Event>()
    private val level = 0
    private val levelCount = 2000

    fun onChange() {
        val newCount = state.value.count + state.value.cookiesPerSecond
        state.update { it.copy(
            count = newCount,
            time = it.time + 1,
            shopItemList = getShopItemList(newCount)
        )}
    }

    fun onShopItemClick(shopItem: ShopItem) {
        viewModelScope.launch {
            if (state.value.count < shopItem.price) {
                event.emit(Event.NotEnoughCookies)
                return@launch
            }

            state.update { prev ->
                prev.copy(
                    count = prev.count - shopItem.price,
                    cookiesPerSecond = (prev.cookiesPerSecond + shopItem.speed).toInt(),
                    shopItemList = prev.shopItemList.map {
                        if (it.resId == shopItem.resId) {
                            it.copy(
                                count = it.count + 1,
                                price = (it.price * 1.15).toLong(),
                            )
                        }
                        else {
                            it
                        }
                    }
                )
            }
        }
    }

    private fun getShopItemList(count: Long): List<ShopItem> {
        return state.value.shopItemList.map {
            it.copy(disabled = count < it.price )
        }
    }

    fun onCookieClick() {
        state.update { it.copy(
            count = it.count + 1
        ) }
    }

    fun onMenuItemReselected(item: MenuItem) {
        state.update { it.copy(
            isStatsSelected = item.itemId == 2131231224
        ) }
    }
}

