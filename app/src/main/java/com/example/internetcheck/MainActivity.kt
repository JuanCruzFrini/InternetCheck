package com.example.internetcheck

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.internetcheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val checkConnection by lazy { CheckConnection(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            checkConnection.observe(this@MainActivity){
                if (it){
                    binding.txtConectivity.setTextColor(resources.getColor(R.color.green))
                    binding.txtConectivity.text = "Conectado :)"
                } else {
                    binding.txtConectivity.setTextColor(resources.getColor(R.color.red))
                    binding.txtConectivity.text = "Desconectado :("
                }
            }
        }
    }
}