package com.ragul.cryptotracker.crypto.presentation.coin_list

import com.ragul.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}