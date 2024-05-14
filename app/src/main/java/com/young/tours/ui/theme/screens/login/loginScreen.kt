@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.young.tours.ui.theme.screens.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.young.tours.R
import com.young.tours.data.AuthViewmodel
import com.young.tours.ui.theme.components.Header
import com.young.tours.ui.theme.components.LoginTextField


val  defaultPadding = 16.dp
val  itemSpacing = 8.dp


@Composable
fun  LoginScreen(navController: NavHostController){
    Image(painter = painterResource(id = R.drawable.jelly),
        contentDescription =null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )


    val (userName,setUsername) = rememberSaveable {
        mutableStateOf("")
    }
    val (email,setEmail) = rememberSaveable {
        mutableStateOf(TextFieldValue(""))
    }
    val (password,setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (checked,onCheckedChange) = rememberSaveable {
        mutableStateOf(false)
    }
    val  context = LocalContext.current

    Column(

        modifier = Modifier
        .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Header(
            text = "Login",
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
        LoginTextField(
            value = userName,
            onValueChange = setUsername,
            labelText = "Username",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(itemSpacing))
        LoginTextField(
            value = email,
            onValueChange = setEmail,
            labelText = "Email",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(itemSpacing))
        LoginTextField(
            keyboardType = KeyboardType.Password ,
            value = password,
            onValueChange = setPassword,
            labelText = "Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(itemSpacing))
        Row (
            modifier =  Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment =  Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = onCheckedChange)
                Text(text = "Remember Me")
            }
            TextButton(onClick = {}) {
                Text(text = "Forgot Password")
            }
        }
        Spacer(modifier = Modifier.height(itemSpacing))
        Button(onClick = { val mylogin= AuthViewmodel.AuthViewModel(navController, context)
            mylogin.login(email.text.trim(),pass.text.trim())  } , modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }
        AlternativeLoginOptions(
            onIconClick = {
                    index ->
                when(index){
                    0 -> {
                        Toast.makeText(context, "Instagram Login Click", Toast.LENGTH_SHORT).show()
                    }
                    1 -> {
                        Toast.makeText(context, " Google Login Click", Toast.LENGTH_SHORT).show()
                    }

                }
            },
            onSignUpClick = {},
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.BottomCenter)
        )

    }
}
@Suppress("UNUSED_EXPRESSION")
@Composable
fun AlternativeLoginOptions(
    onIconClick : (index:Int) ->Unit,
    onSignUpClick:() ->Unit,
    modifier: Modifier = Modifier
){
    val iconList = listOf(
        R.drawable.google_icon,
        R.drawable.instagram_logo
    )
    Column (
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Or Sign In With")
        Row (horizontalArrangement = Arrangement.SpaceEvenly) {
            iconList.forEachIndexed{index, iconResId ->
                Icon(
                    painter = painterResource(id = iconResId),
                    contentDescription = "alternative Login",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            onIconClick(index)
                        }
                        .clip(CircleShape)
                )
                Spacer(Modifier.width(defaultPadding))
            }
        }
        Spacer(Modifier.height(defaultPadding))
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have an account")
            Spacer(Modifier.height(itemSpacing))
            TextButton(onClick = {onSignUpClick}) {
                Text(text = "Sign Up ")
            }
        }
    }

}



@Preview
@Composable
fun PrevLogin(showUInt: UInt){
    LoginScreen(navController = rememberNavController())
}