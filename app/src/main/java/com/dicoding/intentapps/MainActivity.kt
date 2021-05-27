package com.dicoding.intentapps

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.dicoding.intentapps.model.Person

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        val btnMoveWithData: Button = findViewById(R.id.btn_move_activity_data)
        val btnMoveObject: Button = findViewById(R.id.btn_move_activity_object)
        val btnDial:Button = findViewById(R.id.btn_dial_number)
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveObject.setOnClickListener(this)
        btnDial.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveIntent = Intent(this@MainActivity, MoveWithData::class.java)
                moveIntent.putExtra(MoveWithData.EXTRA_NAME, "Rofiyanto")
                moveIntent.putExtra(MoveWithData.EXTRA_AGE, 25)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_object  -> {
                val moveIntent = Intent(this@MainActivity, MoveWithObject::class.java)
                val person = Person(
                    "Rofiyanto",
                    25,
                    "pradiktabagus@gmail.com",
                    "Jakarta"
                )
                moveIntent.putExtra(MoveWithObject.EXTRA_PERSON, person)
                startActivity(moveIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumbeer = "081210841382"
                val dialPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumbeer"))
                startActivity(dialPhone)
            }
        }
    }
}