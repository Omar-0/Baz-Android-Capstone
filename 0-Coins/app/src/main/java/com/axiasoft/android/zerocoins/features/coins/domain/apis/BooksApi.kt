package com.axiasoft.android.zerocoins.features.coins.domain.apis

import com.axiasoft.android.zerocoins.features.coins.domain.models.data.book.response.Book
import com.axiasoft.android.zerocoins.features.coins.domain.models.data.ticker.response.Ticker
import com.axiasoft.android.zerocoins.network.apis.CoinApis
import com.axiasoft.android.zerocoins.network.bitso.BitsoApiPaths
import com.axiasoft.android.zerocoins.network.bitso.models.BitsoBaseResponse
import com.axiasoft.android.zerocoins.network.connections.HttpConnectionManager
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {

    @GET(BitsoApiPaths.BOOKS)
    suspend fun getBooksFromApi(): BitsoBaseResponse<ArrayList<Book>>

    @GET(BitsoApiPaths.TICKETS)
    suspend fun getTicketsApi(@Query("book") book: String, ): BitsoBaseResponse<Ticker>


    class Builder : HttpConnectionManager<BooksApi>(CoinApis.BITSO) {
        override fun build(): BooksApi {
            return httpClient.create(BooksApi::class.java)
        }
    }
}