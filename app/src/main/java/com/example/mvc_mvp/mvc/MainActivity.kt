package com.example.mvc_mvp.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvc_mvp.databinding.ActivityMainBinding
import java.util.*

// Controller vazifasini activity bajaryapti
class MainActivity : AppCompatActivity(), Observer {
    private lateinit var binding: ActivityMainBinding
    private var model: Model? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // MVC -> Model View Controller

        model = Model()
        model?.addObserver(this)
        // View
        binding.apply {

            button1.setOnClickListener {
                // get data ishlayapti
                model?.setValueWithIndex(0)
            }
            button2.setOnClickListener {
                model?.setValueWithIndex(1)
            }
            button3.setOnClickListener {
                model?.setValueWithIndex(2)
            }
        }


    }

    override fun update(p0: Observable?, p1: Any?) {
        // update presentation  ishlayapti
        binding.apply {
            button1.text = model?.getValuesWithIndex(0).toString()
            button2.text = model?.getValuesWithIndex(1).toString()
            button3.text = model?.getValuesWithIndex(2).toString()
        }
    }
}