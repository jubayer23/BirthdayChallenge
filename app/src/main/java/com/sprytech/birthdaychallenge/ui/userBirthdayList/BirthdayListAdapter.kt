package com.sprytech.birthdaychallenge.ui.userBirthdayList

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sprytech.birthdaychallenge.databinding.BirthdayListItemBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import com.android.birthdaychallenge.data.models.Result
import com.sprytech.birthdaychallenge.R


class BirthdayListAdapter(
    private val listener: OnListItemClickListener,
) : ListAdapter<Result, BirthdayListAdapter.ViewHolder>(Companion) {


    class ViewHolder(val itemBinding: BirthdayListItemBinding) : RecyclerView.ViewHolder(itemBinding.root)


    companion object : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.birthday_list_item,
                parent,
                false
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.itemBinding.item = item
        holder.itemBinding.executePendingBindings()


        val inputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
        val outputFormatter: DateTimeFormatter =
            DateTimeFormatter.ofPattern("dd-MM-yyy", Locale.ENGLISH)
        val date: LocalDate = LocalDate.parse(item?.dob?.date, inputFormatter)
        val formattedDate: String = outputFormatter.format(date)
        holder.itemBinding.dob = formattedDate





        if (!item?.name?.first.isNullOrEmpty() && !item?.name?.last.isNullOrEmpty()) {

            holder.itemBinding.userNameHint.text =
                item?.name?.first?.substring(0, 1) + item?.name?.last?.substring(0, 1)


        } else {
            holder.itemBinding.userNameHint.text = item?.name?.first?.substring(0, 1)
        }

        holder.itemBinding.rootView.setOnClickListener {
            listener.onItemClick(position, item, it)
        }

        setFadeAnimation(holder.itemView, position)

    }


    private var mLastPosition = -1

    private fun setFadeAnimation(view: View, position: Int) {
//        if (position > mLastPosition) {
        val anim = AlphaAnimation(0.0f, 1.0f)
        anim.duration = 500
        view.startAnimation(anim)
//            mLastPosition = position
//        }
    }

}