package e.asus.demonotepadwithkotlin

import androidx.room.*

@Dao
interface NotepadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(listData: ListData)

    @Query("Select * from ListData")
    fun getallNotes() : List<ListData>

    @Delete
    fun deleteNote(listData: ListData)
}