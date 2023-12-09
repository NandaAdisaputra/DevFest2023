package com.nandaadisaputra.semarangtourism.injection

import com.nandaadisaputra.semarangtourism.data.repository.SemarangTourismRepository
import com.nandaadisaputra.semarangtourism.data.repository.SemarangTourismRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun provideSemarangTourismRepository(semarangTourismRepositoryImpl: SemarangTourismRepositoryImpl) : SemarangTourismRepository
}