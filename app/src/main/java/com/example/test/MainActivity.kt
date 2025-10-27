package com.example.test

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SettingsCell
import androidx.compose.material.icons.filled.SettingsPhone
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingToolbarDefaults
import androidx.compose.material3.FloatingToolbarDefaults.ScreenOffset
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.core.view.WindowCompat
import androidx.xr.compose.material3.ExperimentalMaterial3XrApi
import androidx.xr.compose.material3.HorizontalFloatingToolbar
import com.example.test.ui.theme.TestTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

data class MessageInfo(
    val message: String, val isCurrentUser: Boolean, val isLoaded: Boolean, val id: String
)

object Destination {
    val entries = listOf<String>(
        "Home",
        "Chat",
        "Login",
    )
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        enableEdgeToEdge()
        setContent {

            TestTheme {
                Scaffold(
                ) { innerPadding ->

                    BottomToolBar(innerPadding)
//                    ChatPage(
//                        modifier = Modifier
//                            .imePadding()
////                            .padding(innerPadding)
////                            .consumeWindowInsets(innerPadding)
//                    )

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3XrApi::class)
@Composable
fun BottomToolBar(innerPadding: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .background(Color(0x33A6A6A6), shape = RoundedCornerShape(16.dp))
                .border(color = Color.Red, width = 1.dp, shape = RoundedCornerShape(16.dp))
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalFloatingToolbar(
                expanded = false,
                modifier = Modifier,
                colors = FloatingToolbarDefaults.standardFloatingToolbarColors().copy(
                    toolbarContainerColor = Color.Transparent,
                ),
                content = {
                    var selected by remember { mutableStateOf(0) }

                    IconButton(
                        modifier = Modifier.then(
                            if (selected == 0) {
                                Modifier.background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFFFF0007),
                                            Color(0xFF0A2DFF)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                            } else {
                                Modifier
                            }
                        ),
                        onClick = { selected = 0 }
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }

                    IconButton(
                        modifier = Modifier.then(
                            if (selected == 1) {
                                Modifier.background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFFFF0007),
                                            Color(0xFF0A2DFF)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                            } else {
                                Modifier
                            }
                        ),
                        onClick = { selected = 1 }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert, contentDescription = null
                        )
                    }

                    IconButton(
                        modifier = Modifier.then(
                            if (selected == 2) {
                                Modifier.background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFFFF0007),
                                            Color(0xFF0A2DFF)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                            } else {
                                Modifier
                            }
                        ),
                        onClick = { selected = 2 }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Settings, contentDescription = null
                        )
                    }

                    IconButton(
                        modifier = Modifier.then(
                            if (selected == 3) {
                                Modifier.background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFFFF0007),
                                            Color(0xFF0A2DFF)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                            } else {
                                Modifier
                            }
                        ),
                        onClick = { selected = 3 }
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }

                    IconButton(
                        modifier = Modifier.then(
                            if (selected == 4) {
                                Modifier.background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFFFF0007),
                                            Color(0xFF0A2DFF)
                                        )
                                    ),
                                    shape = CircleShape
                                )
                            } else {
                                Modifier
                            }
                        ),
                        onClick = { selected = 4 }
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }
                })
        }
    }
}

@Composable
fun ChatPage(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf<MessageInfo>()) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    ConstraintLayout(
        modifier = modifier.fillMaxSize(),
    ) {
        val (list, input) = createRefs()

        LazyColumn(
            modifier = Modifier
                .imePadding()
                .fillMaxWidth()
                .constrainAs(list) {
                    top.linkTo(parent.top)
                    bottom.linkTo(input.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                },
            contentPadding = PaddingValues(8.dp),
            reverseLayout = true,
            state = listState,
        ) {
            items(
                count = messages.size, key = { index ->
                    messages[index].id
                }) { index ->
                MessageItem(
                    message = messages[index].message,
                    isCurrentUser = messages[index].isCurrentUser,
                    isLoaded = messages[index].isLoaded,
                ) {
                    val temp = messages.toMutableList()
                    temp[index] = temp[index].copy(isLoaded = true)
                    messages = temp.toList()
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(input) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        val temp = messages.toMutableList()
                        temp.add(
                            0,
                            MessageInfo(text, Random.nextBoolean(), false, messages.size.toString())
                        )
                        messages = temp.toList()
                        text = ""
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    })
            )
        }
    }
}

@Composable
fun MessageItem(
    modifier: Modifier = Modifier,
    message: String,
    isCurrentUser: Boolean,
    isLoaded: Boolean,
    onRenderComplete: () -> Unit
) {
    val alignment = if (isCurrentUser) Alignment.End else Alignment.Start
    val backgroundColor = if (isCurrentUser) MaterialTheme.colorScheme.primary else Color.Gray

    var displayedText by remember { mutableStateOf("") }

    LaunchedEffect(message) {
        if (isLoaded) {
            displayedText = message
            return@LaunchedEffect
        }

        message.forEachIndexed { index, char ->
            displayedText += message.substring(index, index + 1)
            delay(10)
        }
        onRenderComplete()
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp), horizontalAlignment = alignment
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp, color = backgroundColor
        ) {
            Text(
                text = displayedText,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
@Preview
fun PreviewChat() {
    TestTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding)
            ) {
                ChatPage()
            }
        }
    }
}