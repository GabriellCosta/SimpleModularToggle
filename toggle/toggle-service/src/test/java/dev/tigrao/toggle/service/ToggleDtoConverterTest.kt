package dev.tigrao.toggle.service

import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.odete.toggle.service.local.ToggleLocalDTO
import com.odete.toggle.service.remote.ToggleRemoteDTO
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Test

private const val DEFAULT_LIST_SIZE = 2

class ToggleDtoConverterTest {

    private val converter = ToggleDtoConverterImpl()

    @Test
    fun whenCallConvert_shouldReturnListWithSameOriginalSize() {

        val response = converter.convertFromRemoteToLocal(mockRemoteDtoList())

        assertEquals(DEFAULT_LIST_SIZE, response.size)
    }

    @Test
    fun givenRemoteDTOList_whenCallConvert_shouldReturnListWithLocalDtoType() {

        val response = converter.convertFromRemoteToLocal(mockRemoteDtoList())

        assertThat(response.first(), instanceOf(ToggleLocalDTO::class.java))
    }

    @Test
    fun givenRemoteDTOList_whenCallConvert_shouldValidateCorrectKeyConversion() {

        val response = converter.convertFromRemoteToLocal(mockRemoteDtoList())

        assertEquals("Test1", response.first().featureKey)
    }

    @Test
    fun givenRemoteDTOList_whenCallConvert_shouldValidateCorrectValueConversion() {

        val response = converter.convertFromRemoteToLocal(mockRemoteDtoList())

        assertEquals(true, response.first().isEnabled)
    }

    private fun mockRemoteDtoList() = listOf(
        ToggleRemoteDTO("Test1", true),
        ToggleRemoteDTO("Test2", false)
    )
}
