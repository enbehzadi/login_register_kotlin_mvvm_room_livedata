package com.frotel.cda.mvvm_livedata_login.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.frotel.cda.mvvm_livedata_login.model.database.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertData(loginTableModel: User)

    @Query("SELECT * FROM user WHERE Username =:username and Password=:password")
    fun getLoginDetails(username: String?,password: String?) : LiveData<User>

}