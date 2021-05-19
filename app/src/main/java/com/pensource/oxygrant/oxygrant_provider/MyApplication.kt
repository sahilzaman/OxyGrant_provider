package com.pensource.oxygrant.oxygrant_provider

import android.app.Application
import com.pensource.oxygrant.oxygrant_provider.data.firebase.FirebaseSource
import com.pensource.oxygrant.oxygrant_provider.data.repositories.UserRepository
import com.pensource.oxygrant.oxygrant_provider.ui.auth.AuthViewModelFactory
import com.pensource.oxygrant.oxygrant_provider.ui.home.HomeViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication: Application(), KodeinAware {

    override val kodein = Kodein.lazy{
        import(androidXModule(this@MyApplication))

        bind() from singleton { FirebaseSource() }
        bind() from singleton { UserRepository(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
    }
}