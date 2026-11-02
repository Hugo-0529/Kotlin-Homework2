package com.example.lab4

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class OrderFlowTest {
    @Test
    fun selectingDrinkSugarAndIceReturnsOrderToMainScreen() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.btnChoice)).perform(click())
            onView(withId(R.id.edDrink)).perform(typeText("Green Tea"), closeSoftKeyboard())
            onView(withId(R.id.radioButton2)).perform(click())
            onView(withId(R.id.radioButton5)).perform(click())
            onView(withId(R.id.btnSend)).perform(click())
            onView(withId(R.id.tvMeal)).check(matches(withText(allOf(
                containsString("Green Tea"),
                containsString("微糖"),
                containsString("去冰")
            ))))
        }
    }
}
