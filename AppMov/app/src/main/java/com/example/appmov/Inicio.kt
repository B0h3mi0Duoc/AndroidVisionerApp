package com.example.appmov

import androidx.compose.foundation.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appmov.ui.theme.AppMovTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle

@Composable
fun InicioScreen( // *** SCREEN PRINCIPAL ***
    onComenzarClick: () -> Unit = {}, // >>CALLBACK<< to registro
    onLoginClick: () -> Unit = {}// >>CALLBACK<< to login
) {
    Box(
                modifier = Modifier.fillMaxSize()
                ) { //////////////Inicio del BOX//////////////////

            // Imagen de fondo ------------------------------
            Image(
                painter = painterResource(id = R.drawable.fondo_dif), // coloca tu imagen en res/drawable
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )


        // Contenedor inferior con BOTONES ["COMENZAR LA EXPERIENCIA"] -- ["YA TENGO UNA CUENTA"] ---------------------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Encabezado
            Text(
                "Inicia la Experiencia Visioner ",
                fontSize = 35.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,

                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            Button( // boton "COMENZAR LA EXPERIENCIA"
                onClick = onComenzarClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Comenzar",
                    fontSize = 25.sp
                )

            }// boton "COMENZAR LA EXPERIENCIA"

            Button( // boton "YA TENGO UNA CUENTA"
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Ya tengo una cuenta",
                    fontSize = 25.sp
                )
            }// boton "YA TENGO UNA CUENTA"
        }
    } //////////////Fin del BOX//////////////////
}
@Preview(showBackground = true, showSystemUi = true) // PREVIEW DE LA PANTALLA DE INICIO <<<<<<<<<
@Composable
fun PreviewInicio() {
    AppMovTheme {
        InicioScreen()
    }
}