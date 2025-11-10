package com.example.test.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.xr.compose.material3.ExperimentalMaterial3XrApi
import com.example.test.MessageInfo
import com.example.test.MessageItem
import kotlinx.coroutines.launch
import kotlin.random.Random

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3XrApi::class)
@Composable
fun BottomToolBar() {
    Box(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray, shape = RoundedCornerShape(16.dp))
                    .border(color = Color.Red, width = 1.dp, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
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
            }
        }
    }
}