#### Let's assume, you are a customer & you want service from a service provider. 
So, forgetting service from a service provider you need some basic information which will be sent to the provider, right? 
so that the provider can understand what kind of service you want. 

OK, let's break down our service request. We have 6 unique information against a request. Those are
* ``Service Name (required)``
* ``Request Location (required)``
* ``Request Time (required)``
* ``Booking Fee (required)``
* ``Total Amount (optional)``
* ``Description (optional)``

We can send a request to the provider in 2 ways, one is writing request for every time when you need to get a service (which is a bad practice).
Another one is to use a builder, who will build a request object for us for every single request.

As we can see that ``Service Name``, ``Request Location``, ``Request Time``, ``Booking Fee`` is required for the request, we can also provide some additional information to the provider.

Let's take a look at the code:

``````
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
``````
