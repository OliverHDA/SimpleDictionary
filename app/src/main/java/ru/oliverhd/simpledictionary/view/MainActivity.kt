package ru.oliverhd.simpledictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import ru.oliverhd.simpledictionary.databinding.ActivityMainBinding
import ru.oliverhd.simpledictionary.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by inject()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getLiveData()
            .observe(this, { translation -> binding.translationTextView.text = translation })
        binding.translateButton.setOnClickListener {
            viewModel.getData(binding.textInput.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("translation", binding.translationTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.translationTextView.text = savedInstanceState.getString("translation")
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}