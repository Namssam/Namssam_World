package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.R
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.adapter.GoogleBooksAdapter
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.databinding.ActivityMainBinding
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.repository.Repository
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    // private val TAG = "Response"

    // lateinit var로 했을 경우 늦은초기화를 할 수 없다는 오류가 발생함(by lazy로 변경함) -> viewModel을 사용할 때 값을 넣어주지 않았음
    //private val viewModel by lazy {MainViewModel(Repository())}
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    //val viewModel: MainViewModel by viewModels()


    private val bookAdapter by lazy {GoogleBooksAdapter()}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        // 데이터 바인딩
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        // 어댑터 연결
        val adapter = bookAdapter
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        // lateinit을 해줬기 때문에 viewModel에 어떤 값이 들어갈지 넣어줘야함
        viewModel = MainViewModel(Repository())
        viewModel.makeApiCall()
        viewModel.myResponse.observe(this, Observer {
            adapter.setData(it)
        })

    }
}