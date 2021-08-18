package com.petruciostech.beeleitor.presenter.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import com.petruciostech.beeleitor.R
import com.petruciostech.beeleitor.databinding.ActivityMainBinding
import com.petruciostech.beeleitor.presenter.findbook.FindBookActivity

class MainActivity : AppCompatActivity() {
    private lateinit var bind:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        initComponents()
        changeFragment(MainFragment())
    }

    private fun initComponents(){
        setSupportActionBar(bind.toolbarMain)
        bind.floatingAddbooks.setOnClickListener { changeActivity() }
    }

    private fun changeActivity(){
        val intent = Intent(this, FindBookActivity::class.java)
        startActivity(intent)
    }

    private fun changeFragment(fragment:Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_containerfragment, fragment)
        fragmentTransaction.commit()
    }

}