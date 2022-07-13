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

class FollowingViewModel : ViewModel() {

    val followingModel = MutableLiveData<ArrayList<Users>>()

    fun setData(username: String, context: Context) {
        RetrofClient.getService().getFollowing(username).enqueue(object : Callback<ArrayList<Users>> {
            override fun onResponse(
                call: Call<ArrayList<Users>>,
                response: Response<ArrayList<Users>>
            ) {
                if (response.isSuccessful) {
                    followingModel.value = response.body()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<Users>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
                Toast.makeText(context, "onFailure: ${t.message.toString()}", Toast.LENGTH_LONG)
                    .show()
            }

        })
    }

    fun getData(): LiveData<ArrayList<Users>> = followingModel

    companion object {
        const val TAG = "TAG"
    }
}