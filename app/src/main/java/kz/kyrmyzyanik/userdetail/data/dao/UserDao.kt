package kz.kyrmyzyanik.userdetail.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kz.kyrmyzyanik.userdetail.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("SELECT * FROM user")
    fun getUsers(): List<User>


    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserByID(userId: Int): User
}