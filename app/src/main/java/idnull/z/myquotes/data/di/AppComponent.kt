package idnull.z.myquotes.data.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import idnull.z.myquotes.data.di.viewmodel.BindsViewModelModule
import idnull.z.myquotes.data.di.viewmodel.ViewModelModule
import idnull.z.myquotes.presentation.quotes_main.MainFragment


@Component(modules = [MainModule::class, BindsViewModelModule::class, ViewModelModule::class])
interface AppComponent {


    @Component.Builder
    interface AppComponentBuilder{

        @BindsInstance
        fun context(context: Context):AppComponentBuilder


        fun build():AppComponent

    }


    fun inject(mainFragment: MainFragment)
}