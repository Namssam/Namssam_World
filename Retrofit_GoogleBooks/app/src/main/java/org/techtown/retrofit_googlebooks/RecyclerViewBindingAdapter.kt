package org.techtown.retrofit_googlebooks

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

// 참고: https://bb-library.tistory.com/94?category=843046
// activity_main.xml에서 recyclerView 부분 app:listData에 사용하기 위함

object RecyclerViewBindingAdapter {
    @BindingAdapter("listData")
    @JvmStatic
    fun BindData(recyclerView: RecyclerView, bookInfos: List<BookInfo>?) {
        val adapter = recyclerView.adapter as BookInfoAdapter
        adapter.submitList(bookInfos)
    }
}