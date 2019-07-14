package com.skripsi.monitorjaringan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.GraphView

class NetworkInformation : AppCompatActivity() {

    lateinit var graph: GraphView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_information)
    }


}
