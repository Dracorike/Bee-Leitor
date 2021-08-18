package com.petruciostech.beeleitor.presenter.findbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.petruciostech.beeleitor.R
import com.petruciostech.beeleitor.databinding.ActivityFindBookBinding

class FindBookActivity : AppCompatActivity() {
    private lateinit var bind:ActivityFindBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_book)

        bind = ActivityFindBookBinding.inflate(layoutInflater)
        setContentView(bind.root)

        fragmentManager(FindBookListFragment())
        setUpToolBar()
    }

    private fun fragmentManager(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_containerfragment_findbook, fragment)
        fragmentTransaction.commit()
    }
    private fun setUpToolBar(){
        setSupportActionBar(bind.toolbarFindbook)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_mainfragment, menu)
        return true
    }
}