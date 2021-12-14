package idnull.z.myquotes.data.di.viewmodel

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import idnull.z.myquotes.presentation.quotes_main.MainViewModel


@Module
interface BindsViewModelModule {


    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindViewModel(impl: MainViewModel): ViewModel

}



