package com.yunusemre.simplereflexgame

import android.graphics.Color.green
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    var button1: Button? = null
    var button2: Button? = null
    var relativeLayout: RelativeLayout? = null

    var runnable = Runnable {
        relativeLayout!!.setBackgroundResource(R.color.teal_200)


        val time = System.currentTimeMillis()


        button2!!.setOnClickListener {
            val time1 = System.currentTimeMillis()


            Toast.makeText(
                applicationContext,
                "Senin reflexin  " + (time1 - time) + "  saniyede çalışıyor.",
                Toast.LENGTH_LONG
            ).show()

            relativeLayout!!.setBackgroundResource(0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        relativeLayout = findViewById(R.id.rlVar1)
        button1 = findViewById(R.id.btVar1)
        button2 = findViewById(R.id.btVar2)

        button1!!.setOnClickListener(View.OnClickListener {
            val random = Random()
            val num = random.nextInt(10)

            val handler = Handler()
            handler.postDelayed(runnable, (num * 1000).toLong())
        })
    }
}
