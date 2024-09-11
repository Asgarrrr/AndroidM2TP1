package com.example.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.MangaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MangaDao {

    @Query("SELECT * FROM manga ORDER BY title ASC")
    fun selectAll(): Flow<List<MangaEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(manga: MangaEntity)


    @Query("DELETE FROM manga")
    fun deleteAll()
}
