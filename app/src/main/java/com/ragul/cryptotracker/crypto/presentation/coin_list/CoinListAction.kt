package com.ragul.cryptotracker.crypto.presentation.coin_list

import com.ragul.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClick(val coinUi: CoinUi): CoinListAction
}