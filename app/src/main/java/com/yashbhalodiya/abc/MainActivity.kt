package com.yashbhalodiya.abc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.yashbhalodiya.abc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var dataList: ArrayList<RvModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList = ArrayList<RvModel>()

        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))
        dataList.add(RvModel("Maddy", "Developer"))

        rvAdapter = RvAdapter(this, dataList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = rvAdapter
    }
}