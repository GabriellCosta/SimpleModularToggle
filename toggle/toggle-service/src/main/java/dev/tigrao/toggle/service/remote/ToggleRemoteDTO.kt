package dev.tigrao.toggle.service.remote

import com.google.gson.annotations.SerializedName

internal class ToggleRemoteDTO(
    @SerializedName("name") val toggleName: String,
    @SerializedName("enabled") val isToggleEnabled: Boolean
)
