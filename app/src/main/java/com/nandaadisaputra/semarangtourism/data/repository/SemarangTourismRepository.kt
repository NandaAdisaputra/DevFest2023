package com.nandaadisaputra.semarangtourism.data.repository

import com.nandaadisaputra.semarangtourism.data.model.SemarangTourismModel
import kotlinx.coroutines.flow.Flow

interface SemarangTourismRepository {
    fun getTourismPlaceById(id: Int): Flow<SemarangTourismModel>

    fun getSemarangTourism(): Flow<List<SemarangTourismModel>>

    fun searchSemarangTourism(query: String): Flow<List<SemarangTourismModel>>

}