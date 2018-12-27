package com.mengsoftstudio.exampleapp.views.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mengsoftstudio.exampleapp.R
import com.mengsoftstudio.exampleapp.models.AndroidNote
import kotlinx.android.synthetic.main.adapter_android_note.view.*

class MainAdapter(private val mContext: Context,
                  private val mListNote: List<AndroidNote>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainAdapter.ViewHolder =
            ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter_android_note, p0, false))

    override fun getItemCount(): Int =
            mListNote.size

    override fun onBindViewHolder(p0: MainAdapter.ViewHolder, p1: Int) {
        p0.bindAndroidNotes(mListNote[p1])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindAndroidNotes(androidNote: AndroidNote) {

            itemView.androidNameText.text = androidNote.androidName
            itemView.androidVersionText.text = androidNote.androidVersion
            itemView.androidReleaseText.text = androidNote.androidRelease

        }

    }

}