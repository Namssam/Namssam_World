package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.adapter


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.R

// 출처: https://bb-library.tistory.com/91?category=843046
object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(imageView.context)
            .load(url) // 썸네일 링크를 직접 넣어주면 제대로 작동함
            .error(R.drawable.ic_launcher_foreground) 
            .into(imageView)

    }
}