package com.example.githubuserapp2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [FollowerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FollowerFragment : Fragment() {

    private lateinit var followerRecyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar

    private lateinit var followerAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_follower, container, false)

        followerRecyclerView = view.findViewById(R.id.followerRecyclerView)
        loadingProgressBar = view.findViewById(R.id.loadingProgressBar)

        followerAdapter = UserAdapter(emptyList())
        followerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        followerRecyclerView.adapter = followerAdapter

        val username = requireActivity().intent.getStringExtra("username")
        loadFollowers(username!!)

        return view
    }

    private fun loadFollowers(username: String) {
        loadingProgressBar.visibility = View.VISIBLE

        // TODO: Implement API call to get followers based on username

        // Dummy data for testing
        val followers = listOf(
            User("https://example.com/avatar4.png", "follower1", "Follower One", 5, 10),
            User("https://example.com/avatar5.png", "follower2", "Follower Two", 3, 8),
            User("https://example.com/avatar6.png", "follower3", "Follower Three", 8, 5)
        )

        followerAdapter.users = followers
        followerAdapter.notifyDataSetChanged()

        loadingProgressBar.visibility = View.GONE
    }
}
