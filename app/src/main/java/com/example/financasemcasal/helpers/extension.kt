package com.example.financasemcasal

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

fun BigDecimal.formatForBrazilianCurrency(): String {
    val formatRealCurrency = DecimalFormat.getCurrencyInstance(Locale("pt", "BR"))
    return formatRealCurrency.format(this)
}