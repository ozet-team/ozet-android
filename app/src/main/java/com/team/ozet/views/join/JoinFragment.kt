package com.team.ozet.views.join

import android.graphics.Color
import android.view.View
import androidx.lifecycle.Observer
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.databinding.FragmentJoinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class JoinFragment : BaseFragment<FragmentJoinBinding>(R.layout.fragment_join) {

    private val viewModel: JoinViewModel by viewModel()

    override fun init() {
        binding.vm = viewModel
        callback()
        checkPhoneNumber()
    }

    private fun callback() {
        with(viewModel) {
            clickEvent.observe(this@JoinFragment, Observer {
                binding.llAuth.visibility = View.VISIBLE

                if (isValidCellPhoneNumber(binding.editTextPhone.text.toString())) {
                    //TODO 인증번호 조건 추가 시 if 조건 추가
                    val bundle = bundleOf("userPhonNumber" to binding.editTextPhone.text.toString())
                    findNavController().navigate(
                        R.id.action_joinFragment_to_infoInputFragment,
                        bundle
                    )
                }
            })
        }
    }

    fun checkPhoneNumber() {
        binding.editTextPhone.addTextChangedListener {
            if (isValidCellPhoneNumber(binding.editTextPhone.text.toString())) {
                binding.btnNext.setBackgroundColor(Color.parseColor("#5D2FFF"));
                binding.btnNext.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                binding.btnNext.setBackgroundColor(Color.parseColor("#F0F2F5"));
            }
        }
    }

    fun isValidCellPhoneNumber(cellphoneNumber: String): Boolean {
        //핸드폰번호 유효성
//        if (!Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", cellphoneNumber)) {
//            Toast.makeText(thisContext, "올바른 핸드폰 번호가 아닙니다.", Toast.LENGTH_SHORT).show()
//            return false
//        }
        var returnValue: Boolean = false
        var regex: String =
            "^\\s*(010|011|012|013|014|015|016|017|018|019)(-|\\)|\\s)*(\\d{3,4})(-|\\s)*(\\d{4})\\s*$"
        var pattern: Pattern = Pattern.compile(regex)
        var matcher: Matcher = pattern.matcher(cellphoneNumber)
        if (matcher.matches()) {
            returnValue = true
        }
        return returnValue
    }
}