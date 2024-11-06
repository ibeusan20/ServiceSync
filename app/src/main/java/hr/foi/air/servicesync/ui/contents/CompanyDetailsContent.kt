package hr.foi.air.servicesync.ui.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hr.foi.air.servicesync.R
import hr.foi.air.servicesync.ui.items.ProvidedServicesListItem

@Composable
fun CompanyDetailsContent(id: Number) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth().padding(WindowInsets.navigationBars.asPaddingValues()).verticalScroll(rememberScrollState())
    ) {
        val headlineModifier = Modifier.fillMaxWidth().padding(8.dp)
        val headlineTextStyle =  MaterialTheme.typography.headlineMedium

        Box(modifier= Modifier.fillMaxWidth().height(200.dp), contentAlignment = Alignment.BottomStart)
        {
            Image(
                imageVector =  ImageVector.vectorResource(R.drawable.ic_launcher_background),
                "Company image",
                modifier  = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(Color.Black)
                )
            Text(text = "Tvrtka A", color = MaterialTheme.colorScheme.inverseOnSurface, style = MaterialTheme.typography.displayMedium)
        }

        Spacer(modifier = Modifier.size(50.dp))

        Text(text = "Opis tvrtke A" , color = MaterialTheme.colorScheme.onSurface, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.size(25.dp))

        ListItem(headlineContent =  {
                Text(text = stringResource(id = R.string.services),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = headlineTextStyle,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp,)
                )

        }, supportingContent = {
            Column {
                //TODO new feature will require these list items to open a new screen when the icon > is clicked
                ProvidedServicesListItem("Servis A")
                ProvidedServicesListItem("Servis B")
            }
        },
        )

        Text(
            text = stringResource(id = R.string.working_hours),
            color = MaterialTheme.colorScheme.onSurface,
            style =headlineTextStyle,
            modifier = headlineModifier
            )

        Text("Pon-Pet:",modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp))

        Text("Subota:",modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp))

        Spacer(Modifier.size(25.dp))

        Text(text = stringResource(R.string.location), modifier = headlineModifier, style = headlineTextStyle)

        //TODO remove this box and add GoogleMaps map
        Box(modifier = Modifier.fillMaxWidth().height(200.dp).background(Color.Black))

        Text(text = stringResource(R.string.reviews), style = headlineTextStyle,modifier  =headlineModifier)

    }
}
@Preview
@Composable
fun PreviewCompanyDetails(){
    CompanyDetailsContent(2)
}