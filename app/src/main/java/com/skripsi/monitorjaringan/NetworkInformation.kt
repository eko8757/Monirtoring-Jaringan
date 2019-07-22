package com.skripsi.monitorjaringan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries

class NetworkInformation : AppCompatActivity() {

    lateinit var graphView: GraphView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_information)


        graphView = findViewById(R.id.graph_network)
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(arrayOf(
            DataPoint(0.toDouble(), 7.toDouble()),
            DataPoint(2.toDouble(), 4.toDouble()),
            DataPoint(20.toDouble(), 9.toDouble())
        ))
        graphView.addSeries(series)
    }
}
