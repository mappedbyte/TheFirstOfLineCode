package com.francis.first.ContactsTest

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.francis.first.R
import com.francis.first.databinding.ActivityMain10Binding

class MainActivity : AppCompatActivity() {

    private val contactsList = ArrayList<String>()
    private lateinit var binding: ActivityMain10Binding

    private lateinit var adapter: ArrayAdapter<String>

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main10)
        binding = ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter<String>(this@MainActivity, R.layout.simple_list_item_1,R.id.tv_name, contactsList)
        binding.contactsView.adapter = adapter
        if (checkSelfPermission(
                Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(Manifest.permission.READ_CONTACTS), 1)
        } else {
            readContacts()
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1 -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readContacts()
            } else {
                Toast.makeText(
                    this, "You denied the permission",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }


    @SuppressLint("Range")
    private fun readContacts() {
        contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            null
        )?.apply {

            while (moveToNext()) {
                val displayName =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number =
                    getString(getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                contactsList.add("$displayName\n$number")

            }

            adapter.notifyDataSetChanged()
            close()

        }
    }
}