package com.mengsoftstudio.exampleapp.presenters

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mengsoftstudio.exampleapp.contracts.AndroidNoteContract
import com.mengsoftstudio.exampleapp.models.AndroidNote

class AndroidNotePresenter(private val mView: AndroidNoteContract.View) : AndroidNoteContract.Presenter {

    private val mAndroidNote = mutableListOf<AndroidNote>()

    override fun getListAndroidNotes() {

        val dbRef = FirebaseDatabase.getInstance().reference
                .child("androidLevel")

        mView.showLoading()
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {}

            override fun onDataChange(p0: DataSnapshot) {

                mAndroidNote.clear()
                for(children in p0.children) {

                    mAndroidNote.add(
                            AndroidNote(
                                    children.child("androidName").getValue(String::class.java),
                                    children.child("androidVersion").getValue(String::class.java),
                                    children.child("androidRelease").getValue(String::class.java)
                            )
                    )

                    mView.listAndroidNotes(mAndroidNote)

                }

                mView.hideLoading()

            }

        })

    }

}