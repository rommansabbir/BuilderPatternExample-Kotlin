package servicerequest

class Location(private val lat: Double, private val lng: Double) {
    override fun toString(): String {
        return "Lat: $lat, Lng: $lng"
    }
}