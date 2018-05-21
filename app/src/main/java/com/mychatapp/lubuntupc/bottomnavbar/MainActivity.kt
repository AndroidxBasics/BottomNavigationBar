package com.mychatapp.lubuntupc.bottomnavbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var fragments: MutableList<BottomBarFragment>? = null
    private val TAG_FRAGMENT_CALLS = "tag_frag_calls"
    private val TAG_FRAGMENT_RECENTS = "tag_frag_recents"
    private val TAG_FRAGMENT_TRIPS = "tag_frag_trips"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.setOnNavigationItemSelectedListener(object: BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.bottombaritem_calls -> {
                        switchFragment(0, TAG_FRAGMENT_CALLS)
                        return true
                    }
                    R.id.bottombaritem_recents -> {
                        switchFragment(1, TAG_FRAGMENT_RECENTS)
                        return true
                    }
                    R.id.bottombaritem_trips -> {
                        switchFragment(2, TAG_FRAGMENT_TRIPS)
                        return true
                    }
                }
                return false

            }

        })

        fragments = ArrayList<BottomBarFragment>()
        buuildFragmentsList()
        switchFragment(0, TAG_FRAGMENT_CALLS)
    }

    fun buuildFragmentsList() {
        var callsFragment: BottomBarFragment = buildFragment("Calls")
        var recentsFragment: BottomBarFragment = buildFragment("Recents")
        var tripsFragment: BottomBarFragment = buildFragment("Trips")

        fragments!!.add(callsFragment)
        fragments!!.add(recentsFragment)
        fragments!!.add(tripsFragment)
    }

    private fun buildFragment(title: String): BottomBarFragment {
        var fragment = BottomBarFragment()
        var bundle = Bundle()
        bundle.putString(BottomBarFragment().ARG_TITLE, title)
        fragment.setArguments(bundle)
        return fragment
    }

    fun switchFragment(pos: Int, tag: String) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_fragmentholder, fragments!!.get(pos), tag)
                .commit()
    }
}
