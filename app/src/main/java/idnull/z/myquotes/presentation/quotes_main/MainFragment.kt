package idnull.z.myquotes.presentation.quotes_main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import idnull.z.myquotes.R
import idnull.z.myquotes.data.App
import idnull.z.myquotes.data.DI.AppComponent
import idnull.z.myquotes.data.DI.DaggerAppComponent
import idnull.z.myquotes.databinding.MainFragmentBinding
import idnull.z.myquotes.domain.usecase.MainScreenUseCase
import javax.inject.Inject

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
    get () = _binding ?: throw RuntimeException("MainFragmentBinding null  ")



    val component by lazy {
        DaggerAppComponent.builder().context(requireContext().applicationContext).build()
    }

        //val viewModel:MainViewModel by viewModels()

    @Inject
    lateinit var useCase: MainScreenUseCase


    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
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
        binding.test.text = useCase.test1
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