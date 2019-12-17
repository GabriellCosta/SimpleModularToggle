package dev.tigrao.toggle.service.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToggleLocalDTO::class], version = 1, exportSchema = false)
internal abstract class ToggleDb : RoomDatabase() {
    abstract fun toggleDao(): ToggleDao
}
