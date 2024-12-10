package data.network

data class RideHistoryResponse(
    val customer_id: String,
    val rides: List<Ride>
)
