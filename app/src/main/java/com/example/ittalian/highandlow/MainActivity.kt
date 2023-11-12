package com.example.ittalian.highandlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ittalian.highandlow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val tag = "high and low"
    private var yourCard = 0
    private var droidCard = 0
    private var hitCount = 0
    private var loseCount = 0
    private var gameStart = false
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.highBtn.setOnClickListener {
            if ((gameStart && !answered))
                highAndLow('h')
        }

        binding.lowBtn.setOnClickListener {
            if ((gameStart && !answered))
                highAndLow('l')
        }

        binding.nextBtn.setOnClickListener {
            if (gameStart)
                drawCard()
        }
    }

    override fun onResume() {
        super.onResume()
        hitCount = 0
        loseCount = 0
        binding.hitText.text = getString(R.string.hit_text)
        binding.loseText.text = getString(R.string.lose_text)
        gameStart = true
        drawCard()
    }

    private fun drawCard(){
        binding.yourCardImage.setImageResource(R.drawable.z02)
        binding.droidCardImage.setImageResource(R.drawable.z01)
        yourCard = (1..13).random()
        Log.d(tag,"You:" + yourCard)
        when(yourCard){
            1 -> binding.yourCardImage.setImageResource(R.drawable.d01)
            2 -> binding.yourCardImage.setImageResource(R.drawable.d02)
            3 -> binding.yourCardImage.setImageResource(R.drawable.d03)
            4 -> binding.yourCardImage.setImageResource(R.drawable.d04)
            5 -> binding.yourCardImage.setImageResource(R.drawable.d05)
            6 -> binding.yourCardImage.setImageResource(R.drawable.d06)
            7 -> binding.yourCardImage.setImageResource(R.drawable.d07)
            8 -> binding.yourCardImage.setImageResource(R.drawable.d08)
            9 -> binding.yourCardImage.setImageResource(R.drawable.d09)
            10 -> binding.yourCardImage.setImageResource(R.drawable.d10)
            11 -> binding.yourCardImage.setImageResource(R.drawable.d11)
            12 -> binding.yourCardImage.setImageResource(R.drawable.d12)
            13 -> binding.yourCardImage.setImageResource(R.drawable.d13)
        }
        droidCard = (1..13).random()
        Log.d(tag,"droid:" + droidCard)
        answered = false
    }

    private fun highAndLow(answer : Char) {
        showDroidCard()
        answered = true
        val balance = droidCard - yourCard
        if (balance == 0){

        } else if ((balance > 0 && answer == 'h') || (balance < 0 && answer == 'l')){
            hitCount++
            binding.hitText.text = getString(R.string.hit_text) + hitCount
        } else {
            loseCount++
            binding.loseText.text = getString(R.string.lose_text) + loseCount
        }

        if (hitCount == 5){
            binding.resultText.text = "あなたの勝ちです"
            gameStart = false
        } else if (loseCount == 5){
            binding.resultText.text = "あなたの負けです"
            gameStart = false
        }
    }

    private fun showDroidCard() {
        when(droidCard){
            1 -> binding.droidCardImage.setImageResource(R.drawable.c01)
            2 -> binding.droidCardImage.setImageResource(R.drawable.c02)
            3 -> binding.droidCardImage.setImageResource(R.drawable.c03)
            4 -> binding.droidCardImage.setImageResource(R.drawable.c04)
            5 -> binding.droidCardImage.setImageResource(R.drawable.c05)
            6 -> binding.droidCardImage.setImageResource(R.drawable.c06)
            7 -> binding.droidCardImage.setImageResource(R.drawable.c07)
            8 -> binding.droidCardImage.setImageResource(R.drawable.c08)
            9 -> binding.droidCardImage.setImageResource(R.drawable.c09)
            10 -> binding.droidCardImage.setImageResource(R.drawable.c10)
            11 -> binding.droidCardImage.setImageResource(R.drawable.c11)
            12 -> binding.droidCardImage.setImageResource(R.drawable.c12)
            13 -> binding.droidCardImage.setImageResource(R.drawable.c13)
        }
    }
}