package com.example.cobagithub.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cobagithub.ui.section.FollowersFollowingFragment


class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    var username: String = " "

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> FollowersFollowingFragment.newInstance(position, username)
            1 -> FollowersFollowingFragment.newInstance(position, username)
            else -> {
                FollowersFollowingFragment.newInstance(position, username)
            }
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}