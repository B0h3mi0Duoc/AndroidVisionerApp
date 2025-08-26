package com.example.appmov

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var error by remember { mutableStateOf("") }
            NavHost(
                navController = navController,
                startDestination = Routes.inicio
            ){
                composable( Routes.inicio){
                    InicioScreen(
                        onComenzarClick = {navController.navigate(Routes.registro)},
                        onLoginClick = {navController.navigate(Routes.login)}
                    )
                }
                composable( Routes.login){

                    LoginScreen(
                        error = error,
                        onLoginHomeClick ={ correo, password ->
                            println("evaluando datos del usuario : " + correo + password)
                            if (UserRepository.validarLogin(correo, password)) {
                                error = ""
                                navController.navigate(Routes.loginHome) {
                                    popUpTo(Routes.login) { inclusive = true }
                                }
                            } else {
                                println(UserRepository.validarLogin(correo, password))
                                println("Usuario incorrecto" + correo + password)
                                error = "Correo o contraseña incorrectos"
                            }
                        }
                    )
                }
                composable(Routes.registro){
                    RegistroScreen { nombre, correo, password, pais ->
                        val newUser = User(
                            nombre = nombre,
                            correo = correo,
                            password = password,
                            pais = pais
                        )
                        println(newUser)
                        UserRepository.registrarUser(newUser)

                        navController.navigate(Routes.login) {
                            popUpTo("registro") { inclusive = true }
                        }
                    }
                }
                composable(Routes.loginHome){
                    LoginHomeScreen()
                }
            }

        }
    }
}



