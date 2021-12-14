package idnull.z.myquotes.presentation.quotes_add_edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import idnull.z.myquotes.R
import idnull.z.myquotes.databinding.QuotesAddFragmentBinding

class QuotesAddFragment : Fragment() {


    private var _binding:QuotesAddFragmentBinding? = null
    private val binding
    get() = _binding ?: throw RuntimeException("QuotesAddFragmentBinding null ")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = QuotesAddFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}