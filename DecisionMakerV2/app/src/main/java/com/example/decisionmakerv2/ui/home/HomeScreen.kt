package com.example.decisionmakerv2.ui.home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decisionmakerv2.model.NoteEntity
import com.example.decisionmakerv2.viewmodel.HomeViewModel
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
){
    val noteListState = homeViewModel.noteListFlow.collectAsState(initial = listOf())
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        Scaffold (topBar = { CustomAppBar() }){

        }
    }
    Column (
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //Input Value
            var enteredValue by remember { mutableStateOf("") }
            InputValue(text = enteredValue) { value -> enteredValue = value}
            //Add Button
            Button(
                modifier = Modifier.height(55.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 6.dp,
                    disabledElevation = 0.dp),
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    if (enteredValue.isNotBlank()){
                        homeViewModel.addNote(NoteEntity(text = enteredValue))
                } else{
                    coroutineScope.launch {
                        Toast.makeText(context,"Enter value cannot be empty!",Toast.LENGTH_LONG).show()
                        }
                    }
                })
            {
                Text(text = "ADD")
            }
        }

        //Values Card
        Card(elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f))
        {
            LazyColumn{
                items(noteListState.value.size){index ->
                    val note = noteListState.value[index]
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp)
                            .height(45.dp)
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth(0.85f)
                                    .horizontalScroll(rememberScrollState()),
                                text = note.text,
                                maxLines = 1
                            )
                            IconButton(
                                onClick = { homeViewModel.deleteNote(note) },
                                modifier = Modifier.size(30.dp)) {
                                Icon(
                                    imageVector = Icons.Outlined.Delete,
                                    contentDescription = "delete",
                                    tint = Color.Red)
                            }
                        }
                    }
                }
            }
        }
        //Result Card
        Card(elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f))
        {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.3f)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "Your choice :",
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                    Text(
                        text = homeViewModel.chosenNote.value ?: "",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(horizontal = 15.dp)
                    )
                }
        }
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
                //Clear Button
                Button(
                    modifier = Modifier.height(55.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 6.dp,
                        disabledElevation = 0.dp
                    ),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        coroutineScope.launch { homeViewModel.deleteAll() }
                    }) {
                    Text(text = "CLEAR LIST")
                }
                //Choose Button
                Button(
                    modifier = Modifier.height(55.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 0.dp,
                        pressedElevation = 6.dp,
                        disabledElevation = 0.dp
                    ),
                    shape = RoundedCornerShape(15.dp),
                    onClick = {
                        coroutineScope.launch {
                            if (noteListState.value.isEmpty()){
                                homeViewModel.chosenNote.value ?: ""
                                Toast.makeText(context, "List is Empty", Toast.LENGTH_LONG).show()
                            } else { homeViewModel.chooseNote() }
                        }
                    }
                ) {
                    Text(text = "CHOOSE")
                }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputValue(text: String,
               onValueChange: (String) -> Unit) {
    val txtState = rememberSaveable { mutableStateOf(text) }
    TextField(
        value = txtState.value,
        modifier = Modifier.fillMaxWidth(0.7f),
        placeholder = { Text("Enter value") },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        trailingIcon = {
            when {
            txtState.value.isNotEmpty() -> IconButton(onClick = { txtState.value = "" })
                {
                    Icon(Icons.Default.Clear,
                        contentDescription = "clear text",
                    )
                }
            }
        },
        shape = RoundedCornerShape(15.dp),
        singleLine = true,
        onValueChange = { txt ->
            txtState.value = txt
            onValueChange(txt)
        }
    )
}