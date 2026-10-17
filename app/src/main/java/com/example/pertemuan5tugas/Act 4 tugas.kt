package com.example.pertemuan5tugas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

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
    var textTgl by remember { mutableStateOf("") }
    var textExp by remember { mutableStateOf("") }

    var expanded by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    // data pilihan dari resources
    val experienceList = stringArrayResource(R.array.experience_list)
    val skillNames = listOf(
        stringResource(R.string.skill_android),
        stringResource(R.string.skill_uiux),
        stringResource(R.string.skill_web)
    )
    val skillChecked = remember { mutableStateListOf(false, false, false) }
    val separator = stringResource(R.string.separator_list)

    val formatter = SimpleDateFormat(stringResource(R.string.date_format), Locale.getDefault())
    formatter.timeZone = TimeZone.getTimeZone(stringResource(R.string.date_timezone))

    // variable untuk menyimpan data yang diperoleh dari komponen UI (setelah Proceed ditekan)
    var depan by remember { mutableStateOf("") }
    var belakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tgl by remember { mutableStateOf("") }
    var exp by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }

    val fieldShape = RoundedCornerShape(dimensionResource(R.dimen.field_corner))

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(R.dimen.padding_large)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.form_title),
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.purple_title)
        )
        Text(
            text = stringResource(R.string.form_subtitle),
            style = MaterialTheme.typography.bodySmall,
            color = colorResource(R.color.gray_text),
            textAlign = TextAlign.Center
        )

        // Baris 1: nama depan & belakang
        Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))) {
            OutlinedTextField(
                value = textDepan,
                singleLine = true,
                shape = fieldShape,
                modifier = Modifier.weight(1f),
                label = { Text(stringResource(R.string.label_first_name)) },
                onValueChange = { textDepan = it }
            )
            OutlinedTextField(
                value = textBelakang,
                singleLine = true,
                shape = fieldShape,
                modifier = Modifier.weight(1f),
                label = { Text(stringResource(R.string.label_last_name)) },
                onValueChange = { textBelakang = it }
            )
        }
    }
}

