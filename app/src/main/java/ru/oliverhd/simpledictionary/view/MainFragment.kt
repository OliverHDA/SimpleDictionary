package ru.oliverhd.simpledictionary.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.oliverhd.simpledictionary.databinding.MainFragmentBinding
import ru.oliverhd.simpledictionary.viewmodel.MainFragmentViewModel

class MainFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by inject()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData()
            .observe(
                viewLifecycleOwner,
                { translation -> binding.translationTextView.text = translation })
        binding.translateButton.setOnClickListener {
            viewModel.getData(binding.inputEditText.text.toString())
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }

}