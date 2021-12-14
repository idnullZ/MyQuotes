package idnull.z.myquotes.presentation.quotes_main

import androidx.lifecycle.ViewModel
import idnull.z.myquotes.domain.usecase.MainScreenUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(val useCase: MainScreenUseCase) : ViewModel() {


    val result = useCase.test1
}