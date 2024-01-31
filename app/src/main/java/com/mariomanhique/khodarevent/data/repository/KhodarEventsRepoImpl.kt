package com.mariomanhique.khodarevent.data.repository;

import android.util.Log
import com.mariomanhique.khodarevent.model.AuthenticationRequest
import com.mariomanhique.khodarevent.model.Community
import com.mariomanhique.khodarevent.model.Event
import com.mariomanhique.khodarevent.model.EventRequest
import com.mariomanhique.khodarevent.network.KhodarEventsApi
import javax.inject.Inject

class KhodarEventsRepoImpl @Inject constructor (private val api: KhodarEventsApi): KhodarEventsRepoInterface {
    override suspend fun getCommunities(): List<Community> {
        Log.d("Communities", "getCommunities: ${api.getCommunities()}")
        return api.getCommunities()
    }

    override suspend fun getEvents(): List<Event> {
        return api.getEvents()
    }

    override suspend fun getEventsByCommunityId(communityId: Int): List<Event> {
        return api.getEventsByCommunityId(communityId)
    }

    override suspend fun authenticateUser(email: String, password: String): String? {
        return try {
            val response = api.authenticateUser(AuthenticationRequest(email, password))

            if (response.isSuccessful) {
                Log.d("Authentication ", "authenticateUser:${response.body()} ")
                response.body()?.accessToken

                // Handle the token
            } else {
                // Handle the error response
                val errorBody = response.errorBody()?.string()
                Log.d("Authentication ", "error:$errorBody ")
                errorBody
            }
        } catch (e: Exception){
            e.message.toString()
        }

    }

    override suspend fun createEvent(
        authorizationHeader: String,
        communityId: Long,
        eventRequest: EventRequest
    ): String {
        return try {
            val response = api.createEvent(
                authorizationHeader = authorizationHeader,
                communityId = communityId,
                request = eventRequest
            )

            if (response.isSuccessful){
                response.body()?.responseCode.toString()
            } else{
                response.errorBody().toString()
            }
        } catch (e: Exception){
            e.message.toString()
        }


    }
}

