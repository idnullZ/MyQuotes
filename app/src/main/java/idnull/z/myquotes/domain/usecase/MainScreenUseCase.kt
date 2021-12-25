package idnull.z.myquotes.domain.usecase

import idnull.z.data.network.MainScreenRepository
import idnull.z.domain.Respond
import javax.inject.Inject

class MainScreenUseCase @Inject constructor(
   private val repository: MainScreenRepository
) {
   suspend operator fun invoke(): idnull.z.domain.Respond {
        return repository.getQuot()
    }
}