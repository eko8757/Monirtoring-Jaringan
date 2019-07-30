package com.skripsi.monitorjaringan

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_network_information.*

class NetworkInformation : AppCompatActivity() {

    lateinit var graphView: GraphView
    lateinit var dataBase: FirebaseDatabase
    lateinit var refernce: DatabaseReference
    var point: String = "0"
    lateinit var progress : ProgressDialog
    var totalX: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_information)

        dataBase = FirebaseDatabase.getInstance()
        refernce = dataBase.getReference("network_info")

        refernce.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapShot: DataSnapshot) {
                showData(dataSnapShot)
                Log.d("dataSanpshoot", dataSnapShot.toString())
            }

            override fun onCancelled(dataBaseError: DatabaseError) {
                Log.d("dataBaseError", dataBaseError.toString())
            }
        })
    }

    override fun onStart() {
        super.onStart()
        progress = ProgressDialog(this)
        progress.setMessage("Please wait..")
        progress.show()
    }

    private fun showData(dataSnapShot: DataSnapshot) {
        graphView = findViewById(R.id.graph_network)
        val series: LineGraphSeries<DataPoint> = LineGraphSeries()
        graphView.addSeries(series)
        graphView.viewport.isXAxisBoundsManual = true
        graphView.viewport.setMinX(0.0)
        graphView.viewport.setMaxX(totalX.toDouble())

        for (data in dataSnapShot.children) {
            names1.text = data.child("descr").getValue().toString()
            address1.text = data.child("mac").getValue().toString()

            //set to graphic
            point = data.child("speed").getValue().toString()
            Log.d("point", point)
            val d = DataPoint(totalX.toDouble(), point.toDouble())
            series.appendData(d, true, 10)

            Log.d("totalX", totalX.toString())
            totalX ++

            names2.text = data.child("descr").getValue().toString()
            address2.text = data.child("mac").getValue().toString()
            progress.dismiss()
        }
    }


}
