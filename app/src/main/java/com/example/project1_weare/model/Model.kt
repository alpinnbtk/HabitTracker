package com.example.project1_weare.model

data class Habit(
    var name: String,
    var description: String,
    var goal: Int,
    var unit: String,
    var progress: Int = 0,
    var icon: Int
)