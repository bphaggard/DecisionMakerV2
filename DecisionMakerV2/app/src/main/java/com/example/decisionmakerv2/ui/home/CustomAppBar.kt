package com.example.decisionmakerv2.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionmakerv2.ui.theme.workSansFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar() {

    Box(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondary),
            title = {
                Text(
                    text = "Easy Decision",
                    fontFamily = workSansFamily,
                    fontSize = 30.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            },
//            actions = {
//                AppBarActions()
//            }
        )
    }
}

//@Composable
//fun AppBarActions(){
//    ChangeColor()
//}

//@Composable
//fun ChangeColor(){
//    var shoeMenu by remember { mutableStateOf(false) }
//    val context = LocalContext.current
//
//    IconButton(
//        onClick = { shoeMenu = !shoeMenu }
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Menu,
//            contentDescription = "Menu Icon",
//            tint = MaterialTheme.colorScheme.onPrimary
//        )
//        DropdownMenu(
//            expanded = shoeMenu,
//            onDismissRequest = { shoeMenu = false }
//        ) {
//            Text(
//                modifier = Modifier.padding(horizontal = 10.dp),
//                text = "Theme switcher",
//                fontWeight = FontWeight.Bold,
//                fontSize = 15.sp)
//
//            DropdownMenuItem(
//                text = { Text(text = "Light") },
//                onClick = {  })
//
//            DropdownMenuItem(
//                text = { Text(text = "Dark") },
//                onClick = {  })
//
//            DropdownMenuItem(
//                text = { Text(text = "System") },
//                onClick = {  })
//
//        }
//    }
//}

@Preview
@Composable
fun CustomAppBarPreview(){
    CustomAppBar()
}