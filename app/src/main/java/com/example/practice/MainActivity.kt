package com.example.practice

import ExpandableAdapter
import android.content.res.Resources
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager.LayoutParams
import android.widget.PopupWindow
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.databinding.Tooltip1Binding

class MainActivity : AppCompatActivity() {

    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    //    private lateinit var expandableListAdapter : ExpandableAdapter
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


        actionBar()
        populateQuickAction()
        businessSummary()
        populateQuickQuote()
        giantStepsData()
        populateCampaignData()
        posterImgRecycler()
        CampaignMotorRecycler()

        /*expandableListAdapter = ExpandableAdapter(this, getNavMenuList())
        binding.expandableListView.setAdapter(expandableListAdapter)*/
        binding.menuRecycler.layoutManager = LinearLayoutManager(this)
        binding.menuRecycler.adapter = MenuRecycler(getNavMenuList())


        /*  .apply {
          setOnClickListener { position ->
              binding.menuRecycler.scrollToPosition(position)
          }
      }*/

    val spannable = SpannableString(ContextCompat.getString(this, R.string.diamondStart))
        val dClub =  "Diamond Club"
        val start = spannable.indexOf(dClub)
        val end = start + dClub.length
        spannable.setSpan(StyleSpan(Typeface.BOLD), start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        binding.cardGiantSteps.txtThirdBoxLeft.text = spannable

    }

    private fun actionBar() {
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, R.string.nav_open, R.string.nav_close
        );

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        setSupportActionBar(binding.actionbar.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setSupportActionBar(binding.actionbar.toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_hamburger)
            setDisplayShowTitleEnabled(false)
        }

        binding.navHeader.close.setOnClickListener {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                } else {
                    finish()
                }
            }
        })

    }

    private fun posterImgRecycler() {

        recyclerView = binding.imgRecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        dataList = mutableListOf()
        for (i in 0 until 3) {
            dataList.add("add")
        }
        imgRecyclerAdapter = ImgRecyclerAdapter(dataList)
        recyclerView.adapter = imgRecyclerAdapter
        PagerSnapHelper().attachToRecyclerView(recyclerView)
    }

    private fun CampaignMotorRecycler() {
        motorRV = binding.motorRecycler
        motorData = mutableListOf()
        for (i in 0 until 4) {
            motorData.add("add")
        }

        motorAdapter = MotorAdapter(motorData)
        motorRV.adapter = motorAdapter
        motorRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        motorRV.isNestedScrollingEnabled = false
        motorRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        motorRV.setHasFixedSize(true)
        val radius = 10
        val dotsHeight = radius * 3
        val color = ContextCompat.getColor(this, R.color.dark_blue_color)
        val inactiveColor = ContextCompat.getColor(this, R.color.dash_line)
        motorRV.addItemDecoration(
            DotIndicator(
                radius, radius * 4, dotsHeight, inactiveColor, color
            )
        )
        PagerSnapHelper().attachToRecyclerView(motorRV)
    }

    private fun populateQuickAction() {
        binding.headlineMain.txtTitle.setCompoundDrawables(null, null, null, null)
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

    }

    private fun businessSummary() {
        binding.headlineBusinessSummary.apply {
            txtTitle.text = "Business Summary"
            infoIcon.visibility = View.GONE
        }

        binding.summaryRight.apply {
            totalPolicies.text = getString(R.string.total_gwp)
            totalPoliciesCount.text = getString(R.string._25_7cr)
        }
    }

    private fun populateQuickQuote() {
        binding.txtQuickQuote.apply {
            txtTitle.text = "Quick Quote"
//            txtTitle.setCompoundDrawables(null, null, null, null)
            infoIcon.visibility = View.GONE
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

    }

    private fun giantStepsData() {
        binding.giantSteps.txtTitle.text = "Giant Steps"


        binding.giantSteps.infoIcon.setOnClickListener {
            val binding = Tooltip1Binding.inflate(layoutInflater)
            val layout = binding.root
            val window = PopupWindow(it, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            window.isFocusable = true
            window.isOutsideTouchable = true
            window.contentView = layout
//            window.showAsDropDown(it,-55,-350, Gravity.START)
            window.setBackgroundDrawable(null)

            val screenHeight = Resources.getSystem().displayMetrics.heightPixels


            layout.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            val tooltipHeight = layout.measuredHeight


            val anchorLocation = IntArray(2)
            it.getLocationOnScreen(anchorLocation)
            val anchorX = anchorLocation[0]
            val anchorY = anchorLocation[1]


            val spaceBelow = screenHeight - anchorY - it.height
            val spaceAbove = anchorY

            val xOffset = -55
            val yOffset: Int

            if (spaceBelow >= tooltipHeight) {
                yOffset = 0
                window.showAsDropDown(it, xOffset, yOffset)
                binding.angleBottom.visibility = View.GONE
            } else if (spaceAbove >= tooltipHeight) {
                yOffset = -it.height - tooltipHeight
                window.showAsDropDown(it, xOffset, yOffset)
                binding.angleTop.visibility = View.GONE
            }
        }
    }

    private fun populateCampaignData() {
        binding.txtCampaigns.apply {
            txtTitle.text = "Campaigns"
//            txtTitle.setCompoundDrawables(null, null, null, null)
            infoIcon.visibility = View.GONE
        }

        binding.health.txtTitle.text = "Health"
        binding.cardHealth.apply {
            progressHeadline.text = "Health Quarterly Campaign"
            centerImage.setImageResource(R.drawable.health_blue)
            clubGold.visibility = View.GONE
        }


        binding.motor.txtTitle.text = "Motor"/*val drawable = ContextCompat.getDrawable(this, R.drawable.not_eligible)
        binding.cardMotor.apply {
            progressHeadline.text = "Motor Quarterly Camapign"
            centerImage.setImageResource(R.drawable.motor2)
            clubGold.visibility = View.GONE
            notEligible.text = "Not Eligible"
            notEligible.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        }*/

        binding.travel.txtTitle.text = "Travel"
        binding.cardTravel.apply {
            progressHeadline.text = "Travel 24 Campaign"
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
