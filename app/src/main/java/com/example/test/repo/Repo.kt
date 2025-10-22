package com.example.test.repo

import com.example.test.model.DataModel
import com.example.test.model.SSEStatus
import com.example.test.repo.network.ApiService
import com.example.test.repo.network.ApiServiceImpl
import com.google.gson.Gson
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive

class Repo {
    private val apiService: ApiService

    init {
        val api = ApiServiceImpl()
        apiService = api.getApiService()
    }

    private val _sseStatus = MutableStateFlow<SSEStatus>(SSEStatus.isLoading)
    val sseStatus: StateFlow<SSEStatus> = _sseStatus.asStateFlow()

    fun queryMessage(message: String): Flow<DataModel> = flow {
        val response = apiService.getPosts(message)

        val input = response.byteStream().bufferedReader()

        try {
            while (currentCoroutineContext().isActive) {
                val line = input.readLine() ?: continue
                if (line.startsWith("data:")) {
                    try {
                        val data = Gson().fromJson(
                            line.substring(5).trim(),
                            DataModel::class.java
                        )
                        emit(data)
                    } catch (e: Exception) {
                        throw (e)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            input.close()
        }
    }
}