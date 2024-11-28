package com.example.mobile_dev.cookies

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import com.example.mobile_dev.cookies.shopItemList as baseShopItemList

data class State(
    val count: Int = 0,
    val cookiesPerSecond: Int = 1,
    val time: Int = 0,
    val avgSpeed: Int = 0,
    val shopItemList: List<ShopItem> = baseShopItemList
)

sealed interface Event {
    data object NotEnoughCookies : Event
    data object CookieMessage : Event
}

class CookiesViewModel: ViewModel() {
    val state = MutableStateFlow(State())
    val event = MutableSharedFlow<Event>(onBufferOverflow = BufferOverflow.DROP_OLDEST)
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
        if (state.value.count < shopItem.price) {
            event.tryEmit(Event.NotEnoughCookies)
            return
        }

        state.update { prev ->
            prev.copy(
                shopItemList = prev.shopItemList.map {
                    if (it.resId == shopItem.resId) {
                        it.copy(
                            count = it.count + 1
                        )
                    }
                    else {
                        it
                    }
                }
            )
        }
    }

    private fun getShopItemList(count: Int): List<ShopItem> {
        return state.value.shopItemList.map {
            it.copy(disabled = count < it.price )
        }
    }

    fun onCookieClick() {
        state.update { it.copy(
            count = it.count + 1
        ) }
    }
}

