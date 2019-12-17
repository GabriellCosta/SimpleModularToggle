package dev.tigrao.toggle.service.remote

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.odete.toggle.service.local.ToggleLocalDataSource
import org.junit.Test
import retrofit2.Response

class ToggleRepositoryTest {

    private val apiMock = mock<ToggleApi>()
    private val responseMock = mock<Response<List<ToggleRemoteDTO>>>()

    private val toggleLocalDataSource = mock<ToggleLocalDataSource>()
    private val targetRepository = ToggleRepository(apiMock, toggleLocalDataSource)

    @Test
    fun whenCallFetchTogglesFromRemote_shouldValidateCorrectApiCall() {

        whenever(apiMock.getToggleTree()).thenReturn(mock())

        targetRepository.fetchTogglesFromRemote()

        verify(apiMock).getToggleTree()
    }

    @Test
    fun whenSuccessResponse_shouldUseLocalDataSourceToSaveToggles() {

        mockSuccess()

        targetRepository.onResponse(mock(), responseMock)

        verify(toggleLocalDataSource).saveLocal(any())
    }

    @Test
    fun whenSuccessResponse_shouldUseLocalDataSourceToSaveTogglesWithGivenParameters() {

        mockSuccess()

        targetRepository.onResponse(mock(), responseMock)

        verify(toggleLocalDataSource).saveLocal(responseMock.body())
    }

    @Test
    fun whenNotSuccessResponse_shouldNotCallLocalDataSource() {

        targetRepository.onResponse(mock(), responseMock)

        verify(toggleLocalDataSource, never()).saveLocal(any())
    }

    private fun mockSuccess() {
        whenever(responseMock.isSuccessful).doReturn(true)
        whenever(responseMock.body()).doReturn(mockRemoteDtoList())
    }

    private fun mockRemoteDtoList() = listOf(
        ToggleRemoteDTO("Test1", true),
        ToggleRemoteDTO("Test2", false)
    )
}
