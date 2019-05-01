package kz.kyrmyzyanik.userdetail.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kz.kyrmyzyanik.userdetail.UserDetailApplication

/**
 * Object describes injectable fields of Fragments and Activities that implemented [Injectable]
 */

object Injector {
    fun init(app: UserDetailApplication) {
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                handleActivity(activity)
            }
            override fun onActivityStarted(activity: Activity) {}

            override fun onActivityResumed(activity: Activity) {}

            override fun onActivityPaused(activity: Activity) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {}

            override fun onActivityDestroyed(activity: Activity) {}
        })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is Injectable) {
            AndroidInjection.inject(activity)
        }

        if (activity is FragmentActivity) {
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(
                                fm: androidx.fragment.app.FragmentManager,
                                f: androidx.fragment.app.Fragment,
                                savedInstanceState: Bundle?) {
                            if (f is Injectable) {
                                AndroidSupportInjection.inject(f)
                            }
                        }
                    }, true)
        }
    }
}