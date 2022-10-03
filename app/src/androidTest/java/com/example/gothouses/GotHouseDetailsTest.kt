package com.example.gothouses

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gothouses.models.House
import com.example.gothouses.screens.HouseDetail
import com.example.gothouses.ui.theme.GotHousesTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class GotHouseDetailsTest {

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun test_houses_recycler_display() {

        val house = House("Algood","Region","coats of arms","words", null, null)
        // Content from API is displaying.
        composeTestRule.setContent { 
            GotHousesTheme() {
                composeTestRule.setContent {
                    
                }
            }
        }

    }

}