package com.example.pertemuan5tugas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun FormBiodataScreen() {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Layer bawah: gambar laba-laba
            Image(
                painter = painterResource(R.drawable.bg),
                contentDescription = stringResource(R.string.desc_bg),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize()
            )

            // Layer atas: lembar putih mengapung di bawah
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(
                    topStart = dimensionResource(R.dimen.sheet_corner),
                    topEnd = dimensionResource(R.dimen.sheet_corner)
                ),
                color = colorResource(R.color.white),
                shadowElevation = dimensionResource(R.dimen.sheet_elevation)
            ) {
                FormBiodata()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormBiodata(modifier: Modifier = Modifier) {
    // variable untuk mengingat nilai masukan dari keyboard
    var textDepan by remember { mutableStateOf("") }
    var textBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
}
