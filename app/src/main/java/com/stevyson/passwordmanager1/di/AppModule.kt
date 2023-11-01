package com.stevyson.passwordmanager1.di

import android.app.Application
import androidx.room.Room
import com.stevyson.passwordmanager1.data.data_source.PasswordDatabase
import com.stevyson.passwordmanager1.data.repostory.PasswordRepositoryImpl
import com.stevyson.passwordmanager1.domain.repository.PasswordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePasswordDatabase(app: Application): PasswordDatabase{
        return Room.databaseBuilder(
            app,
            PasswordDatabase::class.java,
            PasswordDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePasswordRepository(db: PasswordDatabase): PasswordRepository {
        return PasswordRepositoryImpl(db.passwordDao)
    }

}