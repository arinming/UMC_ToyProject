package com.example.toyproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface  WordDao {

    // 오름차순으로 정렬된 단어 목록을 반환하는 쿼리
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords() : Flow<List<Word>> // 모든 단어를 가져와서 Words의 List를 반환하도록 하는 메서드

    // onConflict 전략은 이미 목록에 있는 단어와 정확하게 같다면 새 단어를 무시
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word) // 한 단어를 삽입하는 정지 함수를 선언

    @Query("DELETE FROM word_table")
    suspend fun deleteAll() // 모든 단어를 삭제하는 정지 함수를 선언


}