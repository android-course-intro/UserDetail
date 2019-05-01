package kz.kyrmyzyanik.userdetail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * This entity class describes an object. Its used as entity for DataBase and simple object for POJO.
 */
//@Entity(ignoredColumns = arrayOf("geo"))
data class Geo(private val s:String)
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "lat") @SerializedName("lat") val lat: String,
//    @ColumnInfo(name = "lng") @SerializedName("lng") val lng: String)

