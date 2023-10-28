package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count = 0
    var increment = true

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateText()

        binding.btPlusMinus.setOnClickListener {
            if (increment) {
                count++
            } else {
                count--
            }

            if (count == 10) {
                increment = false
                    binding.btPlusMinus.text = "-1"
            }

            if (count == 0 && !increment) {
                val intent = Intent(this, BlankFragment::class.java)
                startActivity(intent)
            }

            updateText()
        }
    }

    private fun updateText() {
        binding.tvAge.text = count.toString()
    }
}
