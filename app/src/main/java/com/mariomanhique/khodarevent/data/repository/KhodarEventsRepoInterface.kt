package com.mariomanhique.khodarevent.data.repository

import com.mariomanhique.khodarevent.model.Community
import com.mariomanhique.khodarevent.model.Event
import com.mariomanhique.khodarevent.model.EventRequest

interface KhodarEventsRepoInterface {

    suspend fun getCommunities(): List<Community>

    suspend fun getEvents(): List<Event>
    suspend fun getEventsByCommunityId(communityId: Int): List<Event>

    suspend fun authenticateUser(email: String, password: String): String?

    suspend fun createEvent(
        authorizationHeader: String,
        communityId: Long,
        eventRequest: EventRequest
    ): String

}
