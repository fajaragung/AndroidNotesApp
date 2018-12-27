package com.mengsoftstudio.exampleapp.views.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.mengsoftstudio.exampleapp.R
import com.mengsoftstudio.exampleapp.contracts.AndroidNoteContract
import com.mengsoftstudio.exampleapp.extensions.gone
import com.mengsoftstudio.exampleapp.extensions.visible
import com.mengsoftstudio.exampleapp.models.AndroidNote
import com.mengsoftstudio.exampleapp.presenters.AndroidNotePresenter
import com.mengsoftstudio.exampleapp.views.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AndroidNoteContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter = AndroidNotePresenter(this)
        presenter.getListAndroidNotes()

        refreshMain.setOnRefreshListener {
            presenter.getListAndroidNotes()
        }

    }

    override fun showLoading() {
        progressView.visible()
        listAndroidNotes.gone()
    }

    override fun listAndroidNotes(listNotes: List<AndroidNote>) {

        listAndroidNotes.layoutManager = LinearLayoutManager(this@MainActivity)
        listAndroidNotes.adapter = MainAdapter(this@MainActivity, listNotes)
        (listAndroidNotes.adapter as MainAdapter).notifyDataSetChanged()

    }

    override fun hideLoading() {
        progressView.gone()
        listAndroidNotes.visible()

        refreshMain.isRefreshing = false

    }

}