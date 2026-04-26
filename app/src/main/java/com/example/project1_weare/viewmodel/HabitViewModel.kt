package com.example.project1_weare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.project1_weare.model.Habit

class HabitViewModel(application: Application) : AndroidViewModel(application) {

    val habits = MutableLiveData<ArrayList<Habit>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    private val habitList = arrayListOf<Habit>()

    fun loadHabits() {
        loading.value = true
        error.value = false

        habits.value = habitList

        loading.value = false
    }

    fun addHabit(habit: Habit) {
        habitList.add(habit)
        habits.value = ArrayList(habitList)
    }

    fun tambahProgress(position: Int) {
        val habit = habitList[position]
        if (habit.progress < habit.goal) {
            habit.progress++
            habits.value = ArrayList(habitList)
        }
    }

    fun kurangProgress(position: Int) {
        val habit = habitList[position]
        if (habit.progress > 0) {
            habit.progress--
            habits.value = ArrayList(habitList)
        }
    }
}