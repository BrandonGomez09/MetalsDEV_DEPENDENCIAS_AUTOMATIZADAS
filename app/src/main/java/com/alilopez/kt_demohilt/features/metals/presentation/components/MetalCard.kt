package com.alilopez.kt_demohilt.features.metals.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alilopez.kt_demohilt.features.metals.domain.entities.MetalPrice
import java.text.NumberFormat
import java.util.Locale

@Composable
fun MetalCard(
    metal: MetalPrice,
    modifier: Modifier = Modifier
) {
    val isUp = metal.trend == "UP"
    val trendColor = if (isUp) Color(0xFF4CAF50) else Color(0xFFE91E63)
    val trendIcon = if (isUp) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown
    val cardColor = if (metal.name.contains("Oro")) Color(0xFFFFF8E1) else Color(0xFFF5F5F5)
    val iconColor = if (metal.name.contains("Oro")) Color(0xFFFFC107) else Color(0xFF9E9E9E)

    Card(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(48.dp).clip(CircleShape).background(iconColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (metal.name.contains("Oro")) "Au" else "Ag",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = metal.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Text(text = "1 Onza", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = formatCurrency(metal.price),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = trendIcon, contentDescription = null, tint = trendColor, modifier = Modifier.size(20.dp))
                    Text(text = if (isUp) "+0.5%" else "-0.2%", style = MaterialTheme.typography.labelMedium, color = trendColor, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

fun formatCurrency(amount: Double): String {
    val locale = Locale.forLanguageTag("es-MX")
    val format = NumberFormat.getCurrencyInstance(locale)
    return format.format(amount)
}