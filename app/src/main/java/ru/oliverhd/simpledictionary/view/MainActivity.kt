package ru.oliverhd.simpledictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjection
import ru.oliverhd.simpledictionary.databinding.ActivityMainBinding
import ru.oliverhd.simpledictionary.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: MainActivityViewModel

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = viewModelFactory.create(MainActivityViewModel::class.java)
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