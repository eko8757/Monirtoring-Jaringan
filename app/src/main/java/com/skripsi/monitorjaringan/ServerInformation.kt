package com.skripsi.monitorjaringan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_server_information.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ServerInformation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_information)

        val strJson = "{\n" +
                "\t\"server_information\":[\n" +
                "\t  {\n" +
                "\t\t\"location\" : \"indonesia\",\n" +
                "\t\t\"os\" : \"linux\",\n" +
                "\t\t\"server_ip\" : \"192.168.1.1\",\n" +
                "\t\t\"server_port\" : 8080,\n" +
                "\t\t\"snmp_com\" : \"-\",\n" +
                "\t\t\"system_name\" : \"polinema\" \n" +
                "\t  }\n" +
                "   ]\n" +
                "}"

        try {
            val jsonObject = JSONObject(strJson)
            val jsonArray: JSONArray = jsonObject.optJSONArray("server_information")
            for (i in 0 until jsonArray.length()) {
                val obj: JSONObject = jsonArray.getJSONObject(i)

                val ip = obj.optString("server_ip").toString()
                val ports = obj.optString("server_port").toString()
                val lokasi = obj.optString("location").toString()
                val os = obj.optString("os").toString()
                val snmp = obj.optString("snmp_com").toString()
                val system = obj.optString("system_name").toString()

                txt_IP.setText(ip)
                txt_Ports.setText(ports)
                txt_Location.setText(lokasi)
                txt_Operating.setText(os)
                txt_SNMP.setText(snmp)
                txt_System.setText(system)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}
