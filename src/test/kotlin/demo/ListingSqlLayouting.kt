package demo

import com.mysql.management.util.Str
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.DateColumnType
import org.jetbrains.exposed.sql.RealColumnType
import org.jetbrains.exposed.sql.Table
//import org.joda.time.DateTime

/**
 * Created by adambl4 on 11/3/16.
 */

object Listings : Table("Listings") {
    val id = text("id").primaryKey()
    val vin = text("vin")
    val make = text("make")
    val model = text("model")
    val year = text("yer")
    val trim = text("trim")
    val title = text("title")
    val phone = text("phone")
    val status = text("status")
    val shortUrl = text("short_url")
    val description = text("description")
    val seller_description = text("seller_description")
    val mileage = integer("mileage")
    val price = integer("price")
    val transmission = text("transmission")
    val seller_reason_for_selling_description = text("seller_reason_for_selling_description")
    val seller_maintenance_description = text("seller_maintenance_description")
    val seller_damage_description = text("seller_damage_description")
    val seller_afermarket_description = text("seller_afermarket_description")
    val reasons_for_selling = text("TODO") //?
    val vehicle_condition = text("TODO") //?
    val categories = text("categories")
    val lowest_monthly_payment = text("")
    val lowest_apr = real("lowes_apr")
    val cover_image = text("cover_image")
    val featured = bool("featured")
    val number_of_owners = integer("number_of_owners")
    val number_of_accidents = integer("nubmer_of_accidents")
    val registered_in_states = text("registered_in_states")

    val mileageActual = integer("mileage_actual")
    val mileageAverage = integer("mileage_average")
    val mileagePercentageRatio = real("mileage_percentage_ratio")
    val cost_insurance = integer("cost_insurance")
    val cost_maintenance_repairs = integer("cost_maintenance_repairs")
    val cost_taxandfees = integer("cost_taxandfees")

    val cost_fuel = integer("cost_fuel")
    val price_estimate_retail = integer("price_estimate_retail")
    val price_estimate_fair = integer("price_estimate_fair")
    val price_estimate_trade_in = integer("price_estimate_trade_in")


    //val safety_rating_letter_grade = TODO()
    val kbb_trade_in_price = integer("kbb_trade_in_price")
    val kbb_dealership_price = integer("kbb_dealership_price")


    val checks_id = text("vehicle_background_checks_id")

    val owner_id = integer("user_id")
    val addressesId = text("addresses_id")
    val recallsId = text("recalls_id")
    val technical_specs_id = integer("technical_specs_id")
    val followers_id = integer("followers_id")
    val imagesId = text("images_id")
    val featuresId = text("features_id")

    val createdAt = createdAt()
    val updatedAt = updatedAt()
    val viewedAt = date("viewed_at") //?
    val bookmarkedAat = date("bookmarked_at") //?
}

object Users : Table("Users") {
    val id = text("id").primaryKey()
    val firstName = text("first_name")
    val secondName = text("second_name")
    val photoUrl = text("photo_url")
}

object Images : Table("Images") {
    val id = integer("id").autoIncrement().primaryKey()
    val uri = text("uri")
    val imageType = text("image_type")
    val width = integer("width")
    val height = integer("height")
}

object VehicleFeature : Table("Features") {
    val id = integer("id").autoIncrement().primaryKey()
    val slug = text("slug")
    val iconUrl = text("icon_url")
    val priority = text("priority")
}


object Recalls : Table("Recalls") {
    val id = text("id").primaryKey()
    val listingId = text("listing_id") references Listings.id
    val nhtsa_recall_number = text("nhtsa_recall_number")
    val components = text("components")
    val manufacturer_recall_number = text("manufacturer_recall_number")
    val summary = text("summary ")
    val safety_risk = text("safety_risk")
    val remedy = text("remedy")
    val manufacturer_notes = text("manufacturer_notes")
    val recall_status = text("recall_status")
    val recall_complete: Boolean? = null //?
    val recall_date = date("recall_date")
    val created_at = createdAt()
    val updated_at = updatedAt()
}

object VehicleBackgroundChecks : Table("VehicleBackgroundChecks") {
    val id = text("id").primaryKey()
    val title = text("title")
    val checkDescription = text("check_description")
    val passed = bool("passed")
    val priority = integer("priority")
}

object TechnicalSpecs : Table("TechnicalSpecs") {
    val id = integer("id").autoIncrement().primaryKey()
    val listingId = text("listing_id") references Listings.id

    val engineId = integer("engine_id")
    val engineName = text("engine_name")
    val engineEquipmentType = text("engine_equipment_type")
    val engineCompressionRatio = integer("engine_compression_ratio")
    val engineCylinder = integer("engine_cylinder")
    val engineSize = real("engine_size")
    val engineDisplacement = integer("engine_displacement")
    val engineConfiguration = text("engine_configuration")
    val engineFuelType = text("engine_fuel_type")
    val engineHorsepower = integer("engine_horsepower")
    val engineTorque: String? = null //TODO migration
    val engineTotalValves = integer("engine_total_valves")
    val engineManufacturerCode = text("engine_manufacturer_code")
    val engineType = text("engine_type")
    val engineCode = text("engine_code")
    val engineCompressorType = text("engine_compressor_type")
    val engineRpmHorsepower = integer("engine_rmp_horsepower")
    val engineValveTiming = text("engine_valve_timing")
    val engineValveGear = text("engine_valve_gear")
    ///
    val transmissionName = text("transmission_name")
    val transmissionId = integer("transmission_id")
    val transmissionEquipmentType = text("transmission_equipment_type")
    val transmissionAutomaticType = text("transmission_automatic_type")
    val transmissionType = text("transmission_type")
    val transmissionNumberOfSpeeds = text("transmission_number_of_speeds")
    //
    val market = text("market")
    val ePAClass = text("ePAC_class")
    val vehicleSize = text("vehicle_size")
    val primaryBodyType = text("primary_body_type")
    val vehicleStyle = text("vehicle_style")
    val vehicleType = text("vehicle_type")
    //
    val mpg_highway = text("mpg_highway")
    val mpg_city = text("mpg_city")
}

fun Table.createdAt(): Column<String> = registerColumn("created_at", DateColumnType(false))
fun Table.updatedAt(): Column<String> = registerColumn("updated_at", DateColumnType(false))
fun Table.real(name: String): Column<String> = registerColumn(name, RealColumnType())

fun main(args: Array<String>) {

}
