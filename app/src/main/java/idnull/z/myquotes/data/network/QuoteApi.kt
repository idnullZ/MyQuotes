package idnull.z.myquotes.data.network

import idnull.z.myquotes.domain.Respond
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuoteApi {

    @GET("./random")
    @Headers("Content-Type: application/json")
    suspend fun getQuot(): Respond
}