package com.sprytech.birthdaychallenge.ui.userBirthdayList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.android.birthdaychallenge.data.models.Dob
import com.android.birthdaychallenge.data.models.Name
import com.android.birthdaychallenge.data.models.Result
import com.sprytech.birthdaychallenge.R
import com.sprytech.birthdaychallenge.databinding.FragmentBirthdayListBinding
import com.sprytech.birthdaychallenge.ui.base.BaseFragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass.
 * Use the [BirthdayListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class BirthdayListFragment : BaseFragment<FragmentBirthdayListBinding>(), OnListItemClickListener {

    private val homeViewModel: BirthdayListViewModel by viewModels()
    private var homeDataAdapter: BirthdayListAdapter = BirthdayListAdapter(this)



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView()
        observeHomeData()






    }



    private fun initRecyclerView() {
        binding.rvHome.adapter = homeDataAdapter
    }

    private fun observeHomeData() {


        homeViewModel.restaurants.observe(viewLifecycleOwner, { result ->

            //restaurantAdapter.submitList(result.data)
            homeDataAdapter.submitList(result.data)

            binding.tvNoInternet.visibility = View.GONE
            binding.btnRetry.visibility = View.GONE

        })




    }




    override fun onItemClick(position: Int, item: Result?, view: View) {
        val bundle = Bundle()

        val directions = BirthdayListFragmentDirections.actionBirthdayListFragmentToBirthdayDetailsFragment(item)
        findNavController().navigate(directions)


    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBirthdayListBinding.inflate(inflater, container, false)


}