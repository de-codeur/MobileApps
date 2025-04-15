package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.navigation.MovieNavigation
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppTheme {
//                Column {
//                    TopHeader()
//                    MovieApp()
//                }
MovieNavigation()
            }
        }
    }
}
@Composable
fun MovieApp(movieList: List<String> =listOf("Hello","High Guys","Don't Worry"),navController: NavController){
   Column(modifier = Modifier.padding(4.dp)) {
       LazyColumn {
           items(items = movieList) {
               MovieRow(movie =it ){
navController.navigate(route= "DetailScreen")
               }

           }
       }
   }

}

@Composable
fun MovieRow(movie: String,onclick:(String)->Unit){
    Card(modifier = Modifier
        .clickable{
            onclick(movie)
        }
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp),
        shape= RoundedCornerShape(corner = CornerSize(12.dp)),
        elevation = CardDefaults.cardElevation(6.dp)

    ){
        Row(
          horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp)

                ,
                shape = CircleShape,
                shadowElevation = 4.dp

            ){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription ="Movie Icon" )
            }

            Text(text = movie)
        }
        }



}
@Composable
fun TopHeader() {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp),
        color = Color(0xFFE9D7F7),
        shape=CircleShape.copy(CornerSize(12.dp))

    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "MOVIES",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold
            )

        }
    }}
            @Preview
@Composable
fun CodingPreview(){
    MovieAppTheme {
        Column {
            TopHeader()
           // MovieApp()
        }

    }
}