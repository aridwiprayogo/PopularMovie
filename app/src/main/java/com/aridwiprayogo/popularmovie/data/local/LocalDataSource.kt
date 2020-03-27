package com.aridwiprayogo.popularmovie.data.local

interface LocalDataSource<Entity> {
    suspend fun saveFavorite(entity: Entity)
    suspend fun getFavorite(): List<Entity>
    suspend fun deleteFavorite(vararg entity: Entity)
}