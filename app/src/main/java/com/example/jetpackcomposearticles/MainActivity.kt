package com.example.jetpackcomposearticles

import android.os.Bundle
import android.provider.Settings.System.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposearticles.ui.theme.JetpackComposeArticlesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeArticlesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WholePage(
                        heading = stringResource(R.string.article_heading),
                        paragraphText1 = stringResource(id = R.string.paragraph_1_text),
                        paragraphText2 = stringResource(id = R.string.paragraph_2_text)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleImage() {
    val pic = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = pic,
        contentDescription = "article image",
//        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TutorialHeading(heading:String) {
    Text(
        text = heading,
        fontSize = 24.sp,
        modifier = Modifier.padding(all = 16.dp)
    )
}

@Composable
fun paragraphOne(paragraphText1:String) {
    Text(
        text = paragraphText1,
        Modifier.padding(start = 16.dp, end = 16.dp),
        //justify.textalign
    )
}

@Composable
fun paragraphTwo(paragraphText2: String) {
    Text(
        text = paragraphText2,
        Modifier.padding(all = 16.dp)
        //justify.textalign
    )
}

@Composable
fun WholePage(heading: String, paragraphText1: String, paragraphText2: String) {
    Column {
        ArticleImage()
        TutorialHeading(heading)
        paragraphOne(paragraphText1)
        paragraphTwo(paragraphText2)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeArticlesTheme {
        WholePage(
            heading = stringResource(R.string.article_heading),
            paragraphText1 = stringResource(id = R.string.paragraph_1_text),
            paragraphText2 = stringResource(id = R.string.paragraph_2_text)
        )
    }
}