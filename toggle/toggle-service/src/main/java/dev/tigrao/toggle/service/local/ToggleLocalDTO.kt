package dev.tigrao.toggle.service.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toggle")
class ToggleLocalDTO(
    @PrimaryKey
    @ColumnInfo(name = "featureToggleKey") val featureKey: String,
    @ColumnInfo(name = "isEnabled") val isEnabled: Boolean
)
