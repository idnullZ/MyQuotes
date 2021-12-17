package idnull.z.myquotes.data

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import idnull.z.myquotes.QuotesDatabase
import idnull.z.myquotes.domain.QuotesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import mydb.quotesdb.QuotesEntity

class QuotesDataSourceImpl(
    db: QuotesDatabase
):QuotesDataSource {

    private val queries = db.quotesEntityQueries

    override suspend fun getQuotesById(id: Long): QuotesEntity? {
        return withContext(Dispatchers.IO) {
            queries.getQuotesById(id).executeAsOneOrNull()
        }
    }

    override fun getAllQuotes(): Flow<List<QuotesEntity>> {
        return queries.getAllQuotes().asFlow().mapToList()
    }

    override suspend fun deleteQuotesById(id: Long) {
        withContext(Dispatchers.IO) {
            queries.deleteQuotesById(id)
        }
    }

    override suspend fun insertQuotes(quot: String, id: Long?) {
        withContext(Dispatchers.IO) {
            queries.insertQuotes(id, quot )
        }
    }


}