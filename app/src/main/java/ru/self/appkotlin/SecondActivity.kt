package ru.self.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val stringExtra = intent.getStringExtra(s)
        val intExtra = intent.getIntExtra(s1, -1)
        val booleanExtra = intent.getBooleanExtra(s2, false)

        val findViewById: TextView = findViewById(R.id.second_activity_text_view)
        findViewById.text =
            "These values were passed from previous screen: transmittedString: " +
                    "$stringExtra, transmittedInt: " +
                    "$intExtra, transmittedBoolean: " +
                    "$booleanExtra"
    }

    companion object {
        const val s = "transmittedString"
        const val s1 = "transmittedInt"
        const val s2 = "transmittedBool"
    }
}