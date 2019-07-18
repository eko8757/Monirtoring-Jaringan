package com.skripsi.monitorjaringan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resource_detail.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ResourceDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource_detail)

        val strJson = "{\n" +
                "\t\"resource_detail\":[\n" +
                "\t  {\n" +
                "\t\t\"built_time\" : \"des/1/2018\",\n" +
                "\t\t\"cpu\" : \"mips 24 kc v7\",\n" +
                "\t\t\"cpu_load\" : \"2\",\n" +
                "\t\t\"platform\" : \"mikrotik\",\n" +
                "\t\t\"version\" : \"6\",\n" +
                "\t\t\"total_memory\":\"4\",\n" +
                "\t  }\n" +
                "   ]\n" +
                "}"

        try {
            val jsonObject = JSONObject(strJson)
            val jsonArray: JSONArray = jsonObject.optJSONArray("resource_detail")
            for (i in 0 until jsonArray.length()) {
                val obj: JSONObject = jsonArray.getJSONObject(i)

                val buildTime = obj.optString("built_time").toString()
                val Cpu = obj.optString("cpu").toString()
                val cpuLoad = obj.optString("cpu_load").toString()
                val platForm = obj.optString("platform").toString()
                val version = obj.optString("versions").toString()
                val totalMemory = obj.optString("total_memory").toString()

                cpu_load.text ="2"
                cpu.text = "idshjf"
                built_time.text = "idshjf"
                platform.text = "idshjf"
                total_memory.text = "idshjf"
                versions.text = "idshjf"
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}
