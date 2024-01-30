package com.example.android_composecamp_codelab.Chapter4.Reply

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.android_composecamp_codelab.Chapter4.Reply.ui.ReplyApp
import com.example.android_composecamp_codelab.Chapter4.test.onNodeWithStringId
import com.example.android_composecamp_codelab.Chapter4.test.onNodeWithTagForStringId
import org.junit.Rule
import org.junit.Test
import com.example.android_composecamp_codelab.R

class ReplyAppTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    @Test
    @TestCompactWidth
    fun compactDevice_verifyUsingBottomNavigation(){
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Compact)
        }
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_bottom).assertExists()
    }

    @Test
    @TestMediumWidth
    fun mediumDevice_verifyUsingNavigationRail(){
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Medium)
        }
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_rail).assertExists()
    }

    @Test
    @TestExpandedWidth
    fun expandedDevice_verifyUsingNaviationDrawer(){
        composeTestRule.setContent {
            ReplyApp(windowSize = WindowWidthSizeClass.Expanded)
        }
        composeTestRule.onNodeWithTagForStringId(R.string.navigation_drawer).assertExists()
    }

}