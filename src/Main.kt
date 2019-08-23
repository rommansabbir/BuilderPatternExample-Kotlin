import servicerequest.Location
import servicerequest.ServiceRequest

class Main {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val instance = ServiceRequest.
                ServiceRequestBuilder(
                        "Accident",
                        Location(0.0, 0.0),
                        12.5).
                build()
            println(instance.toString())

            val instance2 = ServiceRequest.
                ServiceRequestBuilder(
                    "Fake accident",
                    Location(0.0, 0.0),
                    50.5).
                totalAmount(189.0).
                build()
            println(instance2.toString())

            val instance3 = ServiceRequest.
                ServiceRequestBuilder(
                    "Another Accident",
                    Location(0.0, 0.0),
                    50.5).
                totalAmount(189.0).
                description("Need medical help too").
                build()
            println(instance3.toString())
        }
    }


}