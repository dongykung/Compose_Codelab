package com.example.android_composecamp_codelab.Chapter4.Reply.ui

import com.example.android_composecamp_codelab.Chapter4.Reply.data.Email
import com.example.android_composecamp_codelab.Chapter4.Reply.data.MailboxType
import com.example.android_composecamp_codelab.Chapter4.Reply.data.local.LocalEmailsDataProvider

data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    val currentMailbox: MailboxType = MailboxType.Inbox,
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    val isShowingHomepage: Boolean = true
) {
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}