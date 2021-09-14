package ru.oliverhd.simpledictionary.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ru.oliverhd.simpledictionary.app.App
import ru.oliverhd.simpledictionary.databinding.ActivityMainBinding
import ru.oliverhd.simpledictionary.presenter.Presenter

class MainActivity : AppCompatActivity(), MainView {

    private var binding: ActivityMainBinding? = null
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        presenter = App.instance.mainPresenter
        presenter.attach(this)
        binding?.translateButton?.setOnClickListener {
            presenter.translate(binding?.textInput?.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("translation", binding?.translationTextView?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding?.translationTextView?.text = savedInstanceState.getString("translation")
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showTranslation(translation: String) {
        binding?.translationTextView?.text = translation
    }

    override fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }
}