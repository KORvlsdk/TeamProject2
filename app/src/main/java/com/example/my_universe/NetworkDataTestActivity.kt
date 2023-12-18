package com.example.my_universe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.my_universe.ApiModel.ItemListModel77
import com.example.my_universe.MainAdapter.MyAdapterRetrofit77
import com.example.my_universe.databinding.ActivityNetworkDataTestBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkDataTestActivity : AppCompatActivity() {
    lateinit var binding: ActivityNetworkDataTestBinding
    val serviceKey2 = "kg65cAU1UMyBFZ6ROiERqjqaGt2Ntxv+j96pqyIGsQ+fbnuGPuRs7ZQmr6MhZMqV/6ZmaAiKEQ5y+S0IOTO+bg=="
    var pageNum = 1
    var numOfRows = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkDataTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1
        val networkService = (applicationContext as com.example.my_universe.MyApplication).networkService
        val boardListCall = networkService.getMainBoardItem(serviceKey2, pageNum, numOfRows, "json")
        boardListCall.enqueue(object : Callback<ItemListModel77> {
            override fun onResponse(
                call: Call<ItemListModel77>,
                response: Response<ItemListModel77>
            ) {
                val boardListModel = response.body()
                if (boardListModel != null) {
                    Log.d("lsy", "BoardListModel 값 : ${boardListModel.getRecommendedKr.item}")
                    val layoutManager = LinearLayoutManager(
                        this@NetworkDataTestActivity)
                    // 리사이클러뷰에 어댑터 연결
                    // 인자값은 : 현재 context : this@HttpTestReqResActivity
                    // 2번째 인자값은 : 데이터 , 네트워크 ,레트로핏2 통신으로 받아온 데이터 리스트

                    //변경7
                    binding.testRecyclerView77.layoutManager = layoutManager
                    // 변경9 주의사항, 객체 안에 배열 또 있다.
                    binding.testRecyclerView77.adapter =
                        MyAdapterRetrofit77(this@NetworkDataTestActivity,boardListModel?.getRecommendedKr?.item)
                }
            }

            override fun onFailure(call: Call<ItemListModel77>, t: Throwable) {
                Log.d("lsy", "데이터를 못 받아옴")
                call.cancel()
            }
        })

        //2



    } //onCreate
}