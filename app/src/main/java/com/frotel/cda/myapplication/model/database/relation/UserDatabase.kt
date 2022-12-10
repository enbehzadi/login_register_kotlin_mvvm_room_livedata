package com.frotel.cda.myapplication.model.database.relation
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.frotel.cda.mvvm_livedata_login.model.database.dao.UserDao
import com.frotel.cda.mvvm_livedata_login.model.database.entity.User
// UserDatabase represents database and contains the database holder and server the main access point for the underlying connection to your app's persisted, relational data.

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDataseClient(context: Context) : UserDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, UserDatabase::class.java, "LOGIN_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }

}