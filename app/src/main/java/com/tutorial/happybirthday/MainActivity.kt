package com.tutorial.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutorial.happybirthday.ui.theme.ColumnColor
import com.tutorial.happybirthday.ui.theme.HappyBirthdayTheme
import com.tutorial.happybirthday.ui.theme.ImageColor
import com.tutorial.happybirthday.ui.theme.Purple40
import com.tutorial.happybirthday.ui.theme.RowColor
import com.tutorial.happybirthday.ui.theme.TextColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuadrantsView(
                        tit1 = stringResource(id = R.string.text_title),
                        descr1 = stringResource(id = R.string.text_description),
                        tit2 = stringResource(id = R.string.image_title),
                        descr2 = stringResource(id = R.string.image_description),
                        tit3 = stringResource(id = R.string.row_title),
                        descr3 = stringResource(id = R.string.row_description),
                        tit4 = stringResource(id = R.string.column_title),
                        descr4 = stringResource(id = R.string.column_description)
                    )

                }

            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun ArticleView(title: String, intro: String, description: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = title,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = intro,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

}

@Composable
fun TaskManagerView(tasks: String, message: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = tasks,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = message,
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    color: Color = TextColor,
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
fun QuadrantsView(
    tit1: String,
    descr1: String,
    tit2: String,
    descr2: String,
    tit3: String,
    descr3: String,
    tit4: String,
    descr4: String, modifier: Modifier = Modifier
) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = tit1,
                description = descr1,
                color = TextColor,
                modifier = Modifier.weight(1f),
            )
            Quadrant(
                title = tit2,
                description = descr2,
                color = ImageColor,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            Quadrant(
                title = tit3,
                description = descr3,
                color = RowColor,
                modifier = Modifier.weight(1f)
            )
            Quadrant(
                title = tit4,
                description = descr4,
                color = ColumnColor,
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrant() {
    HappyBirthdayTheme {
        QuadrantsView(
            tit1 = stringResource(id = R.string.text_title),
            descr1 = stringResource(id = R.string.text_description),
            tit2 = stringResource(id = R.string.image_title),
            descr2 = stringResource(id = R.string.image_description),
            tit3 = stringResource(id = R.string.row_title),
            descr3 = stringResource(id = R.string.row_description),
            tit4 = stringResource(id = R.string.column_title),
            descr4 = stringResource(id = R.string.column_description),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RowQuadrants() {
    Row (Modifier.fillMaxSize()){
        Text(text = stringResource(id = R.string.text_description), Modifier.background(TextColor).weight(1f))
        Text(text = stringResource(id = R.string.image_description),Modifier.background(ImageColor).weight(1f))

    }
}

//@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(id = R.string.happy_birthday_text),
            from = stringResource(id = R.string.signature_text)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    HappyBirthdayTheme {
        ArticleView(
            stringResource(id = R.string.title_article),
            stringResource(id = R.string.description),
            stringResource(id = R.string.description_2)
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    HappyBirthdayTheme {
        TaskManagerView(
            tasks = stringResource(id = R.string.tasks),
            message = stringResource(id = R.string.message),
            modifier = Modifier.fillMaxSize()
        )
    }
}

