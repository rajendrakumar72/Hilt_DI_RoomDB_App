package com.mrkumar.hiltdiroomdbapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mrkumar.hiltdiroomdbapp.R
import com.mrkumar.hiltdiroomdbapp.database.UserData
import com.mrkumar.hiltdiroomdbapp.databinding.ActivityMainBinding
import com.mrkumar.hiltdiroomdbapp.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var _binding:ActivityMainBinding
    lateinit var userAdapter: UserAdapter
    lateinit var _viewModel:MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        val view =_binding.root
        setContentView(view)
        _viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        _binding.rcView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            userAdapter = UserAdapter(listOf())
            adapter = userAdapter
            val divider = DividerItemDecoration(applicationContext, StaggeredGridLayoutManager.VERTICAL)
            addItemDecoration(divider)
        }

        _viewModel.loadRecords()

        _viewModel.getRecordsObserver().observe(this
        ) {
            userAdapter.userList = it
            userAdapter.notifyDataSetChanged()
        }

        _binding.saveButton.setOnClickListener {
            if(enterDescriptionEditText.text.toString().isNotEmpty()) {
                val userEntity = UserData(name = enterDescriptionEditText.text.toString())
                _viewModel.insertRecord(userEntity)
                enterDescriptionEditText.setText("")
            }else{
                enterDescriptionEditText.error="Please Enter Data"
                enterDescriptionEditText.requestFocus()
            }
        }

    }

    private fun initVM() {


    }




}