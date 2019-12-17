package dev.tigrao.toggle.runner.di

import dev.tigrao.toggle.runner.ToggleRunner
import dev.tigrao.toggle.runner.ToggleRunnerImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val toggleRunnerModule = Kodein.Module("toggleRunnerModule") {

    bind<ToggleRunner>() with provider {
        ToggleRunnerImpl(instance())
    }
}
