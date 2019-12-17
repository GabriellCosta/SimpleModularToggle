package dev.tigrao.toggle.service

import dev.tigrao.toggle.service.local.ToggleLocalDTO
import dev.tigrao.toggle.service.remote.ToggleRemoteDTO

internal class ToggleDtoConverterImpl :
    ToggleDtoConverter<ToggleRemoteDTO, ToggleLocalDTO> {

    override fun convertFromRemoteToLocal(remoteList: List<ToggleRemoteDTO>): List<ToggleLocalDTO> =
        remoteList.map {
            ToggleLocalDTO(
                it.toggleName,
                it.isToggleEnabled
            )
        }
}
