package com.axiasoft.android.zerocoins.ui.features.available_books.domain.models.data.order_book.response

import com.axiasoft.android.zerocoins.ui.features.available_books.domain.models.data.order_book.response.Ask
import com.axiasoft.android.zerocoins.ui.features.available_books.domain.models.data.order_book.response.Bids
import com.google.gson.annotations.SerializedName

data class ListOrderBookResponse (
    @SerializedName("asks"  ) var asks          : ArrayList<Ask>? = null,
    @SerializedName("bids"  ) var bids          : ArrayList<Bids>? = null
)