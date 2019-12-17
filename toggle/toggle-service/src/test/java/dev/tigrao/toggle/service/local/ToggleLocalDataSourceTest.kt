package dev.tigrao.toggle.service.local

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.odete.toggle.service.ToggleDtoConverter
import com.odete.toggle.service.remote.ToggleRemoteDTO
import org.junit.Test

class ToggleLocalDataSourceTest {

    @Test
    fun whenToggleTreeIsNull_ShouldNotDeleteToggles() {
        val toggleDao = mock<ToggleDao>()
        val dataSource = ToggleLocalDataSource(toggleDao, mock())

        dataSource.saveLocal(null)

        verify(toggleDao, never()).deleteToggles()
    }

    @Test
    fun whenToggleTreeIsNull_ShouldNotSaveToggles() {
        val toggleDao = mock<ToggleDao>()
        val dataSource = ToggleLocalDataSource(toggleDao, mock())

        dataSource.saveLocal(null)

        verify(toggleDao, never()).saveToggleTree(any())
    }

    @Test
    fun whenToggleTreeIsEmpty_ShouldDeleteToggles() {
        val toggleDao = mock<ToggleDao>()
        val dataSource = ToggleLocalDataSource(toggleDao, mock())

        dataSource.saveLocal(emptyList())

        verify(toggleDao).deleteToggles()
    }

    @Test
    fun whenToggleTreeIsEmpty_ShouldNotSaveToggles() {
        val toggleDao = mock<ToggleDao>()
        val dataSource = ToggleLocalDataSource(toggleDao, mock())

        dataSource.saveLocal(emptyList())

        verify(toggleDao, never()).saveToggleTree(any())
    }

    @Test
    fun givenNonEmptyToggleTree_ShouldSaveWithDAO() {
        val toggleDao = mock<ToggleDao>()
        val dataSource = ToggleLocalDataSource(toggleDao, mock())

        dataSource.saveLocal(listOf(ToggleRemoteDTO("feature", false)))

        verify(toggleDao).saveToggleTree(any())
    }

    @Test
    fun givenNonEmptyToggleTree_ShouldSaveWithDAOWithConvertedValue() {
        val toggleDao = mock<ToggleDao>()
        val toggleDtoConverter = mock<ToggleDtoConverter<ToggleRemoteDTO, ToggleLocalDTO>>()
        val dataSource = ToggleLocalDataSource(toggleDao, toggleDtoConverter)
        val toggleTree = listOf(ToggleRemoteDTO("feature", false))

        dataSource.saveLocal(toggleTree)

        verify(toggleDtoConverter).convertFromRemoteToLocal(toggleTree)
    }
}
