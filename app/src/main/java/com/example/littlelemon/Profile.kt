package com.example.littlelemon

import android.content.Context
import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Profile() {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("first_name", "")
    val lastName = sharedPreferences.getString("last_name", "")
    val email = sharedPreferences.getString("email", "")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFFEDEFEE)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(width = 150.dp, height = 100.dp)
                .scale(1.5f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp, horizontal = 8.dp)
        ) {
            Text(
                text = "Personal Information",
                textAlign = TextAlign.Left,
                color = Color(0xFF333333),
                fontWeight = FontWeight(700),
                fontSize = 24.sp,
                fontFamily = FontFamily(
                    Font(R.font.markazi_text))
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
        ) {

            Text(
                text = "First Name",
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                ,
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                fontSize = 14.sp,
            )

            Text(
                text = firstName ?: "First Name",
                modifier = Modifier
                    .padding(8.dp)
                    .border(border = BorderStroke(1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                        )
                    .padding(12.dp)

                ,
                fontFamily = FontFamily(
                        Font(R.font.markazi_text)),
                fontSize = 24.sp,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {

            Text(text = "Last Name",
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                fontSize = 14.sp,

                )

            Text(
                text = lastName ?: "First Name",
                modifier = Modifier
                    .padding(8.dp)
                    .border(border = BorderStroke(1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)

                ,
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                fontSize = 24.sp,
            )


        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
        ) {

            Text(text = "Email",
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                fontSize = 14.sp,
            )

            Text(
                text = email ?: "First Name",
                modifier = Modifier
                    .padding(8.dp)
                    .border(border = BorderStroke(1.dp, color = Color.Gray),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)

                ,
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                fontSize = 24.sp,
            )


        }

        Button(
            onClick = {
                val sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.clear()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    editor.apply()
                }
            },
            modifier = Modifier
                .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
            ,
            shape = RoundedCornerShape(size = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF4CE14))
        ) {
            Text("Log out",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.markazi_text)),
                color = Color(0xFF1E1E1E),
                fontWeight = FontWeight(300)
            )
        }

    }
}

@Composable
@Preview
fun ProfilePreview() {
    Profile()
}