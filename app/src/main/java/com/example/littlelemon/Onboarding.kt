package com.example.littlelemon

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
import androidx.navigation.NavController

@Composable
fun Onboarding(navController: NavController){
    val context = LocalContext.current
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
                .size(120.dp)
                .background(color = Color(0xFF495E57))
        ) {
            Text(
                text = "Let's get to know you",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(Alignment.CenterVertically)
                ,
                fontSize = 32.sp,
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                textAlign = TextAlign.Center,
                color = Color(0xFFEDEFEE)
            )
        }

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



        val firstNameState = remember { mutableStateOf("") }
        val lastNameState = remember { mutableStateOf("") }
        val emailState = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
        ) {

            Text(
                text = "First Name",
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                fontFamily = FontFamily(
                    Font(R.font.markazi_text)),
                fontSize = 14.sp,
            )
            
            OutlinedTextField(
                value = firstNameState.value,
                onValueChange = { firstNameState.value = it },
                label = { Text("First Name") },
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .fillMaxWidth(),

                shape = RoundedCornerShape(8.dp),
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

            OutlinedTextField(
                value = lastNameState.value,
                onValueChange = { lastNameState.value = it },
                label = { Text("Last Name") },
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
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

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                label = { Text("Email") },
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
        }

        Button(
            onClick = {

                val allFieldsFilled = firstNameState.value.isNotBlank() &&
                        lastNameState.value.isNotBlank() &&
                        emailState.value.isNotBlank()

                if (allFieldsFilled) {
                    saveUserInformation(firstNameState.value, lastNameState.value, emailState.value, context)
                    // Navigate to Home screen
                    navController.navigate(Destinations.Home.route)
                } else {
                    mToast(context)
                }

            },
            modifier = Modifier
                .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
            ,
            shape = RoundedCornerShape(size = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF4CE14))
        ) {
            Text("Register",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.markazi_text)),
                color = Color(0xFF1E1E1E),
                fontWeight = FontWeight(300)
            )
        }

    }
}

private fun mToast(context: Context){
    Toast.makeText(context, "Registration unsuccessful. Please enter all data.", Toast.LENGTH_LONG).show()
}

private fun saveUserInformation(firstName: String, lastName: String, email: String, context: Context) {
    val sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("first_name", firstName)
    editor.putString("last_name", lastName)
    editor.putString("email", email)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
        editor.apply()
    }
}


@Composable
fun OnboardingPreview(){

}

