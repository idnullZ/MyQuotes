package idnull.z.myquotes.presentation.quotes_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import idnull.z.myquotes.R
import idnull.z.myquotes.data.App
import idnull.z.myquotes.data.di.viewmodel.injectViewModel
import idnull.z.myquotes.databinding.MainFragmentBinding
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
    get () = _binding ?: throw RuntimeException("MainFragmentBinding null  ")

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).component.inject(this)
        viewModel = injectViewModel(factory = viewModelFactory)
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.test.text = viewModel.result
    }

    override fun onStart() {
        super.onStart()
        binding.test.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_quotesListFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }




}