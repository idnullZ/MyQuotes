package idnull.z.myquotes.presentation.quotes_add_edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import idnull.z.myquotes.data.QuotesDataSourceImpl
import idnull.z.myquotes.domain.QuotesDataSource
import idnull.z.myquotes.utils.logger
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuotesAddViewModel @Inject constructor(
    val repository: QuotesDataSource
) : ViewModel() {


    fun save(value:String){

        viewModelScope.launch {
            repository.insertQuotes(quot = value)
        }
    }


}