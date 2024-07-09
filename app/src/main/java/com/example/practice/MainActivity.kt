package com.example.practice

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var actionBarDrawerToggle : ActionBarDrawerToggle

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close);

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(binding.actionbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""

        setSupportActionBar(binding.actionbar.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_hamburger)
            setDisplayShowTitleEnabled(false)
        }

//        findViewById<CardView>(R.id.quickAction2).findViewById<TextView>(R.id.quickText1).text = "2"
        binding.quickAction2.txt1.text = "02"
        binding.quickAction2.txt2.text = "Claims"
        binding.quickAction2.txt3.visibility = View.INVISIBLE
        binding.quickAction3.txt1.text = "08"
        binding.quickAction3.txt2.text = "Payments"
        binding.quickAction3.txt3.visibility = View.INVISIBLE
        binding.headlineBusinessSummary.txtTitle.text = "Business Summary"
//        binding.cardBusinessSummary.summaryRight.totalPolicies.text = "Total GWP"
//        binding.cardBusinessSummary.summaryRight.totalPoliciesCount.text = "₹25.7Cr"
        binding.summaryRight.totalPolicies.text = "Total GWP"
        binding.summaryRight.totalPoliciesCount.text = "₹25.7Cr"
        binding.quickQuote2.imgQuickQuote.setImageResource(R.drawable.motor)
        binding.quickQuote2.txtQuick.text = "Motor"
        binding.quickQuote3.imgQuickQuote.setImageResource(R.drawable.travel)
        binding.quickQuote3.txtQuick.text = "Travel"
        binding.quickQuote4.imgQuickQuote.setImageResource(R.drawable.comm_lines)
        binding.quickQuote4.txtQuick.text = "Comm. Lines"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return true
    }
}