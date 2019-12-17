package dev.tigrao.toggle.service

internal interface ToggleDtoConverter<in I, out O> {

    fun convertFromRemoteToLocal(remoteList: List<I>): List<O>
}
