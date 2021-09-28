package com.example.twoinoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var numButton : Button
    private lateinit var phrButton : Button
    private lateinit var clMain : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        phrButton = findViewById(R.id.phraseGButton)
        numButton = findViewById(R.id.numberGButton)
        clMain = findViewById(R.id.clMain)

        phrButton.setOnClickListener {
            val intent = Intent(this, PhraseGameActivity::class.java)
            startActivity(intent)
        }
        numButton.setOnClickListener {
            val intent = Intent(this, NumbersGameActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menuPhrGame -> {
                val intent = Intent(this, PhraseGameActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuNumGame -> {
                val intent = Intent(this, NumbersGameActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuMain -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}