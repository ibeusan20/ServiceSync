package hr.foi.air.servicesync.ui.contents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.servicesync.R
import hr.foi.air.servicesync.ui.components.CompanyDescription
import hr.foi.air.servicesync.ui.components.CompanyLocation
import hr.foi.air.servicesync.ui.components.CompanyNameAndImage
import hr.foi.air.servicesync.ui.components.CompanyWorkingHours
import hr.foi.air.servicesync.ui.items.ProvidedServicesListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchContent(modifier: Modifier = Modifier)
{
    Scaffold(
        modifier = modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.navigationBars,
        content = { innerPadding ->
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                val headlineModifier = Modifier.fillMaxWidth().padding(8.dp)
                val headlineTextStyle = MaterialTheme.typography.headlineMedium

                CompanyNameAndImage("Tvrtka A", R.drawable.ic_launcher_background)

                Spacer(modifier = Modifier.size(50.dp))

                CompanyDescription("Opis vrtke A")

                Spacer(modifier = Modifier.size(25.dp))

                ListItem(
                    headlineContent = {
                        Text(
                            text = stringResource(id = R.string.services),
                            color = MaterialTheme.colorScheme.onSurface,
                            style = headlineTextStyle,
                            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)
                        )
                    },
                    supportingContent = {
                        Column {
                            // TODO: New feature will require these list items to open a new screen when the icon > is clicked
                            ProvidedServicesListItem("Servis A")
                            ProvidedServicesListItem("Servis B")
                        }
                    },
                )

                CompanyWorkingHours()

                Spacer(Modifier.size(200.dp))

                CompanyLocation()

                Text(text = stringResource(R.string.reviews), style = headlineTextStyle, modifier = headlineModifier)
            }
        }
    )
}

@Preview
@Composable
fun PreviewCompanyDetails() {
    CompanyDetailsContent(2)
}
