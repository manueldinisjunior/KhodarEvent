package com.mariomanhique.khodarevent.model

data class EventRequest(
    val description: String,
    val endTime: String,
    val eventDate: String,
    val eventLimit: Int,
    val id: Int,
    val startTime: String,
    val title: String
)
