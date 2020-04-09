package com.example.exo3

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        var uWord = userWord.text.toString()
        var gWord = generatedWord.text.toString()
        var sValue = scoreValue.text.toString().toInt()
        outState.putString("uWord", uWord)
        outState.putString("gWord", gWord)
        outState.putInt("sValue",sValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        var uWord = savedInstanceState?.getString("uWord")
        var gWord = savedInstanceState?.getString("gWord")
        var sValue =    savedInstanceState?.getInt("sValue")
        userWord.setText(uWord)
        generatedWord.text = gWord
        scoreValue.text = sValue.toString()
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
