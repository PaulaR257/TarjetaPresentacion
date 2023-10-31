package com.example.tarjetapresentacion

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarjetapresentacion.ui.theme.TarjetaPresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarjetaPresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CartaPresentacion()

                }
            }
        }

    }
}


@Composable
fun CartaPresentacion() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Foto y nombre
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF3ddc84))
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val image = painterResource(R.drawable.mifoto)
            Image(
                painter = image,
                contentDescription = "Foto usuario",
                modifier = Modifier
                    .size(70.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Column {
                Text(
                    text = "Paula Ropero Noguera",
                    fontSize = 30.sp,
                    color = Color.White
                )
                Text(
                    text = "Estudiante",
                    fontSize = 26.sp,
                    color = Color.White
                )
            }
        }

        // Información personal
        Spacer(modifier = Modifier.height(20.dp))

        //Número de teléfono
        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Telefono",
                    tint = Color(0xFF3ddc84),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                BasicTextField(
                    value = TextFieldValue("+34 616 505 033"),
                    onValueChange = { /* Handle value change */ },
                    textStyle = TextStyle(fontSize = 16.sp)
                )
            }

        Spacer(modifier = Modifier.height(20.dp))

        //Instagram
        Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Instagram",
                tint = Color(0xFF3ddc84),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // Enlace a la cuenta de Instagram
            val context = LocalContext.current
            Text(
                text = "Sígueme en Instagram",
                fontSize = 16.sp,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    openInstagramLink(context = context)
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        //Correo electrónico
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email",
                tint = Color(0xFF3ddc84),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            val context = LocalContext.current
            val email = "paula.ropero@educa.madrid.org"

            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    openEmailApp(context = context, emailAddress = email)
                }
            )


        }

        Spacer(modifier = Modifier.height(20.dp))

        //Lugar de residencia
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "País de residencia",
                tint = Color(0xFF3ddc84),
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // Enlace a la cuenta de Instagram
            val context = LocalContext.current
            Text(
                text = "España, Madrid (Pulsa para ver ubicación)",
                fontSize = 16.sp,
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    openGoogleMaps(context = context)
                }
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        //Tarjeta de presentacion detallada en canva
        val image = painterResource(R.drawable.frame)
        Row(
            modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Column {
                Text(text = "Escanear para ver la tarjeta de presentación más detallada")
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = image,
                    contentDescription = "QR",
                    modifier = Modifier
                        .size(125.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }

        }
        Spacer(modifier = Modifier.height(20.dp))

        //Canción favorita
        PlayAudio(context = LocalContext.current)


        //Tarjeta de presentación
        Spacer(modifier = Modifier.weight(1f))
        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Mi Tarjeta de Presentación",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Soy una estudiante de Desarrollo de Aplicaciones Multiplataforma en el Instituto Virgen de la Paloma",
                    fontSize = 18.sp
                )
            }
        }

    }
}


//Abrir instagram
fun openInstagramLink(context: Context) {
    val instagramUri = "https://www.instagram.com/psula_18257/"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUri))
    context.startActivity(intent)
}

//Abrir instagram
fun openGoogleMaps(context: Context) {
    val googleMapsUri = "https://www.google.com/maps/place/IES+Virgen+de+la+Paloma/@40.4588902,-3.7184566,17z/data=!3m1!4b1!4m6!3m5!1s0xd4229b123b4d615:0x7d68ccc162207d2b!8m2!3d40.4588861!4d-3.7158817!16s%2Fg%2F1tf_2ct0?authuser=0&entry=ttu"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUri))
    context.startActivity(intent)
}


//Abrir correo
fun openEmailApp(context: Context, emailAddress: String) {
    val emailIntent = Intent(Intent.ACTION_SEND)
    emailIntent.type = "message/rfc822"
    emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
    context.startActivity(emailIntent)
}


//Poner audio
@Composable
fun PlayAudio(context: Context){
    val mp: MediaPlayer= MediaPlayer.create(context,R.raw.cancionfavorita)
    Column (
        modifier=Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Mi canción favorita",
            fontSize = 25.sp,
        )
        Row {
            IconButton(onClick = { mp.start() },modifier=Modifier.size(35.dp)) {
                Icon(painter = painterResource(id = R.drawable.play), contentDescription = "")
            }
            IconButton(onClick = { mp.pause() },modifier=Modifier.size(35.dp)) {
                Icon(painter = painterResource(id = R.drawable.pause), contentDescription = "")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TarjetaPresentacionTheme {
        CartaPresentacion()
    }
}