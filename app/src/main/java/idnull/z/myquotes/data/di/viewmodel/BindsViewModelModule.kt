package idnull.z.myquotes.data.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import idnull.z.myquotes.presentation.quotes_list.QuotesListViewModel
import idnull.z.myquotes.presentation.quotes_main.MainViewModel


@Module
interface BindsViewModelModule {


    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel


    @IntoMap
    @ViewModelKey(QuotesListViewModel::class)
    @Binds
    fun bindQuotesListViewModel(impl: QuotesListViewModel): ViewModel

}



