package org.techtown.seohyunrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    private val todoViewModel: MainViewModel by viewModels()
    private var id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        var edit_title = findViewById<EditText>(R.id.edit_title)
        var edit_content = findViewById<EditText>(R.id.edit_content)
        var btn_ok = findViewById<Button>(R.id.btn_ok)

        if (intent != null && intent.hasExtra(EXTRA_TODO_TITLE)
                            && intent.hasExtra(EXTRA_TODO_CONTENT)
                            && intent.hasExtra(EXTRA_TODO_ID)) {



            edit_title.setText(intent.getStringExtra(EXTRA_TODO_TITLE))
            edit_content.setText(intent.getStringExtra(EXTRA_TODO_CONTENT))
            id = intent.getIntExtra(EXTRA_TODO_ID, -1)
        }


        btn_ok.setOnClickListener {
            if (edit_title.text.isNotEmpty() && edit_content.text.isNotEmpty()) {
                val todo = Todo(id, edit_title.text.toString(), edit_content.text.toString())

                lifecycleScope.launch(Dispatchers.IO) {
                    todoViewModel.insert(todo)
                }
                finish()
            } else {
                Toast.makeText(this, "제목과 내용을 입력해주세요!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        const val EXTRA_TODO_TITLE = "EXTRA_TODO_TITLE"
        const val  EXTRA_TODO_CONTENT = "EXTRA_TODO_CONTENT"
        const val EXTRA_TODO_ID = "EXTRA_TODO_ID"
    }
}