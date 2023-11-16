package com.bintina.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bintina.composebusinesscard.ui.theme.ComposeBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan
                ) {
                    BusinessCard("Android")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    val logo = painterResource(id = R.drawable.free_sample_by_wix)
    Column(
        modifier = Modifier
            .background(color = Color(R.color.teal_700)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = logo, contentDescription = "Bintina Bytes Logo")
        Text(
            text = name,
            modifier = modifier
        )
        Text(text = stringResource(R.string.title))
        Contacts(
            "+254 721 259 484",
            "binti@bintinabytes.com", "www.bintinabytes.com", modifier
        )
    }
}

@Composable
fun Contacts(phoneNumber: String, email: String, webUrl: String, modifier: Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Row(modifier = modifier
            .padding(15.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Phone icon",
                tint = Color(R.color.teal_700),
                modifier = Modifier.height(40.dp)

            )
            Text(
                phoneNumber,
                fontSize = 10.sp
            )
        }
        Row(modifier = modifier,
            horizontalArrangement = Arrangement.Center

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Email icon",
                modifier = Modifier.height(40.dp)

            )
            Text(email,
                fontSize = 10.sp
            )
        }
        Row(modifier = modifier,
            horizontalArrangement = Arrangement.Center

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Web icon",
                Modifier.height(40.dp)
            )
            Text(webUrl,
                fontSize = 10.sp
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    ComposeBusinessCardTheme {
        BusinessCard("Bintina Tamar")
    }
}