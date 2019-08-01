package com.lukasdylan.demokotlinmpp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.engine.okhttp.OkHttpEngine
import io.ktor.util.InternalAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.serialization.UnstableDefault
import sharedcode.viewmodel.SharedLeagueViewModel

@UnstableDefault
@InternalAPI
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MainAdapter()
        rv_leagues?.layoutManager = LinearLayoutManager(this)
        rv_leagues?.adapter = adapter
        val viewModel = SharedLeagueViewModel(engine = OkHttpEngine(OkHttpConfig()))
        viewModel.leagueList.asNativeLiveData().observe(this, Observer {
            adapter.submit(it.map { it.strLeague.orEmpty() })
        })
        viewModel.loadLeagueList()
    }
}