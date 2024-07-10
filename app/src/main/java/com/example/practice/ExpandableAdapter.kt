import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import androidx.core.content.ContextCompat
import com.example.practice.NavigationMenuGroup
import com.example.practice.R
import com.example.practice.databinding.ChildBindinngBinding
import com.example.practice.databinding.ParentBinding


class ExpandableAdapter(
    private val context: Context,
    private val list: List<NavigationMenuGroup>
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int {
        return list.size
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return list[groupPosition].items.size
    }

    override fun getGroup(groupPosition: Int): NavigationMenuGroup {
        return list[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return list[groupPosition].items[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }
    override fun hasStableIds(): Boolean {
        return false
    }
    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val binding = if (convertView == null) {
            ParentBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ParentBinding.bind(convertView)
        }

        val indicator = if (list[groupPosition].items.isEmpty()) {
            null
        } else if (isExpanded) {
            ContextCompat.getDrawable(context, R.drawable.baseline_keyboard_arrow_up_24)
        } else {
            ContextCompat.getDrawable(context, R.drawable.baseline_keyboard_arrow_down_24)
        }
        val data = getGroup(groupPosition)
        binding.itemExpandableListView2.text = data.text
        if (getGroup(groupPosition).icon != 0) {
            binding.itemExpandableListView2.setCompoundDrawablesRelativeWithIntrinsicBounds(
                ContextCompat.getDrawable(
                    context,
                    data.icon
                ), null, indicator, null
            )
        }

        return binding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val binding = if (convertView == null) {
            ChildBindinngBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ChildBindinngBinding.bind(convertView)
        }

        binding.childItemNav.text = getChild(groupPosition, childPosition)
        return binding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

}