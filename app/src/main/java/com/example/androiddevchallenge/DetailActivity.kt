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
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {

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
        Text(
            text = "Historia",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp)
        )
        Text(
            text = dog.history,
            style = typography.body1,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}
