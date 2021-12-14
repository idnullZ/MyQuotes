package idnull.z.myquotes.presentation.quotes_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import idnull.z.myquotes.R
import idnull.z.myquotes.databinding.FragmentQuotesListBinding


class QuotesListFragment : Fragment() {


    private var _binding:FragmentQuotesListBinding? = null
    private val  binding: FragmentQuotesListBinding
    get () = _binding ?:throw RuntimeException("FragmentQuotesListBinding null ")



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuotesListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.test.setOnClickListener {
            findNavController().navigate(R.id.action_quotesListFragment_to_quotesAddFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}