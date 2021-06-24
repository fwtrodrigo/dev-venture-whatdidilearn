package com.bigodecompany.whatdidilearn

import android.app.Application
import com.bigodecompany.whatdidilearn.data.LearnedItemRepository
import com.bigodecompany.whatdidilearn.data.database.LearnedItemDatabase
import com.bigodecompany.whatdidilearn.di.LearnedItemModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WhatDidILearnApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatDidILearnApplication)
            modules(LearnedItemModule.module)
        }
    }
}