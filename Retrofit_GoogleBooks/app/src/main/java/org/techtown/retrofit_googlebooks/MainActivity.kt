package org.techtown.retrofit_googlebooks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import org.techtown.retrofit_googlebooks.databinding.ActivityMainBinding
import retrofit2.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val ViewModel: MainViewModel by viewModels()

    // var TAG = "Items" // 로그에 사용 할 TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        // activity_main.xml 에서 선언해 준 variable명
        binding.mainViewModel = ViewModel
        setRecyclerView()

        /*
        // https://hanyeop.tistory.com/199 참고
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.getBookInfo()
        viewModel.myResponse.observe(this, Observer {
            Log.d("Response", it.toString())
        })
         */


        //getBookData() // 책정보 가져오기 함수
    }

    private fun setRecyclerView() {
        // Set contactItemClick & contactItemLongClick lambda
        // 안에 들어갈 lambda식을 잘 모르겠음
        val adapter = BookInfoAdapter({volumeInfo -> volumeInfo },
            {volumeInfo -> volumeInfo })

        binding.recyclerView.adapter = adapter
        binding.recyclerView.setHasFixedSize(true)

/*
    // https://velog.io/@24hyunji/Retrofit-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0 참고
    // (인도아저씨)https://www.youtube.com/watch?v=5gFrXGbQsc8&list=PPSV 참고
    private fun getBookData() {

        // RetrofitBuilder에 있는 rtfService 호출
        val retrofitInterface = RetrofitBuilder.rtfInterface
        
        // 통신 성공 / 실패 시 상황 작성
        retrofitInterface.getBookInfo().enqueue(object : Callback<BookInfo?> {
            // 통신 성공 시
            override fun onResponse(call: Call<BookInfo?>, response: Response<BookInfo?>) {
                if (response.isSuccessful) {
                    response.body().let {
                        Log.d(TAG, it.toString()) // Items 정보를 가져오기
                    }
                }

            }
            // 통신 실패 시
            override fun onFailure(call: Call<BookInfo?>, t: Throwable) {
                Log.d(TAG, "통신 실패")
            }
        })


    }

 */
    }
}

