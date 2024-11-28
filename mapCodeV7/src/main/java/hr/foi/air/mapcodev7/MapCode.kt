package hr.foi.air.mapcodev7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.lightspark.composeqr.QrCodeColors
import com.lightspark.composeqr.QrCodeView
import com.utsman.osmandcompose.Marker
import com.utsman.osmandcompose.MarkerState
import com.utsman.osmandcompose.OpenStreetMap
import com.utsman.osmandcompose.rememberMarkerState
import org.osmdroid.util.GeoPoint

@Composable
fun MapCode(
    itemsList: List<MapCodeDisplayable>
    ){
    var allMarkers: List<Pair<MapCodeDisplayable, MarkerState>> = itemsList.map {
        Pair(it, rememberMarkerState(geoPoint = GeoPoint(it.getLatitude(), it.getLongitude())))
    }

    OpenStreetMap()
    {
        allMarkers.map { (displayableObject, markerState) ->
            Marker(state = markerState) {
                Column(
                    modifier = Modifier.fillMaxSize(0.25f),
                    verticalArrangement =Arrangement.Center
                ) {
                    QrCodeView(
                        data = displayableObject.getCode(),
                        colors = QrCodeColors.default().copy(foreground = Color.Green),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxSize(0.5f)
                    )
                }
            }
        }
    }
}