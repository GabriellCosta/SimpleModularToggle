package dev.tigrao.toggle.service.di

import androidx.room.Room
import dev.tigrao.toggle.core.ToggleConfig
import dev.tigrao.toggle.service.ToggleDtoConverter
import dev.tigrao.toggle.service.ToggleDtoConverterImpl
import dev.tigrao.toggle.service.config.ToggleConfigDatabaseConfig
import dev.tigrao.toggle.service.local.ToggleDao
import dev.tigrao.toggle.service.local.ToggleDb
import dev.tigrao.toggle.service.local.ToggleLocalDTO
import dev.tigrao.toggle.service.local.ToggleLocalDataSource
import dev.tigrao.toggle.service.remote.ToggleRemoteDTO
import dev.tigrao.toggle.service.remote.ToggleRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

private const val TOGGLE_DB = "toggle.db"

val toggleServiceModule = Kodein.Module("toggleServiceModule") {

    bind<ToggleConfig>() with provider {
        ToggleConfigDatabaseConfig(instance())
    }

    bind<ToggleDb>() with singleton {
        Room.databaseBuilder(
            instance(), ToggleDb::class.java,
            TOGGLE_DB
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .openHelperFactory(instance())
            .build()
    }

    bind<ToggleDao>() with singleton {
        instance<ToggleDb>().toggleDao()
    }

    bind() from provider {
        ToggleRepository(instance(), instance())
    }

    bind<ToggleDtoConverter<ToggleRemoteDTO, ToggleLocalDTO>>() with provider {
        ToggleDtoConverterImpl()
    }

    bind() from provider {
        ToggleLocalDataSource(
            instance(),
            instance()
        )
    }
}
