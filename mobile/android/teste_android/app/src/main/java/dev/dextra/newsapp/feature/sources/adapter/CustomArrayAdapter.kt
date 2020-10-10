package dev.dextra.newsapp.feature.sources.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import dev.dextra.newsapp.api.model.enums.BaseDataEnum

class CustomArrayAdapter<T>(context: Context, resource: Int, objects: MutableList<T>) :
    ArrayAdapter<T>(context, resource, objects) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = super.getView(position, convertView, parent)

        val item = getItem(position)

        if(item is BaseDataEnum && view is TextView){
            view.text = context.getText(item.getRes())
        }

        return view
    }

}