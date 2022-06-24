package org.techtown.mvvm_retrofit_room_repository_googlebooksapi.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.R
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.Items
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.data.VolumeInfo
import org.techtown.mvvm_retrofit_room_repository_googlebooksapi.databinding.BookItemBinding

// https://hanyeop.tistory.com/199 (전체적인 코드 참조)
// https://velog.io/@phoebe/%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B0%94%EC%9D%B8%EB%94%A9-Recyclerview(ViewHolder부분 참조)

class GoogleBooksAdapter
    : RecyclerView.Adapter<GoogleBooksAdapter.GoogleBooksViewHolder>(){

        private var bookList = emptyList<Items>()


    // 어떤 xml로 뷰 홀더를 생성할지 지정해줌
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
                :GoogleBooksViewHolder {

        val binding = BookItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return GoogleBooksViewHolder(binding)
    }
    inner class GoogleBooksViewHolder(val binding: BookItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Items) {
            binding.tvTitle.text = data.volumeInfo.title
            binding.tvAuthor.text = data.volumeInfo.authors.toString()
            binding.tvPublisher.text = data.volumeInfo.publisher
            binding.tvPublishedDate.text = data.volumeInfo.publishedDate
            //binding.executePendingBindings() (강제로 결합)
        }
    }

    override fun onBindViewHolder(holder: GoogleBooksViewHolder, position: Int) {

        // GoogleBooksViewHolder에서 정의해준 bind 함수 사용
        holder.bind(bookList[position])

        /*
        // book_item 레이아웃의 view들에 각각 정보 주입해주기
        holder.binding.tvTitle.text = bookList[position].volumeInfo.title
        holder.binding.tvAuthor.text = bookList[position].volumeInfo.authors.toString()
        holder.binding.tvPublisher.text = bookList[position].volumeInfo.publisher
        holder.binding.tvPublishedDate.text = bookList[position].volumeInfo.publishedDate
         */
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.book_item
    }


    // 뷰 홀더의 개수를 리턴해줌
    override fun getItemCount(): Int {
        return bookList.size
    }

    // 데이터 변경 시 리스트를 다시 할당해줌
    @SuppressLint("NotifyDataSetChanged")
    fun setData(item: List<Items>) {
        this.bookList = item

        // 새로고침(데이터 변경 시 옵저버에게 통보해줌)
        notifyDataSetChanged()
    }

}