package com.example.cobagithub.model

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cobagithub.api.RetrofClient
import com.example.cobagithub.data.dataset.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel() {
    private val userDetail = MutableLiveData<Users>()

    fun setUserDetail(username: String, context: Context) {
        RetrofClient.getService().getDetailUsers(username).enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    userDetail.value = response.body()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                Toast.makeText(context, "onFailure: ${t.message.toString()}", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    fun getUserDetail(): LiveData<Users> = userDetail

    companion object {
        const val TAG = "TAG"
    }
}