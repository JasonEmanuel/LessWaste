package com.example.alp_lesswaste.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alp_lesswaste.R
import com.example.alp_lesswaste.model.user.UserModel


class UserAdapter(private val userModelSet: ArrayList<UserModel>) :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username: TextView
        val password: TextView
        val status: TextView

        init {
            username = view.findViewById(R.id.username_cardUser)
            password = view.findViewById(R.id.password_cardUser)
            status = view.findViewById(R.id.status_cardUser)
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
        viewHolder.username.text = userModelSet[position].username
        viewHolder.password.text = userModelSet[position].password
        viewHolder.status.text = userModelSet[position].status
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = userModelSet.size

}
