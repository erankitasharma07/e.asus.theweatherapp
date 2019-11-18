package e.asus.demonotepadwithkotlin

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class ListData (
     var title :String,
     var description :String,
     @PrimaryKey
     var id : String

)