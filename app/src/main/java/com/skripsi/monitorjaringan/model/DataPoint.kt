package com.skripsi.monitorjaringan.model

import java.io.Serializable
import com.jjoe64.graphview.series.DataPointInterface
import java.util.*

class DataPoint(x: Date, private var y: Double) : DataPointInterface, Serializable {

    private var x: Double = 0.toDouble()

    init {
        this.x = x.getTime().toDouble()
    }

    override fun getX(): Double {
        return x
    }

    override fun getY(): Double {
        return y
    }

    override fun toString(): String {
        return "[$x/$y]"
    }

    companion object {
        private val serialVersionUID = 1428263322645L
    }
}
