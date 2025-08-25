package com.ragul.cryptotracker.di

import com.ragul.cryptotracker.core.data.networking.httpClientFactory
import com.ragul.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import com.ragul.cryptotracker.crypto.domain.CoinDataSource
import com.ragul.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { httpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}