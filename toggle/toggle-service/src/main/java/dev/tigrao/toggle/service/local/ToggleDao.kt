package dev.tigrao.toggle.service.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
internal interface ToggleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveToggleTree(toggleList: List<ToggleLocalDTO>): List<Long>

    @Query("DELETE FROM toggle")
    fun deleteToggles()

    @Query("SELECT * FROM toggle  WHERE featureToggleKey = :featureToggleKey")
    fun getToggleByFeature(featureToggleKey: String): ToggleLocalDTO?

    @Query("SELECT * FROM toggle")
    fun getToggleTree(): List<ToggleLocalDTO>
}
