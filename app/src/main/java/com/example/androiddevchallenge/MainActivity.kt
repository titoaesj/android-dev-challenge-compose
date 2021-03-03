/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LifecycleOwner
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {

    val dogViewModel by viewModels<DogViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                Column {
                    HeadComp()
                    LazyColumn(
                        contentPadding = PaddingValues(bottom = 80.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(dogViewModel.dogs) { dog ->
                            CardItemComp(dog, this@MainActivity)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun LogoComp() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
            contentDescription = "logo pet adoption"
        )
        Text(
            text = stringResource(id = R.string.app_name),
            Modifier.padding(top = 8.dp),
            style = typography.h5
        )
    }
}

@Composable
fun HeadComp() {
    Card(
        Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.2f),
        elevation = 4.dp
    ) {
        LogoComp()
    }
}

//@Preview("CardItemComp", widthDp = 379, heightDp = 175)

@Composable
fun infoDogComp(dog: Dog?) {
    Column {

        Text(
            text = dog?.name.toString(),
            Modifier.padding(start = 8.dp, top = 16.dp, end = 8.dp),
            style = typography.h6
        )

        Row(Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)) {
            Text(text = "Oigem:", Modifier.padding(end = 8.dp),style = typography.caption)
            Text(text = dog?.origin.toString())
        }

        Row(Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)) {
            Text(text = "Peso:", Modifier.padding(end = 8.dp),style = typography.caption)
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_male),
                contentDescription = "male icon"
            )
            Text(text = dog?.weightMale.toString(), Modifier.padding(end = 4.dp),style = typography.body1)
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_female),
                contentDescription = "female icon"
            )
            Text(text = dog?.weightFamale.toString(),style = typography.body1)
        }

        Row(Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 16.dp)) {
            Text(text = "Altura:", Modifier.padding(end = 8.dp),style = typography.caption)
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_male),
                contentDescription = "male icon"
            )
            Text(text = dog?.heightMale.toString(), Modifier.padding(end = 4.dp),style = typography.body1)
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_female),
                contentDescription = "female icon"
            )
            Text(text = dog?.heightFemale.toString(),style = typography.body1)
        }

    }
}

@Composable
fun CardItemComp(dog: Dog?, activity: Activity) {

    Card(
        Modifier
            .fillMaxWidth(1f)
            .padding(16.dp)
            .clickable {

                val intent = Intent(activity.applicationContext, DetailActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable("dog_param", dog)
                intent.putExtras(bundle)
                activity.startActivity( intent )

            },
        elevation = 4.dp
    ) {

        Row() {

            Image(
                painter = painterResource(id = dog?.image!!),
                contentDescription = "image card item",
                Modifier
                    .fillMaxWidth(0.28f)
                    .background(color = Color.Green, shape = RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Inside
            )

            infoDogComp(dog = dog)

        }


    }

}


//@Preview("Light Theme", widthDp = 411, heightDp = 731)
//@Composable
//fun LightPreview() {
//    MyTheme {
//        MyApp(viewModel = null, null)
//    }
//}

//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}
