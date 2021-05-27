package com.dicoding.intentapps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.dicoding.intentapps.model.Person

class MoveWithObject : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)
        val tvObj: TextView = findViewById(R.id.tv_object_received)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text = "Name ${person.name.toString()}, \nEmail ${person.email}, \nUmur ${person.age}, \nKota ${person.city}"
        tvObj.text = text
    }
}