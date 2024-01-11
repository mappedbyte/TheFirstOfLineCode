package com.francis.first.FragmentTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.francis.first.R
import com.francis.first.databinding.ActivityMain5Binding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main5)
        binding=ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val leftFragment = supportFragmentManager.findFragmentById(R.id.leftFragment) as LeftFragment
        val button = leftFragment.view?.findViewById<Button>(R.id.button)
        button?.setOnClickListener {

            replaceFragment(AnotherRightFragment())

        }

        replaceFragment(RightFragment())

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)

        transaction.addToBackStack(null)
        transaction.commit()
    }
}