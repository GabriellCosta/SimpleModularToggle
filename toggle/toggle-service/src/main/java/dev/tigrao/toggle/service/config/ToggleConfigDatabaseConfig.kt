package dev.tigrao.toggle.service.config

import dev.tigrao.toggle.core.FeatureToggle
import dev.tigrao.toggle.core.ToggleConfig
import dev.tigrao.toggle.service.local.ToggleDao

internal class ToggleConfigDatabaseConfig(
    private val toggleDao: ToggleDao
) : ToggleConfig {

    override fun isToggleEnabled(featureToggle: FeatureToggle): Boolean =
        toggleDao.getToggleByFeature(featureToggle.name)?.isEnabled ?: false
}
