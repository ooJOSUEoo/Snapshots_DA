package com.example.snapshots_da

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.snapshots_da.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    
    private lateinit var mActiveFragment: Fragment
    private lateinit var mFraManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupBottomNav()
    }

    private fun setupBottomNav(){
        mFraManager = supportFragmentManager

        val homeFragment = HomeFragment()
        val addFragment = AddFragment()
        val profileFragment = ProfileFragment()

        mActiveFragment = homeFragment

        mFraManager.beginTransaction()
            .add(R.id.hostFragment,profileFragment, ProfileFragment::class.java.name)
            .hide(profileFragment).commit()
        mFraManager.beginTransaction()
            .add(R.id.hostFragment,addFragment, AddFragment::class.java.name)
            .hide(addFragment).commit()
        mFraManager.beginTransaction()
            .add(R.id.hostFragment,homeFragment, HomeFragment::class.java.name).commit()
    }
}