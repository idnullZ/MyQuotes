package idnull.z.data.network

import idnull.z.domain.Respond
import javax.inject.Inject

class MainScreenRepository @Inject constructor(
    private val api: QuoteApi
){
    suspend  fun getQuot(): Respond {

        return api.getQuot()
    }

}