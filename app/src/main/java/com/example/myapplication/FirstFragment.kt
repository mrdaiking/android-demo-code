package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), EventListener {

    private var binding: FragmentFirstBinding? = null
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view == null) return
        binding = FragmentFirstBinding.bind(view)
        binding.let {
            it?.handler = EventHandler()
            it?.mainView?.setOnTouchListener(object : OnSwipeTouchListener(context) {
                override fun onSwipeLeft() {
                    Log.d("DEBUG_TAG", "TAO NE THANG CHO LEFT")
                }

                override fun onSwipeRight() {
                    Log.d("DEBUG_TAG", "TAO NE THANG CHO RIGHT")
                }
            })
        }


//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }


    inner class EventHandler: View.OnClickListener, GestureDetector.SimpleOnGestureListener() {
        override fun onClick(v: View?) {
            when(v?.id) {
                R.id.button_first -> {
                    Log.d("DEBUG_TAG", "TAO NE THANG CHO")
                }
            }
        }
    }

}