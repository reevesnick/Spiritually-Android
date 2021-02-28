package com.app.spritually.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.spritually.R
import com.app.spritually.model.HistoryModel

class HistoryListAdapter: RecyclerView.Adapter<HistoryListAdapter.HistoryListHolder>() {

    private var historyModel: List<HistoryModel> = ArrayList()
    private var adapterContext: Context? = null
    private var listener: AdapterView.OnItemClickListener? = null

    inner class HistoryListHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var historyQuestionLabel: TextView
        var historyAnswerLabel: TextView
        var historyDateLabel: TextView


        init {
            historyQuestionLabel = itemView.findViewById(R.id.historyQuestionLabel)
            historyAnswerLabel = itemView.findViewById(R.id.historyAnswerLabel)
            historyDateLabel = itemView.findViewById(R.id.historyDateLabel)
        }
    }

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryListAdapter.HistoryListHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.history_list_item,parent,false)
        return HistoryListHolder(v)
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: HistoryListAdapter.HistoryListHolder, position: Int) {
        var historyList = historyModel[position]

        holder.historyQuestionLabel.text = "historyList.question"
        holder.historyAnswerLabel.text = "historyList.answer"
        holder.historyDateLabel.text = "historyList.date"
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return historyModel.size
    }

    fun setLists(lists: List<HistoryModel>){
        this.historyModel = lists
        notifyDataSetChanged()
    }
}