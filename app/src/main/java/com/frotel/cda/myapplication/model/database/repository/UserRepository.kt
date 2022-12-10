package com.frotel.cda.myapplication.model.database.repository
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.frotel.cda.mvvm_livedata_login.model.database.entity.User
import com.frotel.cda.myapplication.model.database.relation.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

// UserDatabase represents database and contains the database holder and server the main access point for the underlying connection to your app's persisted, relational data.

class UserRepository {

    companion object {

        var loginDatabase: UserDatabase? = null

        var loginTableModel: LiveData<User>? = null

        fun initializeDB(context: Context) : UserDatabase {
            return UserDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, username: String, password: String) {

            loginDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val loginDetails = User(username, password)
                loginDatabase!!.userDao().InsertData(loginDetails)
            }

        }

        fun getLoginDetails(context: Context, username: String, password: String) : LiveData<User>? {

            loginDatabase = initializeDB(context)

            loginTableModel = loginDatabase!!.userDao().getLoginDetails(username,password)

            return loginTableModel
        }

    }
}