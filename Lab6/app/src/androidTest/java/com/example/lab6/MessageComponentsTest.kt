package com.example.lab6

import android.view.accessibility.AccessibilityEvent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

/** Verify the real UI and system Toast events on the connected emulator. */
@RunWith(AndroidJUnit4::class)
class MessageComponentsTest {
    private lateinit var scenario: ActivityScenario<MainActivity>
    private val toastMessages = LinkedBlockingQueue<String>()
    private val automation = InstrumentationRegistry.getInstrumentation().uiAutomation

    @Before
    fun launch() {
        automation.setOnAccessibilityEventListener { event ->
            if (event.eventType == AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED &&
                event.packageName?.toString() == "com.example.lab6") {
                event.text.forEach { toastMessages.offer(it.toString()) }
            }
        }
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @After
    fun close() {
        automation.setOnAccessibilityEventListener(null)
        scenario.close()
    }

    private fun expectToast(expected: String) {
        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(8)
        var found = false
        while (System.nanoTime() < deadline) {
            if (toastMessages.poll(200, TimeUnit.MILLISECONDS) == expected) {
                found = true
                break
            }
        }
        assertTrue("Expected system Toast: $expected", found)
    }

    @Test
    fun toastButtonShowsMessage() {
        onView(withId(R.id.btnToast)).perform(click())
        expectToast("預設 Toast")
    }

    @Test
    fun snackbarActionResponds() {
        onView(withId(R.id.btnSnackBar)).perform(click())
        onView(withText("按鈕式 Snackbar")).check(matches(isDisplayed()))
        onView(withId(com.google.android.material.R.id.snackbar_action)).perform(click())
        expectToast("已回應")
    }

    private fun dialogButton(label: String) {
        onView(withId(R.id.btnDialog1)).perform(click())
        onView(withText("AlertDialog 內容")).check(matches(isDisplayed()))
        onView(withText(label)).perform(click())
        expectToast(label)
    }

    @Test fun neutralButtonResponds() = dialogButton("左按鈕")
    @Test fun negativeButtonResponds() = dialogButton("中按鈕")
    @Test fun positiveButtonResponds() = dialogButton("右按鈕")

    @Test
    fun everyListItemReturnsItsSelection() {
        for (number in 1..5) {
            onView(withId(R.id.btnDialog2)).perform(click())
            onView(withText("選項 $number")).perform(click())
            expectToast("你選的是選項 $number")
        }
    }

    @Test
    fun singleChoiceDefaultsToFirstItem() {
        onView(withId(R.id.btnDialog3)).perform(click())
        onView(withText("選項 1")).check(matches(isChecked()))
        onView(withText("確定")).perform(click())
        expectToast("你選的是選項 1")
    }

    @Test
    fun singleChoiceReturnsChangedItemAndResetsWhenReopened() {
        onView(withId(R.id.btnDialog3)).perform(click())
        onView(withText("選項 4")).perform(click())
        onView(withText("選項 4")).check(matches(isChecked()))
        onView(withText("確定")).perform(click())
        expectToast("你選的是選項 4")
        onView(withId(R.id.btnDialog3)).perform(click())
        onView(withText("選項 1")).check(matches(isChecked()))
        pressBack()
        onView(withId(R.id.btnToast)).check(matches(isDisplayed()))
    }
}
