package com.pisiitech.sayfaaltyapilari

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pisiitech.sayfaaltyapilari.ui.theme.SayfaAltYapilariTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayfaAltYapilariTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationBarSayfa()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarSayfa() {
    val items = listOf("Bir","Iki")
    val secilenItem = remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Baslik")})
        },
        content = {
            if(secilenItem.value == 0) {
                Sayfa1()
            }

            if(secilenItem.value == 1) {
                Sayfa2()
            }
        },

        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(selected = secilenItem.value == index ,
                        onClick = { secilenItem.value = index},
                        label = { Text(text = item)},
                        icon = {
                            when(item) {
                                "Bir" -> Icon(painter = painterResource(id = R.drawable.resim1), contentDescription ="" )
                                "Iki" -> Icon(painter = painterResource(id = R.drawable.resim2), contentDescription ="" )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue,
                            unselectedIconColor = Color.Gray,
                            selectedTextColor = Color.Blue,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Yellow
                        )
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayfaAltYapilariTheme {
        NavigationBarSayfa()
    }
}