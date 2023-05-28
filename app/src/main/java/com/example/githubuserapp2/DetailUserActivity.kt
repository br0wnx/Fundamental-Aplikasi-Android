package com.example.githubuserapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayout

class DetailUserActivity : AppCompatActivity() {

    private lateinit var avatarImageView: ImageView
    private lateinit var usernameTextView: TextView
    private lateinit var nameTextView: TextView
    private lateinit var followersTextView: TextView
    private lateinit var followingTextView: TextView
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        avatarImageView = findViewById(R.id.avatarImageView)
        usernameTextView = findViewById(R.id.usernameTextView)
        nameTextView = findViewById(R.id.nameTextView)
        followersTextView = findViewById(R.id.followersTextView)
        followingTextView = findViewById(R.id.followingTextView)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        val username = intent.getStringExtra("username")
        loadUserDetail(username!!)
        setupViewPager()
    }

    private fun loadUserDetail(username: String) {
        // TODO: Implement API call to get user details based on username

        // Dummy data for testing
        val user = User(
            "https://example.com/avatar.png",
            username,
            "User Name",
            100,
            50
        )

        // Set data to views
        Glide.with(this)
            .load(user.avatarUrl)
            .into(avatarImageView)
        usernameTextView.text = user.username
        nameTextView.text = user.name
        followersTextView.text = "Followers: ${user.followers}"
        followingTextView.text = "Following: ${user.following}"
    }

    private fun setupViewPager() {
        val followerFragment = FollowerFragment()
        val followingFragment = FollowingFragment()

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(followerFragment, "Followers")
        adapter.addFragment(followingFragment, "Following")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    inner class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private val fragments: MutableList<Fragment> = ArrayList()
        private val titles: MutableList<String> = ArrayList()

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }
}
