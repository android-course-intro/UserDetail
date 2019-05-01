package kz.kyrmyzyanik.userdetail.data

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.kyrmyzyanik.userdetail.data.dao.UserDao
import kz.kyrmyzyanik.userdetail.model.User

/**
 * This class describes abstract Database and gives an access to entire application.
 */
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}