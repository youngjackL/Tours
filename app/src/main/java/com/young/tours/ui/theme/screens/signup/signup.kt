package com.young.tours.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.young.tours.R
import com.young.tours.ui.theme.components.Header
import com.young.tours.ui.theme.components.LoginTextField
import com.young.tours.ui.theme.screens.login.defaultPadding


@Composable
fun SignUpScreen(navController: NavHostController){
    Image(painter = painterResource(id = R.drawable.jelly),
        contentDescription =null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )

    val (firstName, onfirstNameChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (lastName, onlastNameChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (email, onEmailChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (password, onPasswordChange) = rememberSaveable {
        mutableStateOf("")
    }
    val (confirmPassword, onConfirmPasswordChange) = rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(defaultPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Header(
            text = "Sign Up",
            modifier = Modifier
                .padding(vertical = defaultPadding)
                .align(alignment = Alignment.Start)
        )
        LoginTextField(
            value = firstName,
            onValueChange = onfirstNameChange,
            labelText = "Firstname",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(defaultPadding))
        LoginTextField(
            value = lastName,
            onValueChange = onlastNameChange,
            labelText = "Lastname",
            leadingIcon = Icons.Default.Person,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(defaultPadding))
        LoginTextField(
            value = email,
            onValueChange = onEmailChange,
            labelText = "Email",
            leadingIcon = Icons.Default.Email,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(defaultPadding))
        LoginTextField(
            value = password,
            onValueChange = onPasswordChange,
            labelText = "Firstname",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password

        )
        Spacer(Modifier.height(defaultPadding))
        LoginTextField(
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            labelText = "Confirm Password",
            leadingIcon = Icons.Default.Lock,
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password
        )

        Spacer(Modifier.height(defaultPadding))
        Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Sign Up")
        }
        Spacer(Modifier.height(defaultPadding))
        val signTx = "Sign In"
        val signInAnnotation = buildAnnotatedString {
            withStyle(SpanStyle(color =MaterialTheme.colorScheme.onBackground )){
                append("Already have an account")
            }
            append(" ")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)){
                pushStringAnnotation(signTx,signTx)
                append(signTx)
            }

        }



    }
}


@Preview
@Composable
fun  PrevSignUp(){
    SignUpScreen(navController = rememberNavController())
}
