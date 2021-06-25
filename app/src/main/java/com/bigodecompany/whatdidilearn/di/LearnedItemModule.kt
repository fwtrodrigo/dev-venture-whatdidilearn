package com.bigodecompany.whatdidilearn.di

import com.bigodecompany.whatdidilearn.data.LearnedItemRepository
import com.bigodecompany.whatdidilearn.data.database.LearnedItemDatabase
import com.bigodecompany.whatdidilearn.viewmodel.MainViewModel
import com.bigodecompany.whatdidilearn.viewmodel.NewItemViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LearnedItemModule {
    val module = module {
        factory {
            CoroutineScope(Dispatchers.IO)
        }

        factory {
            LearnedItemRepository(dao = get())
        }

        single {
            LearnedItemDatabase.getDatabase(context = get(), scope = get())
        }

        single {
            get<LearnedItemDatabase>().learnedItemDao()
        }

        viewModel {
            MainViewModel(repository = get())
        }

        viewModel {
            NewItemViewModel(repository = get())
        }
    }
}