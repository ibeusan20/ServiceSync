package hr.foi.air.servicesync.ui.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import hr.foi.air.servicesync.business.loginRegisterHandler

@Composable
fun LoginScreen(
    onLoginClickSuccesfull: () -> Unit,
    onRegistrationClick: () -> Unit,
) {
    val context = LocalContext.current
    val emailMock = "megica08"
    val passwordMock = "123456"
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold {innerPading ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPading),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(24.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 96.dp, max = 500.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "ServiceSync",
                        style = MaterialTheme.typography.displayLarge,
                    )
                    Text(
                        text = "Sve na jednom mjestu",

                        )
                }
                Spacer(modifier = Modifier.height(48.dp))
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Prijava",
                    style = MaterialTheme.typography.titleLarge,
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Lozinka") },
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick =  {
                        loginRegisterHandler().loginUser(email, password) { isLoggedIn ->
                            if (isLoggedIn) {
                                Toast.makeText(
                                    context,
                                    "Prijava je uspjesna.",
                                    Toast.LENGTH_LONG
                                ).show()
                                onLoginClickSuccesfull()
                            } else {
                                Toast.makeText(
                                    context,
                                    "Prijava nije uspjesna.",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 64.dp)
                ) {
                    Text(text = "Prijava")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Nemate račun? Registrirajte se",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.clickable { onRegistrationClick()},
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(120.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
//    LoginScreen()
}