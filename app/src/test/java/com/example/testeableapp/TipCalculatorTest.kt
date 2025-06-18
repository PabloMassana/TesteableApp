package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTest {

    @Test
    fun calculateTip_20Percent() {
        val result = calculateTip(100.0, 20, false)
        assertEquals(20.0, result, 0.01)
    }

    @Test
    fun calculateTip_15Percent_Rounded() {
        val result = calculateTip(95.0, 15, true)
        assertEquals(15.0, result, 0.01)
    }

    @Test
    fun calculateTip_NegativeAmount_ReturnsZero() {
        val result = calculateTip(-50.0, 20, false)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun calculateTotalPerPerson() {
        val tip = calculateTip(100.0, 10, false)
        val totalPerPerson = (100.0 + tip) / 2
        assertEquals(55.0, totalPerPerson, 0.01)
    }

    @Test
    fun calculateTip_ZeroPercent_ReturnsZero() {
        val result = calculateTip(100.0, 0, false)
        assertEquals(0.0, result, 0.01)
    }

    @Test
    fun calculateTotalPerPerson_DivideByZero_ReturnsZero() {
        val bill = 100.0
        val tip = calculateTip(bill, 15, false)
        val totalPerPerson = if (0 > 0) (bill + tip) / 0 else 0.0
        assertEquals(0.0, totalPerPerson, 0.01)
    }
}
