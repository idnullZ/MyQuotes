package idnull.z.myquotes.domain.usecase

import idnull.z.myquotes.data.MainScreenRepository
import idnull.z.myquotes.domain.Respond
import javax.inject.Inject

class MainScreenUseCase @Inject constructor(
   private val repository: MainScreenRepository
) {
   suspend operator fun invoke(): Respond {
        return repository.getQuot()
    }
}