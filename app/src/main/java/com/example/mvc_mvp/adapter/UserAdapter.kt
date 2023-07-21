package com.example.mvc_mvp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvc_mvp.database.UserEntity
import com.example.mvc_mvp.databinding.ItemLayoutBinding

class UserAdapter : ListAdapter<UserEntity, UserAdapter.Vh>(MyDiffUtil()) {

    class MyDiffUtil : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bind(getItem(position))
    }

    inner class Vh(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userEntity: UserEntity) {
            binding.apply {
                nameTv.text = userEntity.name
                ageTv.text = userEntity.age.toString()
            }
        }
    }
}