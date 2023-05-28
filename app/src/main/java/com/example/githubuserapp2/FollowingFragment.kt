package com.example.githubuserapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FollowingFragment : Fragment() {

    private lateinit var followingRecyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar

    private lateinit var followingAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_following, container, false)

        followingRecyclerView = view.findViewById(R.id.followingRecyclerView)
        loadingProgressBar = view.findViewById(R.id.loadingProgressBar)

        followingAdapter = UserAdapter(emptyList())
        followingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        followingRecyclerView.adapter = followingAdapter

        val username = requireActivity().intent.getStringExtra("username")
        loadFollowing(username!!)

        return view
    }

    private fun loadFollowing(username: String) {
        loadingProgressBar.visibility = View.VISIBLE

        // TODO: Implement API call to get following based on username

        // Dummy data for testing
        val following = listOf(
            User("https://example.com/avatar7.png", "following1", "Following One", 10, 5),
            User("https://example.com/avatar8.png", "following2", "Following Two", 6, 7),
            User("https://example.com/avatar9.png", "following3", "Following Three", 3, 10)
        )

        followingAdapter.users = following
        followingAdapter.notifyDataSetChanged()

        loadingProgressBar.visibility = View.GONE
    }
}
