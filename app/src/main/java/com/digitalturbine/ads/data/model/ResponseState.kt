package com.digitalturbine.ads.data.model

sealed class ResponseState {
    data class Success(val list: List<Ad>): ResponseState()
    data class Error(val error: String?): ResponseState()
    object Empty: ResponseState()
    object Loading: ResponseState()
}