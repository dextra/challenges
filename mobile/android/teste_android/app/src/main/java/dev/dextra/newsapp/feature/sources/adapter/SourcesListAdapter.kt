package dev.dextra.newsapp.feature.sources.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dev.dextra.newsapp.ICON_LOCATOR_URL
import dev.dextra.newsapp.R
import dev.dextra.newsapp.api.model.Source
import kotlinx.android.synthetic.main.item_source.view.*

class SourcesListAdapter(val listener: SourceListAdapterItemListener) :
    RecyclerView.Adapter<SourcesListAdapter.SourcesListAdapterViewHolder>() {

    private val dataset: ArrayList<Source> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesListAdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_source, parent, false)
        return SourcesListAdapterViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: SourcesListAdapterViewHolder, position: Int) {
        val source = dataset[position]

        holder.view.setOnClickListener { listener.onClick(source) }

        holder.view.source_name.text = source.name
        holder.view.source_description.text = source.description
        holder.view.source_link.text = source.url

        Picasso.get()
            .load(ICON_LOCATOR_URL.format(source.url))
            .fit()
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.placeholder_image)
            .into(holder.view.source_image)
    }

    fun add(sources: List<Source>) {
        dataset.addAll(sources)
    }

    fun clear() {
        dataset.clear()
    }

    class SourcesListAdapterViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    interface SourceListAdapterItemListener {

        fun onClick(source: Source)

    }


}