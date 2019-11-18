package e.asus.demonotepadwithkotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ListData::class), version = 1, exportSchema = false)
abstract class NotepadDatabase: RoomDatabase() {
abstract fun notepadDao() : NotepadDao
//it uses for static
companion object{
    private var INSTANCE : NotepadDatabase? = null
    private val LOCK = Any()
    fun getInstance(context: Context):NotepadDatabase {
        synchronized(LOCK)
        {
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(
                    context.applicationContext,NotepadDatabase::class.java,
                    "Notepad.db"


                ).fallbackToDestructiveMigration().build()
            }
        }
        return INSTANCE!!


    }

}



}