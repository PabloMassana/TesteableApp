package com.example.testeableapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import org.junit.Rule
import org.junit.Test

class TipCalculatorUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private fun launchScreen() {
        composeTestRule.setContent {
            TipCalculatorScreen()
        }
    }

    @Test
    fun test_RoundUpCheckboxChangesTip() {
        launchScreen()
        composeTestRule.onNodeWithTag("input_monto").performTextInput("95")
        composeTestRule.onNodeWithTag("chk_redondear").performClick()
        composeTestRule.onNodeWithTag("txt_propina").assertTextEquals("Propina: \$15.00")
    }

    @Test
    fun test_SliderChangesTipPercentage() {
        launchScreen()
        composeTestRule.onNodeWithTag("input_monto").performTextInput("100")
        composeTestRule.onNodeWithTag("slider_propina").performTouchInput {
            swipeRight(startX = 0f, endX = 0.4f)
        }
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("txt_propina").assertExists()
    }

    @Test
    fun test_UIElementsVisible() {
        launchScreen()
        composeTestRule.onNodeWithTag("input_monto").assertIsDisplayed()
        composeTestRule.onNodeWithTag("slider_propina").assertIsDisplayed()
        composeTestRule.onNodeWithTag("chk_redondear").assertIsDisplayed()
        composeTestRule.onNodeWithTag("txt_personas").assertIsDisplayed()
    }

    @Test
    fun test_NumberOfPeopleChanges() {
        launchScreen()
        composeTestRule.onNodeWithTag("btn_mas").performClick()
        composeTestRule.onNodeWithTag("txt_personas").assertTextEquals("2")
    }

    @Test
    fun test_TotalPerPersonChangesWithPeople() {
        launchScreen()
        composeTestRule.onNodeWithTag("input_monto").performTextInput("100")
        composeTestRule.onNodeWithTag("btn_mas").performClick()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("txt_total_persona").assertExists()
    }
}
