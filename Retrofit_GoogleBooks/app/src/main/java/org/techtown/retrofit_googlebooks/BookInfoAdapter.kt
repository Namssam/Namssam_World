package org.techtown.retrofit_googlebooks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.techtown.retrofit_googlebooks.databinding.BookItemsBinding

// 참고: https://bb-library.tistory.com/89?category=843046

// Databinding을 VolumeInfo로 조작 그래서 파라미터가 VolumeInfo임
class BookInfoAdapter(val volumeInfoClick: (VolumeInfo) -> Unit, val volumeInfoLongClick: (VolumeInfo) -> Unit):
        ListAdapter<BookInfo, BookInfoAdapter.ViewHolder>(BookInfoDiffUtil) {

    private var volumeInfos: List<VolumeInfo> = listOf()

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
                volumeInfoClick(volumeInfo)
            }

            binding.root.setOnLongClickListener {
                volumeInfoLongClick(volumeInfo)
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
        this.volumeInfos = volumeInfos
        notifyDataSetChanged()
    }

}