package e.asus.demonotepadwithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import e.asus.demonotepadwithkotlin.databinding.ActivityNotepadDetailsBinding
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import kotlin.collections.ArrayList

class NotepadDetails : AppCompatActivity() {
    lateinit var binding: ActivityNotepadDetailsBinding
    lateinit var notepadDao: NotepadDao
    lateinit var listData: ListData
    lateinit var executor : Executor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_notepad_details)
        notepadDao = NotepadDatabase.getInstance(this).notepadDao()

        executor = Executors.newSingleThreadExecutor()
        binding.btnSave.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val description = binding.editDescription.text.toString()

            executor.execute {
                listData = ListData(title, description, UUID.randomUUID().toString())

                notepadDao.saveNote(listData)

                Log.d("data", notepadDao.getallNotes()[0].title)

                var intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
//                var intent = Intent(this, MainActivity::class.java)
            }

            // UUID provide random key for primary id value
        }
    }

}
