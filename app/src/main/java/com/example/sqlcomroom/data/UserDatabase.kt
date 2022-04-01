package com.example.sqlcomroom.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sqlcomroom.model.User

// Classe que cria o Banco de dados Local
// Configura o banco de dados
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDAO(): UserDAO

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        // Retorna o banco de dados
        fun getDatabase(context: Context): UserDatabase {
            val tempoInstance = INSTANCE
            if (tempoInstance != null) { // Verifica se ja á um banco de dados criado
                return tempoInstance
            } else {
                synchronized(this) { // Utiliza uma thread secundaria
                    // Cria o banco de dados
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"
                    ).build()
                    INSTANCE = instance
                    return instance
                }
            }
        }
    }

}