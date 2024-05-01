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
import androidx.compose.ui.res.colorResource
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
                    modifier = Modifier.fillMaxSize()
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
            .background(color = colorResource(id = R.color.Base_deep_blue))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Logo
        Image(painter = logo, contentDescription = "Bintina Bytes Logo")
        //Name
        Text(
            text = name,
            color = colorResource(id = R.color.purple_swerve),
            modifier = modifier,
            fontSize = 50.sp
        )
        //Title
        Text(text = stringResource(R.string.title),
        color = colorResource(id = R.color.purple_swerve))
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
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //Phone Row
        Row(modifier = modifier
            .padding(15.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Phone icon",
                tint = colorResource(id = R.color.deeper_pink),
                modifier = Modifier.height(40.dp)


            )
            Text(
                phoneNumber,
                color = colorResource(id = R.color.triad_baby_pink),
                fontSize = 20.sp
            )
        }
        //Email Row
        Row(modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Email icon",
                tint = colorResource(id = R.color.deeper_pink),
                modifier = Modifier.height(40.dp)

            )
            Text(email,
                color = colorResource(id = R.color.triad_baby_pink),
                fontSize = 20.sp
            )
        }
        //Website Row
        Row(modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(webUrl,
                color = colorResource(id = R.color.triad_baby_pink),
                fontSize = 30.sp
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