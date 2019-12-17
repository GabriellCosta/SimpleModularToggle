package dev.tigrao.toggle.service.local

import dev.tigrao.toggle.service.ToggleDtoConverter
import dev.tigrao.toggle.service.remote.ToggleRemoteDTO

internal class ToggleLocalDataSource(
    private val toggleDao: ToggleDao,
    private val toggleDtoConverter: ToggleDtoConverter<ToggleRemoteDTO, ToggleLocalDTO>
) {

    fun saveLocal(toggleTree: List<ToggleRemoteDTO>?) {
        toggleTree?.let {
            toggleDao.deleteToggles()
            if (it.isNotEmpty())
                toggleDao.saveToggleTree(toggleDtoConverter.convertFromRemoteToLocal(it))
        }
    }
}
