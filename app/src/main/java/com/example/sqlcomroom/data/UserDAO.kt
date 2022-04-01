package com.example.sqlcomroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sqlcomroom.model.User

@Dao
interface UserDAO {

    // Função De Insert
    @Insert(onConflict =  OnConflictStrategy.IGNORE) // Chama o Insert ignorando valores repetidos
    fun addUser(user: User)

    // Função de Listar
    @Query("SELECT * FROM user_table ORDER BY id ASC") // Chama a linha de SQL
    fun lerTodosOsDados(): LiveData<List<User>>


}