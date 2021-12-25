package idnull.z.myquotes.data

import idnull.z.myquotes.data.network.QuoteApi
import idnull.z.myquotes.domain.Respond
import javax.inject.Inject

class MainScreenRepository @Inject constructor(
    private val api: QuoteApi
){
    suspend  fun getQuot(): Respond {

        return api.getQuot()
    }

}