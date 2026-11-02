package com.example.lab5

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FragmentPagesTest {
    @Test
    fun swipingShowsAllThreeFragments() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withText("首頁")).check(matches(isDisplayed()))
            onView(withId(R.id.viewPager2)).perform(swipeLeft())
            onView(withText("第二頁")).check(matches(isDisplayed()))
            onView(withId(R.id.viewPager2)).perform(swipeLeft())
            onView(withText("第三頁")).check(matches(isDisplayed()))
        }
    }
}
