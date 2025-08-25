package com.ragul.cryptotracker.core.data.networking

import kotlinx.serialization.SerializationException
import com.ragul.cryptotracker.core.domain.util.Result
import com.ragul.cryptotracker.core.domain.util.NetworkError
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.ensureActive
import java.nio.channels.UnresolvedAddressException
import kotlin.coroutines.coroutineContext

// before server call
suspend inline fun <reified T> safeCall (
    execute: () -> HttpResponse
):Result<T, NetworkError> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        return Result.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        return Result.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(NetworkError.UNKNOWN)
    }
    return responseToResult(response)
}
