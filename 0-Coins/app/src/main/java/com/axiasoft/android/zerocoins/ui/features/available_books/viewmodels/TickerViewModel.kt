package com.axiasoft.android.zerocoins.ui.features.available_books.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axiasoft.android.zerocoins.ui.features.available_books.domain.models.data.exchange_order_book.ExchangeOrderBook
import com.axiasoft.android.zerocoins.ui.features.available_books.domain.repositories.order_book.BooksRepositoryImpl
import com.axiasoft.android.zerocoins.ui.features.available_books.domain.use_cases.GetListOrderBookUseCase
import com.axiasoft.android.zerocoins.ui.features.available_books.domain.use_cases.GetTickerUseCase
import com.axiasoft.android.zerocoins.ui.features.available_books.views.ui_states.ListOrderBookScreenState
import com.axiasoft.android.zerocoins.ui.features.available_books.views.ui_states.TickerScreenState
import kotlinx.coroutines.launch

class TickerViewModel: ViewModel() {

    private val booksRepository by lazy { BooksRepositoryImpl() }

    var selectedBookOrder = ExchangeOrderBook()

    var tickerState: MutableLiveData<TickerScreenState> = MutableLiveData()

    var listOrderBookScreenState: MutableLiveData<ListOrderBookScreenState> = MutableLiveData()

    fun getTickerWithUseCase(){
        viewModelScope.launch {
            val tickerSreenState = GetTickerUseCase(booksRepository).invoke(selectedBookOrder)
            when(tickerSreenState){
                is TickerScreenState.TickerSuccess -> {
                    val ticker = tickerSreenState.ticker
                    tickerState.value = TickerScreenState.TickerSuccess(ticker)
                }
                is TickerScreenState.TickerError -> {

                }
            }
        }
    }

    fun getListOrderBook(){
        viewModelScope.launch {
            val listOrderBookState = GetListOrderBookUseCase(booksRepository).invoke(selectedBookOrder)
            when(listOrderBookState){
                is ListOrderBookScreenState.Success -> {
                    listOrderBookScreenState.value = listOrderBookState
                }
                is ListOrderBookScreenState.ErrorOrEmpty -> {

                }
            }
        }
    }
}