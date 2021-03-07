package ru.self.appkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.title)

        textView.setOnClickListener {
            openSecondActivity()
        }
    }

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        val s = "transmittedString"
        val s1 = "transmittedInt"
        val s2 = "transmittedBool"
        intent.putExtra(s, "string to transmit")
        intent.putExtra(s1, 12)
        intent.putExtra(s2, false)
        startActivity(intent)
//        intent.putExtra("KEY", 1)
//        Log.i("info", "Info")
//        startActivity(intent)
//        startActivityForResult()
    }
}