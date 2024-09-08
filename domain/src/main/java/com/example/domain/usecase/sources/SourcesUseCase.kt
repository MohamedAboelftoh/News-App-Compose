package com.example.domain.usecase.sources

import com.example.domain.model.Source
import com.example.domain.repo.sources.SourcesRepo
import javax.inject.Inject

class SourcesUseCase @Inject constructor(
    private val sourcesRepo: SourcesRepo
) {
    suspend fun getSources(category: String):List<Source>{
        return sourcesRepo.getSourcesList(category)
    }
}