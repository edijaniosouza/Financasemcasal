package com.example.financasemcasal

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun test_convert_bigdecimal_to_real(){
        val formated = BigDecimal("19").formatForBrazilianCurrency()
        assertEquals("R$ 19,00", formated)
    }

    @Test
    fun test_convert_bigdecimal_to_real_with_decimals(){
        val formated = BigDecimal("19.5").formatForBrazilianCurrency()
        assertEquals("R$ 20,50", formated)
    }
}
