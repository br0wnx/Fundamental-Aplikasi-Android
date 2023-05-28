package com.example.githubuserapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var loadingProgressBar: ProgressBar

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        userRecyclerView = findViewById(R.id.userRecyclerView)
        loadingProgressBar = findViewById(R.id.loadingProgressBar)

        userAdapter = UserAdapter(emptyList())
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = userAdapter

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            searchUsers(query)
        }
    }

    private fun searchUsers(query: String) {
        loadingProgressBar.visibility = View.VISIBLE

        // TODO: Implement API call to search users based on query

        // Dummy data for testing
        val users = listOf(
            User("https://example.com/avatar1.png", "user1", "User One", 10, 20),
            User("https://example.com/avatar2.png", "user2", "User Two", 5, 15),
            User("https://example.com/avatar3.png", "user3", "User Three", 15, 10)
        )

        userAdapter.users = users
        userAdapter.notifyDataSetChanged()

        loadingProgressBar.visibility = View.GONE
    }
}
