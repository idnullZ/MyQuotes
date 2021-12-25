package idnull.z.data.network

import idnull.z.domain.Respond
import retrofit2.http.GET
import retrofit2.http.Headers

interface QuoteApi {

    @GET("./random")
    @Headers("Content-Type: application/json")
    suspend fun getQuot(): Respond
}