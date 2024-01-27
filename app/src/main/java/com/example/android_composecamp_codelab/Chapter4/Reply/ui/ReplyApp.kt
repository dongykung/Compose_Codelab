package com.example.android_composecamp_codelab.Chapter4.Reply.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_composecamp_codelab.Chapter4.Reply.data.Email
import com.example.android_composecamp_codelab.Chapter4.Reply.data.MailboxType
import com.example.android_composecamp_codelab.Chapter4.Reply.ui.utils.ReplyContentType
import com.example.android_composecamp_codelab.Chapter4.Reply.ui.utils.ReplyNavigationType
import com.example.android_composecamp_codelab.ui.theme.Android_ComposeCamp_CodelabTheme

@Composable
fun ReplyApp(
    windowSize:WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val navigationType: ReplyNavigationType
    val contentType: ReplyContentType
    val viewModel : ReplyViewModel = viewModel()
    val replyUiState = viewModel.uiState.collectAsState().value

    when(windowSize){
        WindowWidthSizeClass.Compact->{
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Medium->{
            navigationType = ReplyNavigationType.NAVIGATION_RAIL
            contentType = ReplyContentType.LIST_ONLY
        }
        WindowWidthSizeClass.Expanded->{
            navigationType = ReplyNavigationType.PERMANENT_NAVIGATION_DRAWER
            contentType = ReplyContentType.LIST_AND_DETAIL
        }
        else->{
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }
    ReplyHomeScreen(
        navigationType=navigationType,
        contentType=contentType,
        replyUiState = replyUiState,
        onTabPressed = { mailboxType : MailboxType->
            viewModel.updateCurrentMailbox(mailboxType=mailboxType)
            viewModel.resetHomeScreenStates()
        },
        onEmailCardPressed = {email:Email->
            viewModel.updateDetailsScreenStates(email=email)
        },
        onDetailScreenBackPressed= {
            viewModel.resetHomeScreenStates()
        },
        modifier=modifier
    )
}


@Preview(showBackground = true)
@Composable
fun ReplyAppPreview() {
    Android_ComposeCamp_CodelabTheme {
        ReplyApp(
            windowSize = WindowWidthSizeClass.Compact,
        )
    }
}