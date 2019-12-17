package dev.tigrao.toggle.core

sealed class AbstractFeatureToggle(override val name: String) :
    FeatureToggle

object Feature1 : AbstractFeatureToggle("Feature1-from-server")

object Feature2 : AbstractFeatureToggle("Feature2-from-server")

object Feature3 : AbstractFeatureToggle("Feature3-from-server")
