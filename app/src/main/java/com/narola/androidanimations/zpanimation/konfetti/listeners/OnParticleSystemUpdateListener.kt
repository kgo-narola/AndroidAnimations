package com.alarmmanager.zpanimation.konfetti.listeners

import com.alarmmanager.zpanimation.konfetti.KonfettiView
import com.alarmmanager.zpanimation.konfetti.ParticleSystem

/**
 * Created by dionsegijn on 5/31/17.
 */
interface OnParticleSystemUpdateListener {
    fun onParticleSystemStarted(view: KonfettiView, system: ParticleSystem, activeSystems: Int)
    fun onParticleSystemEnded(view: KonfettiView, system: ParticleSystem, activeSystems: Int)
}
