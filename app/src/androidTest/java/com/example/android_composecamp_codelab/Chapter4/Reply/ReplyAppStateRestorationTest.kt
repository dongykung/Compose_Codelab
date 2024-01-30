package com.example.android_composecamp_codelab.Chapter4.Reply

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasAnyDescendant
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.android_composecamp_codelab.Chapter4.Reply.data.local.LocalEmailsDataProvider
import com.example.android_composecamp_codelab.Chapter4.Reply.ui.ReplyApp
import com.example.android_composecamp_codelab.Chapter4.test.onNodeWithContentDescriptionForStringId
import com.example.android_composecamp_codelab.Chapter4.test.onNodeWithStringId
import com.example.android_composecamp_codelab.Chapter4.test.onNodeWithTagForStringId
import org.junit.Rule
import org.junit.Test
import com.example.android_composecamp_codelab.R


annotation class TestCompactWidth
annotation class TestMediumWidth
annotation class TestExpandedWidth
class ReplyAppStateRestorationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    @TestCompactWidth
    fun compactDevice_selectedEmailEmailRetained_afterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent { ReplyApp(windowSize = WindowWidthSizeClass.Compact) }

        composeTestRule.onNodeWithStringId(LocalEmailsDataProvider.allEmails[2].body)
            .assertIsDisplayed()

        composeTestRule.onNodeWithStringId(LocalEmailsDataProvider.allEmails[2].body).performClick()

        composeTestRule.onNodeWithContentDescriptionForStringId(R.string.navigation_back)
            .assertExists()

        composeTestRule.onNodeWithStringId(LocalEmailsDataProvider.allEmails[2].body).assertExists()
        stateRestorationTester.emulateSavedInstanceStateRestore()

        composeTestRule.onNodeWithContentDescriptionForStringId(R.string.navigation_back)
            .assertExists()
        composeTestRule.onNodeWithStringId(LocalEmailsDataProvider.allEmails[2].body).assertExists()
    }


    @Test
    @TestExpandedWidth
    fun expandedDevice_selectedEmailEmailRetained_afterConfigChange() {
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent { ReplyApp(windowSize = WindowWidthSizeClass.Expanded) }

        composeTestRule.onNodeWithStringId(LocalEmailsDataProvider.allEmails[2].body)
            .assertIsDisplayed()

        composeTestRule.onNodeWithStringId(LocalEmailsDataProvider.allEmails[2].subject)
            .performClick()
        composeTestRule.onNodeWithTagForStringId(R.string.details_screen).onChildren()
            .assertAny(
                hasAnyDescendant(
                    hasText(
                        composeTestRule.activity.getString(
                            LocalEmailsDataProvider.allEmails[2].body
                        )
                    )
                )
            )
        stateRestorationTester.emulateSavedInstanceStateRestore()
        composeTestRule.onNodeWithTagForStringId(R.string.details_screen).onChildren()
            .assertAny(hasAnyDescendant(hasText(
                composeTestRule.activity.getString(LocalEmailsDataProvider.allEmails[2].body)))
            )
    }

}