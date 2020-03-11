package com.example.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        validate()
    }

    fun validate(){
        var scoreTotal:Int = 0
        var wordList = mutableListOf<String>()
        wordList.add("Bonjour")
        wordList.add("Ordinateur")
        wordList.add("Piano")
        var wordGenerator = WordGenerator(wordList)
        var word:String = ""
        validateBtn.setOnClickListener{
            word = wordGenerator.generateWord()
            generatedWord.text = word;
            if(userWord.text.toString().equals(word)){
                Toast.makeText(this,"Bravo !!!! Vous avez obtenu 5 points", Toast.LENGTH_SHORT).show()
                scoreTotal+=5
                scoreValue.text = scoreTotal.toString()
            }
            else
                Toast.makeText(this,"Echec !!!! Le mot saisi n’est pas le bon", Toast.LENGTH_SHORT).show()
        }
    }

}
