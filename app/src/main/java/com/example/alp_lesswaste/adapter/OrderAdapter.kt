package com.example.alp_lesswaste.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alp_lesswaste.R
import com.example.alp_lesswaste.model.menu.MenuModel
import com.example.alp_lesswaste.model.order.OrderModel
import com.example.alp_lesswaste.view.AddOrderActivity
import java.util.ArrayList

class OrderAdapter(private val menuOrderSet: ArrayList<OrderModel>) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val order_name: TextView
        val order_quantity: TextView
        val order_phonenumber: TextView

        init {
            order_name = view.findViewById(R.id.username_cardUser)
            order_phonenumber = view.findViewById(R.id.status_cardUser)
            order_quantity = view.findViewById(R.id.password_cardUser)
        }

    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_card, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.order_name.text = menuOrderSet[position].order_name
        viewHolder.order_quantity.text = menuOrderSet[position].order_quantity
        viewHolder.order_phonenumber.text = menuOrderSet[position].order_phonenumber
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = menuOrderSet.size

}