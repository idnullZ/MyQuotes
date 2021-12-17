package idnull.z.myquotes.presentation.quotes_list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import idnull.z.myquotes.domain.QuotesDataSource
import idnull.z.myquotes.utils.logger
import mydb.quotesdb.QuotesEntity
import javax.inject.Inject

class QuotesListViewModel @Inject constructor(
     val quotesDataSource: QuotesDataSource
): ViewModel() {

    val f :MutableLiveData<List<QuotesEntity>> = MutableLiveData(listOf<QuotesEntity>(QuotesEntity(id = 1L,"shdbcaklj;'")))






    val quotes = quotesDataSource.getAllQuotes()





}