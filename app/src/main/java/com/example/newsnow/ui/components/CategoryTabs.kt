package com.example.newsnow.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryTabs(
    modifier: Modifier = Modifier,
    categories: List<String> = listOf("All", "Business", "Tech", "Sports", "Health"),
    onCategorySelected: (String) -> Unit = {},
    contentPadding: PaddingValues
) {
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = contentPadding
    ) {
        items(categories) { category ->
            val isSelected = category == selectedCategory
            // State to store the measured text width
            var textWidth by remember { mutableStateOf(0.dp) }
            val density = LocalDensity.current

            // Use a Column to stack the text and the line
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        selectedCategory = category
                        onCategorySelected(category)
                    }
                    .padding(bottom = 2.dp) // Space for the line
            ) {
                Text(
                    modifier = Modifier.onSizeChanged { size ->
                        textWidth = with(density) { size.width.toDp() }
                    },
                    text = category,
                    color = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 18.sp
                )
                // Conditionally render the Spacer to act as the line
                if (isSelected) {
                    Spacer(
                        modifier = Modifier
                            .height(3.dp)
                            .width(textWidth) // The line will be the full width of the text
                            .background(MaterialTheme.colorScheme.primary)
                    )
                }
            }
        }
    }
}