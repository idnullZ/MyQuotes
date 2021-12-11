package idnull.z.myquotes.presentation.quotes_add_edit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import idnull.z.myquotes.R

class QuotesAddFragment : Fragment() {

    companion object {
        fun newInstance() = QuotesAddFragment()
    }

    private lateinit var viewModel: QuotesAddViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quotes_add_fragment, container, false)
    }



}