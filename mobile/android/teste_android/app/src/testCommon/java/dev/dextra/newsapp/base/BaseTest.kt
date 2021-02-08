package dev.dextra.newsapp.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest(private val instrumented: Boolean = false) {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        TestSuite.init(instrumented)
    }

    @After
    fun clear(){
        TestSuite.clear()
    }

}