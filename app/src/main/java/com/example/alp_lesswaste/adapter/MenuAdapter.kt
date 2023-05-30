package com.example.alp_lesswaste.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alp_lesswaste.R
import com.example.alp_lesswaste.model.menu.MenuModel
import java.util.ArrayList


class MenuAdapter(private val menuModelSet: ArrayList<MenuModel>) :
        RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val menu_name: TextView
        val menu_price: TextView
        val menu_desc: TextView



        init{
            menu_name = view.findViewById(R.id.menuName_cardMenu)
            menu_price = view.findViewById(R.id.price_cardMenu)
            menu_desc = view.findViewById(R.id.description_cardMenu)

        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.menuresto_card, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.menu_name.text = menuModelSet[position].menu_name
        viewHolder.menu_price.text = menuModelSet[position].menu_price
        viewHolder.menu_desc.text = menuModelSet[position].menu_desc
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = menuModelSet.size

}
