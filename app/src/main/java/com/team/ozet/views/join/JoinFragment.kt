package com.team.ozet.views.join

import androidx.lifecycle.Observer
import android.view.WindowManager
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentJoinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class JoinFragment : BaseFragment<FragmentJoinBinding>(R.layout.fragment_join) {

    private val viewModel: JoinViewModel by viewModel()

    override fun init() {
        getActivity()?.getWindow()
            ?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        binding.vm = viewModel
    }

    private fun callback() {
        with(viewModel) {
            clickEvent.observe(this@JoinFragment, Observer {

            })
        }
    }

    fun isValidCellPhoneNumber(cellphoneNumber: String): Boolean {
        var returnValue: Boolean = false
        var regex: String =
            "^\\s*(010|011|012|013|014|015|016|017|018|019)(-|\\)|\\s)*(\\d{3,4})(-|\\s)*(\\d{4})\\s*$"
        var p: Pattern = Pattern.compile(regex)
        var m: Matcher = p.matcher(cellphoneNumber)
        if (m.matches()) {
            returnValue = true
        }
        return returnValue
    }
}