package e.asus.demonotepadwithkotlin

import android.content.Context
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import e.asus.demonotepadwithkotlin.databinding.ItemRowBinding
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.zip.Inflater

class NotepadAdapter(var context: Context, var list: List<ListData>) :
    RecyclerView.Adapter<NotepadAdapter.MyViewHolder>() {


    lateinit var binding: ItemRowBinding
lateinit var notepadDao: NotepadDao
    lateinit var executor: Executor
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, R.layout.item_row, parent, false)
        executor = Executors.newSingleThreadExecutor()
        return MyViewHolder(binding.root)

    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
        notepadDao=NotepadDatabase.getInstance(context).notepadDao()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            binding.title.text= list[position].title
            binding.description.text=list[position].description

            binding.delete.setOnClickListener {
                removeItems(position)


            }

        }

    }
    fun removeItems(position: Int)
    {
        notepadDao=NotepadDatabase.getInstance(context).notepadDao()
        val id = list[position].id
        executor.execute {
            notepadDao.deleteNote(list[position])

        }

    }}


