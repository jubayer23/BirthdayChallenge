package com.sprytech.birthdaychallenge.ui.userBirthdayList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.birthdaychallenge.data.models.Dob
import com.android.birthdaychallenge.data.models.Name
import com.android.birthdaychallenge.data.models.Result
import com.sprytech.birthdaychallenge.R
import com.sprytech.birthdaychallenge.databinding.FragmentBirthdayListBinding
import com.sprytech.birthdaychallenge.ui.base.BaseFragment
import androidx.navigation.fragment.findNavController
/**
 * A simple [Fragment] subclass.
 * Use the [BirthdayListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BirthdayListFragment : BaseFragment<FragmentBirthdayListBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvHi.setOnClickListener{

            val name : Name = Name("asd", "sad", "sd")
            val dob : Dob = Dob(12, "23-44")
            val result : Result = Result(1, dob, name)
            // 1



// 2
            val directions = BirthdayListFragmentDirections.actionBirthdayListFragmentToBirthdayDetailsFragment(result)
            findNavController().navigate(directions)
        }

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBirthdayListBinding.inflate(inflater, container, false)


}