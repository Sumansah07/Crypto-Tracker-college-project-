package com.ragul.cryptotracker.core.data.networking

import com.ragul.cryptotracker.core.domain.util.NetworkError
import com.ragul.cryptotracker.core.domain.util.Result
import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.tryCopyException

//kto client extension function
// after server call
suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, NetworkError> {
    return when(response.status.value){
        // request success
        in 200..299 ->{
            try{
                Result.Success(response.body<T>())
            } catch (e: NoTransformationFoundException){
                Result.Error(NetworkError.SERIALIZATION)
            }
        }
        // request timeout
        408 -> Result.Error(NetworkError.REQUEST_TIMEOUT)
        // request rate limit
        429 -> Result.Error(NetworkError.TOO_MANY_REQUESTS)
        // server error
        in 500..599 -> Result.Error(NetworkError.SERVER_ERROR)
        else -> Result.Error(NetworkError.UNKNOWN)
    }
}