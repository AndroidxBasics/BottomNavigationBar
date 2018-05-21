package com.mychatapp.lubuntupc.bottomnavbar


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_bottom_bar.*
import android.widget.TextView




/**
 * A simple [Fragment] subclass.
 */
class BottomBarFragment : Fragment() {
    val ARG_TITLE = "arg_title"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var rootView: View = inflater!!.inflate(R.layout.fragment_bottom_bar, container, false)


        var textView = rootView.findViewById<TextView>(R.id.fragment_bottom_bar_text_activetab)
        var title = getArguments().getString(ARG_TITLE, "")
        textView.setText(title);

        return rootView
    }

}// Required empty public constructor
