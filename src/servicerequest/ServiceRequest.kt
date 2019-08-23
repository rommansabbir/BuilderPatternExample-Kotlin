package servicerequest

import java.util.*

class ServiceRequest(serviceRequestBuilder: ServiceRequestBuilder) {
    /**
     * All necessary data for a single [ServiceRequest] object
     */
    private var serviceName : String? = null
    private var requestTime : Date = Calendar.getInstance().time
    private var requestLocation : Location? = null
    private var bookingFee : Double? = null
    private var totalAmount : Double? = null
    private var description : String? = null

    /**
     * Initialize required values
     */
    init {
        this.serviceName = serviceRequestBuilder.serviceName
        this.requestTime = serviceRequestBuilder.requestTime
        this.requestLocation = serviceRequestBuilder.requestLocation
        this.bookingFee = serviceRequestBuilder.bookingFee
        this.totalAmount = serviceRequestBuilder.totalAmount
        this.description = serviceRequestBuilder.description
    }

    override fun toString(): String {
        return "Service Name: $serviceName, Location : ${requestLocation.toString()}, Date: ${requestTime.toString()}, Booking Fee: ${bookingFee.toString()}, Total Amount: $totalAmount, Description: $description"
    }

    /**
     * Pass required data through constructor
     */
    class ServiceRequestBuilder(val serviceName: String, val requestLocation : Location, val bookingFee : Double){
        /**
         * All required data for a single [ServiceRequest] object
         */
        var requestTime : Date = Calendar.getInstance().time
        var totalAmount : Double? = null
        var description : String? = null

        /**
         * Set total amount to [ServiceRequest] object
         * @param totalAmount, Total amount
         */
        fun totalAmount(totalAmount : Double) : ServiceRequestBuilder{
            this.totalAmount = totalAmount
            return this
        }

        /**
         * Set description to [ServiceRequest] object
         * @param description, Description
         */
        fun description(description : String) : ServiceRequestBuilder{
            this.description = description
            return this
        }

        /**
         * New build the request object
         * @return [ServiceRequest]
         */
        fun build() : ServiceRequest{
            return ServiceRequest(this)
        }
    }
}