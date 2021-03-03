package com.example.androiddevchallenge

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dog: Dog? = intent.extras?.getParcelable<Dog>("dog_param")
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                headDetailComp(activity = this, dog!!)
            }
        }
    }
}

@Composable
fun headDetailComp(activity: Activity, dog: Dog) {
    Column {

        Box(modifier = Modifier.fillMaxWidth()
            .fillMaxHeight(0.4f)) {

                Image(
                    painter = painterResource(id = dog.image),
                    contentDescription = "image detail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )


            Box(modifier = Modifier.padding(start = 16.dp, top = 16.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_black),
                    contentDescription = "icon back to home",
                    modifier = Modifier
                        .size(32.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(4.dp))
                        .padding(7.dp)
                        .clickable {
                            activity.onBackPressed()
                        }

                )
            }

        }

        infoDogComp(dog)
        historyComp(dog)
    }
}

@Composable
fun historyComp(dog: Dog) {
    Column {
        Text(text = "Historia", style = typography.caption, modifier = Modifier.padding(start = 8.dp))
        Text(text = dog.history, style = typography.body1, modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp), textAlign = TextAlign.Justify)
    }
}