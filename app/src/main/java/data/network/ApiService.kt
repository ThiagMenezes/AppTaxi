package data.network

import data.EstimativeRideRequest
import data.RideEstimateResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("/ride/estimate")
    suspend fun estimateRide(@Body request: EstimativeRideRequest): RideEstimateResponse

    @PATCH("/ride/confirm")
    suspend fun confirmRide(@Body request: Map<String, Any>): RideEstimateResponse

    @GET("/ride/customer_id")
    suspend fun getRides(@retrofit2.http.Path("customer_id") customerId: String): List<RideEstimateResponse>

    fun getRideHistory(@Path("customer_id") customerId: String, @Query("driver_id") driverId: Int? ): Call<RideHistoryResponse>



}