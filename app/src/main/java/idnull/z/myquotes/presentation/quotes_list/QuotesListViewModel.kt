package idnull.z.myquotes.presentation.quotes_list

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idnull.z.myquotes.data.App
import idnull.z.myquotes.domain.QuotesDataSource
import idnull.z.myquotes.utils.logger
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import mydb.quotesdb.QuotesEntity
import javax.inject.Inject

class QuotesListViewModel @Inject constructor(
    private val quotesDataSource: QuotesDataSource
): ViewModel() {

    private var _listQuotes :MutableLiveData<List<QuotesEntity>> = MutableLiveData()
    val listQuotes: LiveData<List<QuotesEntity>>  get() = _listQuotes


    fun delete(item: QuotesEntity) {

        viewModelScope.launch {

            val id = item.id
            quotesDataSource.deleteQuotesById(id)
        }


    }




    init {

        viewModelScope.launch {
            quotesDataSource.getAllQuotes().collect {
                _listQuotes.value = it
                logger("QuotesListViewModel $it ")

            }
        }



    }







}