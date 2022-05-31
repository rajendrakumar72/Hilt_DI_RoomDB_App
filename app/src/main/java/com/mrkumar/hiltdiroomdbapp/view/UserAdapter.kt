package com.mrkumar.hiltdiroomdbapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrkumar.hiltdiroomdbapp.database.UserData
import com.mrkumar.hiltdiroomdbapp.databinding.ItemListBinding

class UserAdapter(var userList: List<UserData>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            with(holder){
                with(userList[position]){
                    binding.resultTextView.text=   this.name
                }
            }
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class UserViewHolder( val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root)
}