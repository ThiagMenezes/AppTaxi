package data

data class EstimativeRideRequest(
    val customer_id: String,
    val origin: String,
    val destination: String
)

data class RideEstimateResponse(
    val origin: Location,
    val destination: Location,
    val distance: Double,
    val duration: String,
    val options: List<DriverOption>
)

data class Location(
    val latitude: Double,
    val longitude: Double
)

data class DriverOption(
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: Review,
    val value: Double
)

data class Review(
    val rating: Double,
    val comment: String
)

