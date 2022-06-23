package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.R
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.ImageLinks

object BindingAdapter {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun loadImage(imageView: ImageView, url: String?) {

        Glide.with(imageView.context).load(url).error(R.drawable.ic_launcher_foreground)
            .into(imageView)
    }
}