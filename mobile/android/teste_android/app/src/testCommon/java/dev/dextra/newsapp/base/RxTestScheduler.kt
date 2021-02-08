package dev.dextra.newsapp.base

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.functions.Function
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

import java.util.concurrent.Callable

object RxTestScheduler {

    //confire RxJava to run synchronously
    fun init() {
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(androidScheduler())

        RxJavaPlugins.reset()
        RxJavaPlugins.setIoSchedulerHandler(scheduler())
        RxJavaPlugins.setNewThreadSchedulerHandler(scheduler())
    }

    private fun androidScheduler(): Function<Callable<Scheduler>, Scheduler> {
        return Function { Schedulers.trampoline() }
    }

    private fun scheduler(): Function<in Scheduler, out Scheduler> {
        return Function { Schedulers.trampoline() }
    }
}
