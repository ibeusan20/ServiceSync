package hr.foi.air.mapcodev7

import java.time.Year

data class Car(
    val manufacturer : String,
    val model : String,
    val year : Int,
    private val latitude : Double,
    private val longitude : Double,
) : MapCodeDisplayable {
    override fun getLatitude(): Double {
        return latitude
    }

    override fun getLongitude(): Double {
        return longitude
    }

    override fun getCode(): String {
        return this.toString()
    }
}
