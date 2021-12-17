package idnull.z.myquotes.domain

import mydb.quotesdb.QuotesEntity
import kotlinx.coroutines.flow.Flow

interface QuotesDataSource {

    suspend fun getQuotesById(id: Long): QuotesEntity?

    fun getAllQuotes(): Flow<List<QuotesEntity>>

    suspend fun deleteQuotesById(id: Long)

    suspend fun insertQuotes(quot: String, id: Long? = null)
}