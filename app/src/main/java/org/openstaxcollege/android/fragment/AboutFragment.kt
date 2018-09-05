package org.openstaxcollege.android.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.openstaxcollege.android.R
import org.openstaxcollege.android.adapters.AboutRecyclerViewAdapter
import org.openstaxcollege.android.beans.About
import org.openstaxcollege.android.beans.AboutList
import org.openstaxcollege.android.handlers.JsonHelper

import java.util.ArrayList

class AboutFragment : Fragment()
{

    private val content: ArrayList<About>
        get() {
            val helper = JsonHelper()
            val aboutList = helper.getAboutData(activity, AboutList::class.java, "aboutList.json")
            return if (aboutList != null) {
                aboutList.aboutList
            } else {
                ArrayList()
            }
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.card_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?)
    {
        super.onActivityCreated(savedInstanceState)
        val recyclerView:RecyclerView = view!!.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this.activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.isNestedScrollingEnabled = false
        val adapter = AboutRecyclerViewAdapter(content, R.layout.about_row)
        recyclerView.adapter = adapter
    }
}
