package com.francis.first.FragmentBestPractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.francis.first.R
import org.w3c.dom.Text


class NewsContentFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_content, container, false)
    }

    fun refresh(title:String ,content:String){
        val contentLayout = view?.findViewById<LinearLayout>(R.id.contentLayout)
        contentLayout?.visibility=View.VISIBLE
         view?.findViewById<TextView>(R.id.newsTitle).let {
             it?.text=title
         }
         view?.findViewById<TextView>(R.id.newsContent).let {
             it?.text=content
         }
    }


    companion object {

        @JvmStatic
        fun newInstance( ) =
            NewsContentFragment()

    }
}