package idnull.z.myquotes.data.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import idnull.z.myquotes.data.di.viewmodel.BindsViewModelModule
import idnull.z.myquotes.data.di.viewmodel.ViewModelModule
import idnull.z.myquotes.presentation.quotes_add_edit.QuotesAddFragment
import idnull.z.myquotes.presentation.quotes_list.QuotesListFragment
import idnull.z.myquotes.presentation.quotes_main.MainFragment
import javax.inject.Singleton


@Singleton
@Component(modules = [MainModule::class, BindsViewModelModule::class, ViewModelModule::class])
interface AppComponent {


    @Component.Builder
    interface AppComponentBuilder{

        @BindsInstance
        fun context(context: Application):AppComponentBuilder


        fun build():AppComponent

    }


    fun inject(quotesListFragment: QuotesListFragment)
    fun inject(mainFragment: MainFragment)
    fun inject(quotesAddFragment: QuotesAddFragment)
}