package org.techtown.retrofit_googlebooks

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.os.persistableBundleOf
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techtown.retrofit_googlebooks.databinding.BookItemsBinding
import java.lang.IndexOutOfBoundsException

// 참고: https://bb-library.tistory.com/89?category=843046

// Databinding을 VolumeInfo로 조작 그래서 파라미터가 VolumeInfo임
class BookInfoAdapter:
        ListAdapter<BookInfo, BookInfoAdapter.ViewHolder>(BookInfoDiffUtil) {

    private var volumeInfos: MutableList<VolumeInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BookItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return volumeInfos.size
    }

    override fun onBindViewHolder(holder: BookInfoAdapter.ViewHolder, position: Int) {
        holder.bind(volumeInfos[position])
    }

    inner class ViewHolder(val binding: BookItemsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(volumeInfo: VolumeInfo) {
            binding.volumeInfo = volumeInfo
            // 데이터가 수정되면 즉각 바인딩
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                // TODO: Set WebView
            }

            binding.root.setOnLongClickListener {
                val alertBuilder = AlertDialog.Builder(it.context)
                alertBuilder.setTitle("삭제 여부 확인")
                            .setMessage("삭제하시겠습니까?")

                alertBuilder.setPositiveButton("삭제", DialogInterface.OnClickListener
                { dialog, which ->
                    // 여기 뭐가 들어가야 할 지 찾아볼 것
                    // TODO: remove안에 어떤게 들어가야 할 지 알아볼 것
                    remove(position)
                })

                alertBuilder.setNegativeButton("취소", DialogInterface.OnClickListener
                { dialog, which ->
                    Toast.makeText(it.context, "삭제를 취소하셨습니다.", Toast.LENGTH_SHORT).show()
                })

                val alertDialog = alertBuilder.create()
                alertDialog.show()

                true
            }
        }
    }

    companion object BookInfoDiffUtil: DiffUtil.ItemCallback<BookInfo>() {
        override fun areItemsTheSame(oldItem: BookInfo, newItem: BookInfo): Boolean {
            // 각 아이템들의 고유한 값을 비교해야 한다.
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: BookInfo, newItem: BookInfo): Boolean {
            return oldItem == newItem
        }
    }

    fun setVolumeInfos(volumeInfos: List<VolumeInfo>) {
        this.volumeInfos = volumeInfos as MutableList<VolumeInfo>
        notifyDataSetChanged()
    }
    
    // 아이템 삭제 메서드 정의
    fun remove(position: Int) {

        try {
            volumeInfos.removeAt(position)
            notifyItemRemoved(position)
            
        } catch (ex: IndexOutOfBoundsException) {
            ex.printStackTrace()
        }
    }

}