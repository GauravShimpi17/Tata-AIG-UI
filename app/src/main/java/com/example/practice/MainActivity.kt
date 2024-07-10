package com.example.practice

import ExpandableAdapter
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var expandableListAdapter : ExpandableAdapter

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)

        actionBarDrawerToggle =
            ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                R.string.nav_open,
                R.string.nav_close
            );

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
        binding.quickAction2.apply {
            txt1.text = "02"
            txt2.text = "Claims"
            txt3.visibility = View.INVISIBLE
        }

        binding.quickAction3.apply {
            txt1.text = "08"
            txt2.text = "Payments"
            txt3.visibility = View.INVISIBLE
        }

        binding.headlineBusinessSummary.apply {
            txtTitle.text = "Business Summary"
            txtTitle.setCompoundDrawables(null, null, null, null)
        }

        binding.txtQuickQuote.apply {
            txtTitle.text = "Quick Quote"
            txtTitle.setCompoundDrawables(null, null, null, null)
        }
        binding.summaryRight.apply {
            totalPolicies.text = "Total GWP"
            totalPoliciesCount.text = "₹25.7Cr"
        }

        binding.quickQuote2.apply {
            imgQuickQuote.setImageResource(R.drawable.motor)
            txtQuick.text = "Motor"
        }

        binding.quickQuote3.apply {
            imgQuickQuote.setImageResource(R.drawable.travel)
            txtQuick.text = "Travel"
        }


        binding.quickQuote4.apply {
            imgQuickQuote.setImageResource(R.drawable.comm_lines)
            txtQuick.text = "Comm. Lines"
        }

        binding.giantSteps.txtTitle.text = "Giant Steps"

        binding.health.txtTitle.text = "Health"
        binding.cardHealth.apply {
            progressHeadline.text = "Health Quarterly Camapign"
            centerImage.setImageResource(R.drawable.health_blue)
            clubGold.visibility = View.GONE
        }


        val drawable = ContextCompat.getDrawable(this, R.drawable.not_eligible)
        binding.motor.txtTitle.text = "Motor"
        binding.cardMotor.apply {
            progressHeadline.text = "Motor Quarterly Camapign"
            centerImage.setImageResource(R.drawable.motor2)
            clubGold.visibility = View.GONE
            notEligible.text = "Not Eligible"
            notEligible.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }

        binding.travel.txtTitle.text = "Travel"
        binding.cardTravel.apply {
            progressHeadline.text = "Travel 24 Camapign"
            centerImage.setImageResource(R.drawable.ic_travel_blue)
            clubGold.visibility = View.GONE
        }

        binding.commLines.txtTitle.text = "Comm.Lines"
        binding.cardCommLines.apply {
            txtEarned.text = "Achieved"
            txtTarget.text = "Slab Target"
            txtThirdBox.text = "Upcoming Slab Target"
            price.text = "₹25L"

        }

        expandableListAdapter = ExpandableAdapter(this, getNavMenuList())
        binding.expandableListView.setAdapter(expandableListAdapter)

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