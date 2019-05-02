package kz.kyrmyzyanik.userdetail.model

import androidx.room.*
import com.google.gson.annotations.SerializedName


/**
 * This entity class describes an object. Its used as entity for DataBase and simple object for POJO.
 */
@Entity (tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") @SerializedName("id") val id: Int,
    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "username") @SerializedName("username") val username: String,
    @ColumnInfo(name = "email") @SerializedName("email") val email: String,
    @ColumnInfo(name = "phone") @SerializedName("phone") val phone: String,
    @ColumnInfo(name = "website") @SerializedName("website") val website: String,
    @Embedded @SerializedName("company") val company: Company,
    @Embedded @SerializedName("address") val address: Address)


data class Company(
    @ColumnInfo(name = "company_name") @SerializedName("name") val name: String,
    @ColumnInfo(name = "catchPhrase") @SerializedName("catchPhrase") val catchPhrase: String,
    @ColumnInfo(name = "bs") @SerializedName("bs") val bs: String)



data class Address(
    @ColumnInfo(name = "street") @SerializedName("street") val street: String,
    @ColumnInfo(name = "suite") @SerializedName("suite") val suite: String,
    @ColumnInfo(name = "city") @SerializedName("city") val city: String,
    @ColumnInfo(name = "zipcode") @SerializedName("zipcode") val zipcode: String,
    @Embedded @SerializedName("geo") val geo: Geo)


data class Geo(
    @ColumnInfo(name = "lat") @SerializedName("lat") val lat: String,
    @ColumnInfo(name = "lng") @SerializedName("lng") val lng: String)

