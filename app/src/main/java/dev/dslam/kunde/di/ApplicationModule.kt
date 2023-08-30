package dev.dslam.kunde.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dev.dslam.kunde.model.db.AppDatabase
import dev.dslam.kunde.model.db.TaskDao
import org.koin.dsl.module

private const val DATABASE_NAME = "app_database"

val appModule = module {
    single { provideAppDatabase(provideAppContext(get())) }
    single { provideTaskDao(get()) }
}

private fun provideAppDatabase(context: Context) =
    Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        DATABASE_NAME
    ).build()

private fun provideTaskDao(appDatabase: AppDatabase): TaskDao {
    return appDatabase.taskDao()
}

private fun provideAppContext(application: Application) = application