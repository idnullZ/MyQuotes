package idnull.z.myquotes.data.di

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import idnull.z.myquotes.QuotesDatabase
import idnull.z.myquotes.data.QuotesDataSourceImpl
import idnull.z.myquotes.domain.QuotesDataSource
import javax.inject.Singleton


@Module
class MainModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = QuotesDatabase.Schema,
            context = app,
            name = "quotes.db"
        )
    }

    @Provides
    @Singleton
    fun providePersonDataSource(driver: SqlDriver): QuotesDataSource {
        return QuotesDataSourceImpl(QuotesDatabase(driver))
    }
}