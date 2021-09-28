package com.example.twoinoneapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_numbers_game.*
import kotlin.random.Random

class NumbersGameActivity : AppCompatActivity() {
    private lateinit var myCL: ConstraintLayout
    private lateinit var myET: EditText
    private lateinit var myButton: Button
    private lateinit var mylist: ArrayList<String>
    private val randomNumber: Int = Random.nextInt(11)
    private var numberOfGuesses = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers_game)

        myCL = findViewById(R.id.clRoot)
        mylist = ArrayList()

        rvList.adapter = MessageAdapter(this, mylist)
        rvList.layoutManager = LinearLayoutManager(this)

        myET = findViewById(R.id.etEntry)
        myButton = findViewById(R.id.okButton)

        myButton.setOnClickListener { Guess() }

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

    private fun Guess() {
        var guess = myET.text.toString()
        if (guess.isNotEmpty() && guess.isDigitsOnly()) {
            checkGuess(guess.toInt())
            myET.text.clear()
            myET.clearFocus()
            rvList.adapter?.notifyDataSetChanged()
            TODO("ADD A CLOSING (sTOP TAKING INPUT FUN)")
        }
        else {
            Snackbar.make(clRoot, "Please enter a number only!", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun checkGuess(guess:Int){
        mylist.add("You have guessed $guess")
        if (guess == randomNumber){
            mylist.add("CORRECT!! AMAZING!!")
        }
        else{
            numberOfGuesses--
            mylist.add("WRONG!! You have $numberOfGuesses guesses left!!")
            if(numberOfGuesses == 0) {mylist.add("GAME OVER!!")}
        }
    }

}