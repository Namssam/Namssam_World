package org.techtown.seohyunrecyclerview

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.techtown.seohyunrecyclerview.databinding.ItemLayoutBinding

// RecyclerView Adapter 생성
class TodoAdapter(val todoItemClick: (Todo) -> Unit, val todoItemLongClick: (Todo) -> Unit)
    : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

        private var todos: MutableList<Todo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    inner class ViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            binding.todo = todo

            binding.root.setOnClickListener {
                todoItemClick(todo)
            }

            binding.root.setOnLongClickListener {
                todoItemLongClick(todo)
/*
val alertBuilder: AlertDialog.Builder = AlertDialog.Builder(it.context)
                alertBuilder.setTitle("삭제 여부 확인")
                            .setMessage("삭제하시겠습니까?")

                alertBuilder.setPositiveButton("삭제", DialogInterface.OnClickListener {
                })

                alertBuilder.setNegativeButton("취소", DialogInterface.OnClickListener {
                        dialog, which ->
                    Toast.makeText(it.context, "삭제를 취소하셨습니다.", Toast.LENGTH_SHORT).show()
                })

                val alertDialog: AlertDialog = alertBuilder.create()
                alertDialog.show()
 */
                true
            }
        }
    }

    fun setTodos(todos: MutableList<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
/*
 fun remove(position: Int) {

        try {
            todos.remove(position)
            notifyItemRemoved(position)

        } catch (ex: IndexOutOfBoundsException) {
            ex.printStackTrace()
        }
    }
 */

}