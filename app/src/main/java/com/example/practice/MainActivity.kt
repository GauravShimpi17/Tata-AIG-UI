package com.example.practice

import ExpandableAdapter
import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager.LayoutParams
import android.widget.PopupWindow
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.databinding.Tooltip1Binding

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var expandableListAdapter : ExpandableAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imgRecyclerAdapter: ImgRecyclerAdapter
    private lateinit var dataList: MutableList<String>
    private lateinit var motorRV: RecyclerView
    private lateinit var motorAdapter: MotorAdapter
    private lateinit var motorData: MutableList<String>

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

//        binding.headlineMain.txtTitle.setCompoundDrawables(null,null,null,null)
        binding.headlineMain.infoIcon.visibility = View.GONE
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
//            txtTitle.setCompoundDrawables(null, null, null, null)
            infoIcon.visibility = View.GONE
        }

        binding.txtQuickQuote.apply {
            txtTitle.text = "Quick Quote"
//            txtTitle.setCompoundDrawables(null, null, null, null)
            infoIcon.visibility = View.GONE
        }
        binding.summaryRight.apply {
            totalPolicies.text = getString(R.string.total_gwp)
            totalPoliciesCount.text = getString(R.string._25_7cr)
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
        binding.giantSteps.infoIcon.setOnClickListener {
            val binding = Tooltip1Binding.inflate(layoutInflater)
            val layout = binding.root
            val window = PopupWindow(it,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT)
            window.isFocusable = true
            window.isOutsideTouchable = true
            window.contentView = layout
//            window.showAsDropDown(it,-55,-350, Gravity.START)
            window.setBackgroundDrawable(null)

            val screenHeight = Resources.getSystem().displayMetrics.heightPixels

            // Measure the layout to get its dimensions
            layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            val tooltipHeight = layout.measuredHeight

            // Get the location of the anchor view on screen
            val anchorLocation = IntArray(2)
            it.getLocationOnScreen(anchorLocation)
            val anchorX = anchorLocation[0]
            val anchorY = anchorLocation[1]

            // Calculate space below and above the anchor view
            val spaceBelow = screenHeight - anchorY - it.height
            val spaceAbove = anchorY

            // Decide where to position the tooltip
            val xOffset = -55
            val yOffset: Int

            if (spaceBelow >= tooltipHeight) {
                // Show below the anchor view
                yOffset = 0
                window.showAsDropDown(it, xOffset, yOffset)
                binding.angleBottom.visibility = View.GONE
            } else if (spaceAbove >= tooltipHeight) {
                // Show above the anchor view
                yOffset = -it.height - tooltipHeight
                window.showAsDropDown(it, xOffset, yOffset)
                binding.angleTop.visibility = View.GONE
            } else {
                // Default behavior: show below the anchor view
                yOffset = 0
                window.showAsDropDown(it, xOffset, yOffset)
            }

        }

//        val pointsAwayFrm = getString(R.string.diamondStart)
//        val club = getString(R.string.diamond_club)
//        val spannable = SpannableString("$pointsAwayFrm $club")
//
//        val start = spannable.indexOf(club)
//        val end = start - spannable.length

        binding.txtCampaigns.apply{
            txtTitle.text = "Campaigns"
//            txtTitle.setCompoundDrawables(null, null, null, null)
            infoIcon.visibility = View.GONE
        }

        binding.health.txtTitle.text = "Health"
        binding.cardHealth.apply {
            progressHeadline.text = "Health Quarterly Camapign"
            centerImage.setImageResource(R.drawable.health_blue)
            clubGold.visibility = View.GONE
        }


        binding.motor.txtTitle.text = "Motor"
        /*val drawable = ContextCompat.getDrawable(this, R.drawable.not_eligible)
        binding.cardMotor.apply {
            progressHeadline.text = "Motor Quarterly Camapign"
            centerImage.setImageResource(R.drawable.motor2)
            clubGold.visibility = View.GONE
            notEligible.text = "Not Eligible"
            notEligible.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }*/

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

        recyclerView = findViewById(R.id.img_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        dataList = mutableListOf()
        for (i in 0 until 3) {
            dataList.add("add")
        }
        imgRecyclerAdapter = ImgRecyclerAdapter(dataList)
        recyclerView.adapter = imgRecyclerAdapter
        PagerSnapHelper().attachToRecyclerView(recyclerView)

//        motor recycler
        motorRV = binding.motorRecycler

        motorData = mutableListOf()
        for (i in 0 until 4) {
            motorData.add("add")
        }

        motorAdapter = MotorAdapter(motorData)
        motorRV.adapter = motorAdapter
        motorRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        motorRV.isNestedScrollingEnabled = false
        motorRV.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        motorRV.setHasFixedSize(true)
        val radius = 10
        val dotsHeight = radius*3
        val color = ContextCompat.getColor(this, R.color.dark_blue_color)
        val inactiveColor = ContextCompat.getColor(this, R.color.dash_line)
        motorRV.addItemDecoration(
            DotIndicator(
                radius,
                radius * 4,
                dotsHeight,
                inactiveColor,
                color
            )
        )
        PagerSnapHelper().attachToRecyclerView(motorRV)
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