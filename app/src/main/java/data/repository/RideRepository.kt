package data.repository

import data.EstimativeRideRequest
import data.network.ApiService
import data.network.RetrofitInstance.api

class RideRepository(private val api: ApiService) {
    suspend fun estimateRide(request: EstimativeRideRequest) = api.estimateRide(request)
    suspend fun confirmRide(request: Map<String, Any>) = api.confirmRide(request)
    suspend fun getRides(customerId: String) = api.getRides(customerId)

}