package dev.tigrao.toggle.runner

import dev.tigrao.toggle.core.FeatureToggle
import dev.tigrao.toggle.core.ToggleConfig

internal class ToggleRunnerImpl(
    private val toggleConfig: ToggleConfig
) : ToggleRunner {

    override fun isToggleEnabled(featureToggle: FeatureToggle): Boolean =
        toggleConfig.isToggleEnabled(featureToggle)
}
