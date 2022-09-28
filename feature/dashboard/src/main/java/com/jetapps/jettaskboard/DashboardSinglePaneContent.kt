package com.jetapps.jettaskboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells.Adaptive
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetapps.jettaskboard.component.BoardCardComponent
import com.jetapps.jettaskboard.component.Header
import com.jetapps.jettaskboard.component.WorkshopCard

@Composable
fun DashboardSinglePaneContent(
    paddingValues: PaddingValues,
    viewModel: DashboardViewModel,
    navigateToTaskBoard: (String) -> Unit = {},
) {
    LazyColumn(
        Modifier.padding(paddingValues)
    ) {
        item {
            Header(
                modifier = Modifier, title = "Starred Boards", onMenuItemClicked = {}
            )
        }
        item {
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 8.dp)
                    .height(240.dp),
                columns = Adaptive(minSize = 180.dp),
                contentPadding = PaddingValues(4.dp),
            ) {
                items(viewModel.boardList.subList(0, 5)) { boardItem ->
                    BoardCardComponent(
                        modifier = Modifier.clickable { navigateToTaskBoard("") },
                        title = boardItem.title,
                        backgroundImageUrl = boardItem.imageUrl
                    )
                }
            }
        }
        item {
            Header(
                modifier = Modifier, title = "Trello workspace", showIcon = true
            )
        }
        item {
            LazyColumn(
                modifier = Modifier
                    .height(320.dp)
                    .padding(top = 4.dp),
            ) {
                items(viewModel.boardList) {
                    WorkshopCard(
                        modifier = Modifier.clickable { navigateToTaskBoard("") },
                        title = it.title,
                        imageUrl = it.imageUrl,
                        isWorkshopStarred = it.isStarred
                    )
                }
            }
        }
    }
}