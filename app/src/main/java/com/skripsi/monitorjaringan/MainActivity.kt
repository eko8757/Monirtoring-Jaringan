package com.skripsi.monitorjaringan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        card_server.setOnClickListener {
            Toast.makeText(this, "Server Info", Toast.LENGTH_SHORT).show()
            val i = Intent(this, ServerInformation::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        card_network.setOnClickListener {
            Toast.makeText(this, "Network Info", Toast.LENGTH_SHORT).show()
            val i = Intent(this, NetworkInformation::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        card_bandwidth.setOnClickListener {
            Toast.makeText(this, "Bandwith Usage", Toast.LENGTH_SHORT).show()
            val i = Intent(this, BandwidthUsage::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        card_resource.setOnClickListener {
            Toast.makeText(this, "Resource Detail", Toast.LENGTH_SHORT).show()
            val i = Intent(this, ResourceDetail::class.java)
            startActivity(i)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        card_about.setOnClickListener {
            Toast.makeText(this, "About", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
        val view: View = layoutInflater.inflate(R.layout.custom_dialog, null)
        val btn1: Button = view.findViewById(R.id.btn_ya_exit)
        val btn2: Button = view.findViewById(R.id.btn_batal_exit)
        builder.setView(view)

        val alert: AlertDialog = builder.create()
        alert.show()

        btn1.setOnClickListener {
            Toast.makeText(this, "Keluar", Toast.LENGTH_SHORT).show()
            finish()
        }

        btn2.setOnClickListener {
            Toast.makeText(this, "Batal", Toast.LENGTH_SHORT).show()
            alert.dismiss()
        }
    }
}
