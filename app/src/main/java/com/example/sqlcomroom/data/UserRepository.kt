package com.example.sqlcomroom.data

import androidx.lifecycle.LiveData
import com.example.sqlcomroom.model.User


class UserRepository(private val userDAO: UserDAO) {


    // Lista os usuarios
    val  lerTodosOsDados: LiveData<List<User>> = userDAO.lerTodosOsDados()

    // Adiciona os usuarios
    fun addUser(user: User){
        userDAO.addUser(user)
    }

}