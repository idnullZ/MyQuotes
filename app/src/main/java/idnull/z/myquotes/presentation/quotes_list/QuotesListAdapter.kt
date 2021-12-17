package idnull.z.myquotes.presentation.quotes_list


import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import idnull.z.myquotes.R
import idnull.z.myquotes.domain.Quot
import idnull.z.myquotes.presentation.quotes_list.QuotesListAdapter.QuotesItemViewHolder
import mydb.quotesdb.QuotesEntity


class QuotesListAdapter : ListAdapter<QuotesEntity, QuotesItemViewHolder>(QuotesListDiffCallback()) {

    var onShopItemClickListener: ((QuotesEntity) -> Unit)? = null



    class QuotesItemViewHolder(view: View): RecyclerView.ViewHolder(view){

        val tvName: TextView = view.findViewById(R.id.tv_name)

    }

    override fun onBindViewHolder(viewHolder: QuotesItemViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(item)
        }
        viewHolder.tvName.text = item.quot
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return QuotesItemViewHolder(view)
    }
}