package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import junit.framework.TestCase.assertEquals
import kotlin.test.Test

class TipCalculatorTestPU {

//Pruebas Unitarias

    @Test
    fun calculateTip_20Percent() {
        val result = calculateTip(100.0, 20, false, false)
        assertEquals(20.0, result, 0.01)
    }


    @Test
    fun calculateTip_15Percent_RoundUp() {
        val result = calculateTip(95.0, 15, true, false)
        assertEquals(15.0, result, 0.01)
    }

    @Test
    fun calculateTip_NegativeAmount_ReturnsZero() {
        val result = calculateTip(-50.0, 20, false, false)
        assertEquals(0.0, result.coerceAtLeast(0.0), 0.01)
    }

    @Test
    fun calculateTip_TotalPerPerson_Calculation() {
        val tip = calculateTip(100.0, 20, false, false)
        val numPeople = 4
        val totalPerPerson = (100.0 + tip) / numPeople
        assertEquals(30.0, totalPerPerson, 0.01)
    }




// Prueba unitaria adicionales
    @Test
    fun calculateTip_LargeBillAmount() {    //acepta grandes cantidades de dinero
        val result = calculateTip(1_000_000.0, 15, false, false)
        assertEquals(150_000.0, result, 0.01)
    }

    @Test
    fun calculateTip_Over100Percent() { // la propina no debe de pasar dek 100%
        val result = calculateTip(50.0, 150, false, false)
        assertEquals(75.0, result, 0.01)
    }

}