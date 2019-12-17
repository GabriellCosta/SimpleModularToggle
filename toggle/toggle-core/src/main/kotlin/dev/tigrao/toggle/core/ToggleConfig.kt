package dev.tigrao.toggle.core

interface ToggleConfig {

    fun isToggleEnabled(featureToggle: FeatureToggle): Boolean
}
