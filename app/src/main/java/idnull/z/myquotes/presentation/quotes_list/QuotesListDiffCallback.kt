package idnull.z.myquotes.presentation.quotes_list

import androidx.recyclerview.widget.DiffUtil
import mydb.quotesdb.QuotesEntity

class QuotesListDiffCallback : DiffUtil.ItemCallback<QuotesEntity>() {
    override fun areItemsTheSame(oldItem: QuotesEntity, newItem: QuotesEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: QuotesEntity, newItem: QuotesEntity): Boolean {
        return oldItem == newItem
    }
}