package ru.self.appkotlin.movieDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.self.appkotlin.R
import ru.self.appkotlin.data.models.Actor

class ActorsListAdapter : ListAdapter<Actor, ActorsListAdapter.ActorViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false) )
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val actorName = itemView.findViewById<TextView>(R.id.actor_name)
        private val actorImage = itemView.findViewById<ImageView>(R.id.actor_image)

        fun onBind(actor: Actor) {
            actorName.text = actor.name
            actorImage.setImageResource(actor.imageRes)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Actor>() {

        override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
            return oldItem.id == newItem.id
        }
        override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
            return oldItem == newItem
        }
    }
}