package idnull.z.myquotes.presentation.quotes_add_edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import idnull.z.myquotes.R
import idnull.z.myquotes.data.App
import idnull.z.myquotes.data.di.viewmodel.injectViewModel
import idnull.z.myquotes.databinding.QuotesAddFragmentBinding
import idnull.z.myquotes.presentation.quotes_main.MainViewModel
import javax.inject.Inject


class QuotesAddFragment : Fragment() {


    private var _binding:QuotesAddFragmentBinding? = null
    private val binding
    get() = _binding ?: throw RuntimeException("QuotesAddFragmentBinding null ")



    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: QuotesAddViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).component.inject(this)
        viewModel = injectViewModel(factory = viewModelFactory)
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QuotesAddFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onResume() {
        super.onResume()
        save()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



    private fun save(){
        binding.saveButton.setOnClickListener {
            val text = binding.etName.text.toString()

            viewModel.save(text)

            findNavController().navigateUp()
        }
    }


}