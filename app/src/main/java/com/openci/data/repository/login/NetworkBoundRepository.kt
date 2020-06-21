package com.openci.data.repository.login

import androidx.annotation.MainThread
import com.openci.utils.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import retrofit2.Response

/**
 * A repository which provides resource from local database as well as remote end point.
 *
 * [RESULT] represents the type for database.
 * [REQUEST] represents the type for network.
 */
@ExperimentalCoroutinesApi
abstract class NetworkBoundRepository<RESULT, REQUEST> {

    fun asFlow() = flow<State<RESULT>> {

        // Emit Loading State
        emit(State.loading())

        try {
            // Fetch github access token
            val apiResponse = fetchFromRemote()

            // Parse body
            val accessToken = apiResponse.body()

            // Check for response validation
            if (apiResponse.isSuccessful && accessToken != null) {
                // Save posts into the persistence storage
                emit(State.success(getAccessToken(accessToken)))
            } else {
                // Something went wrong! Emit Error state.
                emit(State.error(apiResponse.message()))
            }
        } catch (e: Exception) {
            // Exception occurred! Emit error
            emit(State.error("Network error! Can't get latest posts."))
            e.printStackTrace()
        }
    }

    /**
     * Fetches [Response] from the remote end point.
     */
    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>

    /**
     * Returns parsed [Response] from the remote end point.
     */
    @MainThread
    protected abstract fun getAccessToken(accessToken: REQUEST): RESULT
}