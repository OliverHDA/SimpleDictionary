package ru.oliverhd.simpledictionary.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.oliverhd.simpledictionary.R
import ru.oliverhd.simpledictionary.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.flFragment.id, MainFragment.newInstance())
                .commitNow()
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> supportFragmentManager.apply {
                    beginTransaction()
                        .replace(R.id.flFragment, MainFragment.newInstance())
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                R.id.navigation_favorite -> supportFragmentManager.apply {
                    beginTransaction()
                        .replace(
                            R.id.flFragment,
                            HistoryAndFavoriteFragment.newInstance("favorite")
                        )
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
                R.id.navigation_history ->
                    supportFragmentManager.apply {
                        beginTransaction()
                            .replace(
                                R.id.flFragment,
                                HistoryAndFavoriteFragment.newInstance("history")
                            )
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                    }
            }
            true
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}