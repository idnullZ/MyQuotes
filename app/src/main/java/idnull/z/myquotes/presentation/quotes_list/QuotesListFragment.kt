package idnull.z.myquotes.presentation.quotes_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import idnull.z.myquotes.R
import idnull.z.myquotes.data.App
import idnull.z.myquotes.data.di.viewmodel.injectViewModel
import idnull.z.myquotes.databinding.FragmentQuotesListBinding
import idnull.z.myquotes.presentation.quotes_main.MainViewModel
import idnull.z.myquotes.utils.logger
import javax.inject.Inject


class QuotesListFragment : Fragment() {


    private var _binding:FragmentQuotesListBinding? = null
    private val  binding: FragmentQuotesListBinding
    get () = _binding ?:throw RuntimeException("FragmentQuotesListBinding null ")



    private lateinit var recyclerView: RecyclerView


    private val adapterList = QuotesListAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: QuotesListViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().application as App).component.inject(this)
        viewModel = injectViewModel(factory = viewModelFactory)
        super.onCreate(savedInstanceState)


    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuotesListBinding.inflate(inflater,container,false)


        recyclerView = binding.rvList
        recyclerView.adapter = adapterList
        viewModel.listQuotes.observe(viewLifecycleOwner){
            adapterList.submitList(it)
        }



        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val callback = object :ItemTouchHelper.SimpleCallback(0,
        ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
               return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               val item = adapterList.currentList[viewHolder.adapterPosition]
                viewModel.delete(item)
            }
        }
            val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)



        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_quotesListFragment_to_quotesAddFragment)
        }


        adapterList.onShopItemClickListener = {
            logger("onShopItemClickListener $it")
            findNavController().navigate(R.id.action_quotesListFragment_to_quotesAddFragment)
        }

    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }





}