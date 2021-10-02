package com.sprytech.birthdaychallenge.ui.birthdayDetails

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import com.android.birthdaychallenge.data.models.Result
import com.sprytech.birthdaychallenge.R
import com.sprytech.birthdaychallenge.databinding.FragmentBirthdayDetailsBinding
import com.sprytech.birthdaychallenge.ui.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [BirthdayDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BirthdayDetailsFragment : BaseFragment<FragmentBirthdayDetailsBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1
        val bundle = arguments
        if (bundle == null) {
            Log.e("Confirmation", "ConfirmationFragment did not receive namedob information")
            return
        }

// 2
        val args = BirthdayDetailsFragmentArgs.fromBundle(bundle)
        val ob :  Result? = args.nameDob
        binding.item = ob

    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentBirthdayDetailsBinding.inflate(inflater, container, false, savedInstanceState)

}