package com.sprytech.birthdaychallenge.utils

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource2.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { Resource2.Success(it) }
        } catch (throwable: Throwable) {
            query().map { Resource2.Error(throwable, it) }
        }
    } else {
        query().map { Resource2.Success(it) }
    }

    emitAll(flow)
}