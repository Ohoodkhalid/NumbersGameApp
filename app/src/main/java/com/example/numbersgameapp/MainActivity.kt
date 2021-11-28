package com.example.numbersgameapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var message = ArrayList<String>()
    var number = 0
    var numberOfTry = 5
    var myListNumber = ArrayList<String>()
    var random = Random.nextInt(0,10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recView = findViewById<RecyclerView>(R.id.recyclerview)
       guessButton.setOnClickListener{

            number=  checkNumber(numberText.text.toString())
         ///  number = numberText.text.toString().toInt()
           if(number==random){
               guessButton.isEnabled = false
               numberText.isActivated = false
               message.add("You guessed $number is correct ")
               myListNumber.add(numberText.text.toString())
               recView.adapter=RecyclerViewAdapter( message  ,myListNumber )
               recView.layoutManager = LinearLayoutManager(this)


           }


                   number=  checkNumber(numberText.text.toString())
               if (number != random) {
                   numberOfTry--
                   message.add("You have $numberOfTry guesses left and your guess is  ")
                   myListNumber.add(numberText.text.toString())
                   recView.adapter = RecyclerViewAdapter( message , myListNumber)
                   recView.layoutManager = LinearLayoutManager(this)

                   if(numberOfTry == 0 ) {
                       guessButton.isEnabled = false
                       numberText.isActivated = false
                   }
               }
           }

        }


    fun checkNumber( number:String):Int{

        try {
           return number.toInt()

        }
        catch(e:Exception){
            println("enter a number only ")
                return 0
        }

    }
}