package com.yashbhalodiya.abc.contact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yashbhalodiya.abc.databinding.ContactMainActivityBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ContactMainActivityBinding
    private lateinit var contactAdapter: ContactApadter
    private lateinit var dataList: ArrayList<ContactModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ContactMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList = ArrayList()

        binding.addButton.setOnClickListener {
            val name = binding.nameField.text.toString()
            val number = binding.numberField.text.toString()

            if (name.isEmpty()) {
                binding.nameField.error = "Required"
            } else if (number.isEmpty()) {
                binding.numberField.error = "Required"
            } else {
                val contact = ContactModel(name, number)
                dataList.add(contact)
                contactAdapter.notifyItemInserted(dataList.size - 1)
                binding.nameField.text.clear()
                binding.numberField.text.clear()
            }
        }

        contactAdapter = ContactApadter(this, dataList)
        binding.contactRv.layoutManager = LinearLayoutManager(this)
        binding.contactRv.adapter = contactAdapter
    }
}
