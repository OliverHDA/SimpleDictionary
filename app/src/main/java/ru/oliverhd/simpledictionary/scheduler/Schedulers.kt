package ru.oliverhd.simpledictionary.scheduler

import io.reactivex.Scheduler

interface Schedulers {

    fun background(): Scheduler
    fun main(): Scheduler
}