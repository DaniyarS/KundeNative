package dev.dslam.kunde

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.dslam.kunde.databinding.ActivityMainBinding
import dev.dslam.kunde.presentation.home.fragments.HomeFragment
import dev.dslam.kunde.presentation.profile.fragments.ProfileFragment
import dev.dslam.kunde.presentation.search.fragments.SearchFragment
import dev.dslam.kunde.presentation.settings.fragments.SettingsFragment
import dev.dslam.kunde.presentation.task.AddTaskActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        setupViews()
    }

    private fun setupViews() {
        with(binding) {
            mainBottomNavView.background = null

            mainBottomNavView.setOnNavigationItemSelectedListener { item ->
                val selectedFragment: Fragment = when (item.itemId) {
                    R.id.main_page -> HomeFragment()
                    R.id.search_page -> SearchFragment()
                    R.id.profile_page -> ProfileFragment()
                    R.id.settings_page -> SettingsFragment()

                    else -> throw IllegalArgumentException("Invalid menu item ID")
                }

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()

                true
            }

            addTaskButton.setOnClickListener {
                val intent = Intent(this@MainActivity, AddTaskActivity::class.java)
                startActivity(intent)
            }
        }
    }
}