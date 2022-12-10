package com.frotel.cda.livedata_mvvm.modelview

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.frotel.cda.mvvm_livedata_login.model.database.entity.User
import com.frotel.cda.myapplication.model.database.relation.UserDatabase
import com.frotel.cda.myapplication.model.database.repository.UserRepository

class ViewModelUser : ViewModel() {

    var liveDataLogin: LiveData<User>? = null

    fun insertData(context: Context, username: String, password: String) {
        UserRepository.insertData(context, username, password)
    }

    fun getLoginDetails(context: Context, username: String, password: String) : LiveData<User>? {
        liveDataLogin = UserRepository.getLoginDetails(context, username,password)
        return liveDataLogin
    }

}