package dev.tigrao.toggle.service.remote

import retrofit2.Call
import retrofit2.http.GET

internal interface ToggleApi {

    @GET("/feature-toggles")
    fun getToggleTree(): Call<List<ToggleRemoteDTO>>
}
