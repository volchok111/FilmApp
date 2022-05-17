package com.example.films.ui.home

import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.films.R

open class HomeFragment : MvpAppCompatFragment(), HomeView {
    override fun onRequestStart() {

    }

    override fun onRequestComplete() {

    }

    override fun onRequestError(message: Int) {
        Toast.makeText(context, getString(message), Toast.LENGTH_LONG).show()
    }

    override fun onConnectionAbsence() {
        context.let {
            Toast.makeText(
                it,
                getString(R.string.error_connection_absence), Toast.LENGTH_LONG
            ).show()
        }
    }

}