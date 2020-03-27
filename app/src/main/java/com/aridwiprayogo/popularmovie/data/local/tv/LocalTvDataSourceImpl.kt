package com.aridwiprayogo.popularmovie.data.local.tv

import com.aridwiprayogo.popularmovie.data.local.LocalDataSource

class LocalTvDataSourceImpl(private val tvDao: TvDao): LocalTvDataSource {
    override suspend fun saveFavorite(entity: TvEntity) {
        tvDao.saveTv(entity)
    }

    override suspend fun getFavorite(): List<TvEntity> {
        return tvDao.getTv()
    }

    override suspend fun deleteFavorite(vararg entity: TvEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface LocalTvDataSource: LocalDataSource<TvEntity> {

}
