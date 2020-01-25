package com.mmm.mytestutil.music_play

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.BaseColumns
import android.provider.MediaStore
import java.io.FileNotFoundException
import java.io.InputStream

/**
 * 扫描歌曲
 */
internal class MusicUtil {
   // private lateinit var path : String

    companion object {
        @SuppressLint("InlinedApi")
        fun scanMusic(context: Context, musicList: MutableList<Music?>) {
            musicList.clear()
            val cursor = context.contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arrayOf(
                    BaseColumns._ID,
                    MediaStore.Audio.AudioColumns.IS_MUSIC,
                    MediaStore.Audio.AudioColumns.TITLE,
                    MediaStore.Audio.AudioColumns.ARTIST,
                    MediaStore.Audio.AudioColumns.ALBUM,
                    MediaStore.Audio.AudioColumns.ALBUM_ID,
                    MediaStore.Audio.AudioColumns.DISPLAY_NAME,
                    MediaStore.Audio.AudioColumns.SIZE,
                    MediaStore.Audio.AudioColumns.DURATION
                ),
                null,
                null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER
            )
                ?: return // 为空就停止
            while (cursor.moveToNext()) { // 是否为音乐
                val isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC))
                if (isMusic == 0) {
                    continue
                }
                val id =
                    cursor.getLong(cursor.getColumnIndex(BaseColumns._ID))
                // 标题
                val title =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE))
                // 艺术家
                val artist =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST))
                // 专辑
                val album =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM))
                // 专辑封面id，根据该id可以获得专辑封面图片
                val albumId =
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM_ID))
                // 持续时间
                val duration =
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))
                // 音乐文件路径
                val path =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATE_TAKEN))
                // 音乐文件名
                val fileName =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DISPLAY_NAME))
                // 音乐文件大小
                val fileSize =
                    cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE))
                val music = Music()
                music.id = id
                music.title = title
                music.singer = artist
                music.album = album
                music.albumId = albumId
                music.duration = duration
                music.path = path
                music.fileName = fileName
                music.fileSize = fileSize
                musicList.add(music)
            }
            cursor.close()
        }

        /**
         * 从媒体库加载封面
         */
       /* fun loadCoverFromMediaStore(context: Context , albumId: Long): Bitmap? {
            val resolver: ContentResolver = context.contentResolver
            val uri: Uri = MusicUtils.getMediaStoreAlbumCoverUri(albumId)
            val `is`: InputStream
            `is` = try {
                resolver.openInputStream(uri)!!
            } catch (ignored: FileNotFoundException) {
                return null
            }
            val options: BitmapFactory.Options = BitmapFactory.Options()
            options.inPreferredConfig = Bitmap.Config.RGB_565
            return BitmapFactory.decodeStream(`is`, null, options)
        }*/
    }
}