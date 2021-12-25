package idnull.z.myquotes.presentation.quotes_main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idnull.z.myquotes.domain.QuotesDataSource
import idnull.z.myquotes.domain.Respond
import idnull.z.myquotes.domain.usecase.MainScreenUseCase
import idnull.z.myquotes.utils.logger
import kotlinx.coroutines.launch
import mydb.quotesdb.QuotesEntity
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val useCase: MainScreenUseCase,
    val quotesDataSource: QuotesDataSource
) : ViewModel() {


    private var _quot: MutableLiveData<Respond> = MutableLiveData()
    val quot: LiveData<Respond> get() = _quot


    fun update() {
        viewModelScope.launch {
            val result = useCase.invoke()
            _quot.value = result
        }

    }

    fun save() {

        viewModelScope.launch {
            quot.value?.let { quotesDataSource.insertQuotes(quot = it.text) }
        }

    }

    init {
        update()
    }


}