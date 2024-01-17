package com.example.financasemcasal

import org.junit.Test

import org.junit.Assert.*
import java.math.BigDecimal

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExtensionTests {

    @Test
    fun `testar formatação para moeda brasileira`() {
        val value = BigDecimal("1234.56")
        val formattedValue = value.formatForBrazilianCurrency()

        // Verifique se o valor formatado é o esperado para a moeda brasileira (R$ 1.234,56)
        assertEquals("R$ 1.234,56", formattedValue)
    }

    @Test
    fun `testar formatação para moeda brasileira com valor negativo`() {
        val value = BigDecimal("-7890.12")
        val formattedValue = value.formatForBrazilianCurrency()

        // Verifique se o valor formatado é o esperado para a moeda brasileira (R$ -7.890,12)
        assertEquals("-R$ 7.890,12", formattedValue)
    }
}
