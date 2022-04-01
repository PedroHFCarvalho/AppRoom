package com.example.sqlcomroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table") // Converte classe em uma Entidade
data class User (
    @PrimaryKey(autoGenerate = true) // Determina Id com PK e Gerando automaticamento os valores
    val id: Int,
    var nome: String,
    var sobrenome: String,
    var idade: Int
        ){
}