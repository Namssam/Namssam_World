package org.techtown.retrofit_googlebooks

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

// 참고: https://bb-library.tistory.com/94?category=843046

// ImageView에 Databinding을 적용하고 싶거나 RecyclerView에 Databinding을 적용하고 싶을 때 사용
// Retrofit으로 받아온 포스터 경로는 baseUrl 변수 뒤에 붙여 전달되어야 함
object ImageBindingAdapter {
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String) {
        val baseUrl = "http://books.google.com/books/content?"
        Glide.with(imageView.context).load(baseUrl+url).error(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}
