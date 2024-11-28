package hr.foi.air.servicesync.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose.onPrimaryDark
import com.example.compose.onPrimaryLight
import com.example.compose.primaryDark
import com.example.compose.primaryLight
import hr.foi.air.mapcodev7.Car
import hr.foi.air.mapcodev7.MapCode
import hr.foi.air.servicesync.ui.components.isDark
import hr.foi.air.servicesync.ui.contents.FavoriteContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val allCars = listOf(
            Car("Audi", "A7", 2023, 46.291553, 16.353050),
            Car("Mitsubishi", "Lancer", 2023, 46.303126, 16.336735),
            Car("Alfa Romeo", "Giulia Quadrifoglio", 2023, 46.309294, 16.348600)
        )

        MapCode(
            itemsList = allCars
        )
    }
}