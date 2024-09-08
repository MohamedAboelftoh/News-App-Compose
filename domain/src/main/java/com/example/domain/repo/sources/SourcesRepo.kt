package com.example.domain.repo.sources

import com.example.domain.model.Source

interface SourcesRepo {
    suspend fun getSourcesList(category : String) : List<Source>
}