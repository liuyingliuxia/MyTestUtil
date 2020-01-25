package com.mmm.mytestutil.music_play

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.session.MediaSession
import android.media.session.PlaybackState
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi

object MusicService:Service() {
    private lateinit var mPlaybackState: PlaybackState
    private lateinit var mMediaSession: MediaSession
    private lateinit var mMediaPlayer: MediaPlayer
    const val SESSION_TAG = "SESSION_TAG"


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun initService(context : Context){
        mPlaybackState = PlaybackState.Builder()
            .setState(PlaybackState.STATE_NONE , 0,1.0f)
            .build()
        mMediaSession = MediaSession(context , SESSION_TAG)
       // mMediaSession.setCallback(mMediaSessionCallback)

        mMediaSession.isActive = true
//        mMediaSession.setFlags(MediaSession.FLAG_HANDLES_MEDIA_BUTTONS||
//        MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS)
        mMediaSession.setPlaybackState(mPlaybackState)


    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
   // private val mMediaSessionCallback = MediaSession.Callback()
}