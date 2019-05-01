package kz.kyrmyzyanik.userdetail.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * This entity class describes an object. Its used as entity for DataBase and simple object for POJO.
 */
//@Entity(ignoredColumns = arrayOf("company"))
data class Company(private val s:String)
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "name") @SerializedName("name") val name: String,
//    @ColumnInfo(name = "catchPhrase") @SerializedName("catchPhrase") val catchPhrase: String,
//    @ColumnInfo(name = "bs") @SerializedName("bs") val bs: String)

