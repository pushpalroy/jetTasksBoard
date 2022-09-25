package com.jetapps.jettaskboard.presentation.drawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetapps.jettaskboard.component.WorkSpaceItem
import com.jetapps.jettaskboard.presentation.DashboardViewModel

@Composable
fun DrawerWorkSpaceComponent(
    viewModel: DashboardViewModel,
    modifier: Modifier,
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "WorkSpace",
            modifier = modifier.padding(bottom = 16.dp),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        viewModel.boardList.forEach { items ->
            WorkSpaceItem(
                modifier = modifier,
                workSpaceHeading = items.title
            )
        }
    }
}