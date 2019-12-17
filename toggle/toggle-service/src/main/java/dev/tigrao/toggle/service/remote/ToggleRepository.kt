package dev.tigrao.toggle.service.remote

import dev.tigrao.toggle.service.local.ToggleLocalDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

internal class ToggleRepository(
    private val toggleApi: ToggleApi,
    private val toggleLocalDataSource: ToggleLocalDataSource
) : Callback<List<ToggleRemoteDTO>> {

    fun fetchTogglesFromRemote() {
        toggleApi.getToggleTree().enqueue(this)
    }

    override fun onResponse(
        call: Call<List<ToggleRemoteDTO>>,
        response: Response<List<ToggleRemoteDTO>>
    ) {
        if (response.isSuccessful)
            toggleLocalDataSource.saveLocal(response.body())
    }

    override fun onFailure(call: Call<List<ToggleRemoteDTO>>, t: Throwable) {
        Timber.e(t, "Error when calling remote feature toggle")
    }
}
