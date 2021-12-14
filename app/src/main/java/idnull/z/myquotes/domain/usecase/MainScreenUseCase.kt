package idnull.z.myquotes.domain.usecase

import idnull.z.myquotes.data.MainScreenRepository
import javax.inject.Inject

class MainScreenUseCase @Inject constructor(
    val repository: MainScreenRepository
) {

    val test1 = repository.test
}