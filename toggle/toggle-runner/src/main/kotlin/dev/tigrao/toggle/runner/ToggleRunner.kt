package dev.tigrao.toggle.runner

import dev.tigrao.toggle.core.FeatureToggle

interface ToggleRunner {

    fun isToggleEnabled(featureToggle: FeatureToggle): Boolean
}
