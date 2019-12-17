package dev.tigrao.toggle.runner

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import dev.tigrao.toggle.core.FeatureToggle
import dev.tigrao.toggle.core.ToggleConfig
import org.junit.Test

class ToggleRunnerImplTest {

    @Test
    fun givenAFeatureToggle_WithToggleConfig_ShouldExecuteToggleConfig() {
        val toggleConfig = mock<ToggleConfig>()
        val featureToggle = mock<FeatureToggle>()
        val runner = ToggleRunnerImpl(toggleConfig)

        runner.isToggleEnabled(featureToggle)

        verify(toggleConfig).isToggleEnabled(featureToggle)
    }
}
