package com.example.android_composecamp_codelab.Chapter4.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.android_composecamp_codelab.Chapter4.Cupcake.ui.SelectOptionScreen
import org.junit.Rule
import org.junit.Test
import com.example.android_composecamp_codelab.R

class CupcakeOrderScreenTest{
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun selectOptionScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }
        //onNodeWithText() 메서드를 사용하여 화면에서 텍스트를 찾고 assertIsDisplayed() 메서드를 사용하여 텍스트가 앱에 표시되는지 확인
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price,
                subtotal
            )
        ).assertIsDisplayed()

        //문자열 리소스 ID로 노드를 찾는 동일한 방식을 사용하여 Next 버튼을 찾습니다.
        // 그러나 앱이 노드를 표시하는지 확인하는 대신 assertIsNotEnabled() 메서드를 사용합니다.
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()


    }
}

