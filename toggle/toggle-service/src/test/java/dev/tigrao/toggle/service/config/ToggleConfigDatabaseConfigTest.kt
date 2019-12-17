package dev.tigrao.toggle.service.config

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.odete.toggle.core.FeatureToggle
import com.odete.toggle.service.local.ToggleDao
import com.odete.toggle.service.local.ToggleLocalDTO
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ToggleConfigDatabaseConfigTest {

    @Test
    fun givenToggle_ThatExistsConformDAO_ShouldReturnTrue() {
        val featureToggle = mock<FeatureToggle>()
        val toggleDao = mock<ToggleDao> {
            on { getToggleByFeature(featureToggle.name) } doReturn ToggleLocalDTO("feature", true)
        }
        val config = ToggleConfigDatabaseConfig(toggleDao)

        val result = config.isToggleEnabled(featureToggle)

        assertTrue(result)
    }

    @Test
    fun givenToggle_ThatExistsConformDAO_ShouldReturnFalse() {
        val featureToggle = mock<FeatureToggle>()
        val toggleDao = mock<ToggleDao> {
            on { getToggleByFeature(featureToggle.name) } doReturn ToggleLocalDTO("feature", false)
        }
        val config = ToggleConfigDatabaseConfig(toggleDao)

        val result = config.isToggleEnabled(featureToggle)

        assertFalse(result)
    }

    @Test
    fun givenToggle_ThatDoesNotExistConformDAO_ShouldReturnFalse() {
        val featureToggle = mock<FeatureToggle>()
        val toggleDao = mock<ToggleDao>()
        val config = ToggleConfigDatabaseConfig(toggleDao)

        val result = config.isToggleEnabled(featureToggle)

        assertFalse(result)
    }

    @Test
    fun givenToggle_DAOShouldUseIt() {
        val featureKey = "feature"
        val featureToggle = mock<FeatureToggle>() {
            on { name } doReturn featureKey
        }
        val toggleDao = mock<ToggleDao>()
        val config = ToggleConfigDatabaseConfig(toggleDao)

        config.isToggleEnabled(featureToggle)

        verify(toggleDao).getToggleByFeature(featureKey)
    }
}
