package com.example.practice

    fun getNavMenuList(): List<NavigationMenuGroup> = listOf(NavigationMenuGroup(
        icon = R.drawable.ic_paper,
        text = "Knowledge Centre",
        items = listOf("Products","Engagements","Agency Products")
    ),
        NavigationMenuGroup(
            icon = R.drawable.ic_paper,
            text = "Serving",
            items = listOf("Claims","Endorsements")
        ),
        NavigationMenuGroup(
            icon = R.drawable.ic_paper,
            text = "Renewals",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.ic_paper,
            text = "Quick Quote",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.graph,
            text = "Business Report",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.ic_commissions,
            text = "Giant Steps",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.campaigns,
            text = "Campaigns",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.ic_commissions,
            text = "Commissions",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.ic_locator,
            text = "Locators",
            items = listOf()
        ),
        NavigationMenuGroup(
            icon = R.drawable.ic_help,
            text = "Help",
            items = listOf("Contact RM","FAQs","Raise a concern")
        ),
        NavigationMenuGroup(
            icon = R.drawable.logout,
            text = "Logout",
            items = listOf()
        )
    )

