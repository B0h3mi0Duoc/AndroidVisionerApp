package com.example.appmov

object UserRepository {
    val usuarios = mutableListOf<User>()

    fun registrarUser(user: User) {
        usuarios.add(user)
    }
    fun validarLogin(correo:String, password: String): Boolean {
        return usuarios.any {it.correo == correo && it.password == password}
    }
}