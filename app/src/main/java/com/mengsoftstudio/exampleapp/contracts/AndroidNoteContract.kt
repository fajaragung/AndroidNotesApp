package com.mengsoftstudio.exampleapp.contracts

import com.mengsoftstudio.exampleapp.models.AndroidNote

interface AndroidNoteContract {

    interface View {

        fun showLoading()
        fun listAndroidNotes(listNotes: List<AndroidNote>)
        fun hideLoading()

    }

    interface Presenter {

        fun getListAndroidNotes()

    }

}