package com.team.ozet.views.join

import android.graphics.Color
import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.data.pass_code.RequestedVerify
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.FragmentJoinBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import java.util.concurrent.TimeUnit
import java.util.regex.Matcher
import java.util.regex.Pattern
import kotlin.concurrent.timerTask

@RequiresApi(Build.VERSION_CODES.O)
class JoinFragment : BaseFragment<FragmentJoinBinding>(R.layout.fragment_join) {

    private val viewModel: JoinViewModel by viewModel()
    private val timer = Timer()

    override fun init() {
        binding.vm = viewModel
        callback()
        checkPhoneNumber()
    }

    private fun callback() {
        with(viewModel) {
            requestedVerify.observe(this@JoinFragment) { model ->
                model.requestedVerify?.let {
                    startAuthTime(it.expireAt)
                }
            }
            clickEvent.observe(this@JoinFragment, Observer {
                var phoneNumber =
                    binding.customPhone.getEditText().toString().toNationalPhoneNumber()
                viewModel.requestedVerify.value?.requestedVerify?.let {
                    if (it == null) {
                        viewModel.postPassCodeRequest(
                            phoneNumber
                        )
                    } else {
                        viewModel.postPassCode(
                            phoneNumber,
                            binding.customNumber.getEditText().toString()
                        )
                        findNavController().navigate(
                            R.id.action_joinFragment_to_infoInputFragment,
                        )
                    }


                }
//                if (requestedVerify.value != null) {
//                } else {
//                    viewModel.postPassCode(
//                        binding.customPhone.getEditText().toString(),
//                        binding.customNumber.getEditText().toString()
//                    )
//                }

//                if (isValidCellPhoneNumber(binding.incluePhone.etBase.text.toString())) {
//                    //TODO ???????????? ?????? ?????? ??? if ?????? ??????
//                    val bundle =
//                        bundleOf("userPhonNumber" to binding.incluePhone.etBase.text.toString())
//                    findNavController().navigate(
//                        R.id.action_joinFragment_to_infoInputFragment,
//                        bundle
//                    )
//                }
            })
        }
    }

    // timerTask onDestroy ?????? ?????? ????????????   ????????? ?????? ??????
    private fun startAuthTime(expireAt: String) {

        val tDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale("ko", "KR"))
        var date = tDateFormat.parse(expireAt)


//        // ?????? ??????.
        var today = Calendar.getInstance()
        var calcuDate = (today.time.time - date.time) / 1000

        var start = System.currentTimeMillis()


//        // ????????????????????? ????????????
        val tDate = Date(start)
        val strDate = tDateFormat.format(tDate)


        //???????????? ????????? ??????
//        val clickTime = System.currentTimeMillis()

        timer.schedule(timerTask {
            activity?.runOnUiThread {
                this.run {


                    calcuDate--

                    var minute = TimeUnit.SECONDS.toMinutes(calcuDate) - TimeUnit.SECONDS.toHours(
                        calcuDate
                    )
                    var second = TimeUnit.SECONDS.toSeconds(calcuDate) - TimeUnit.SECONDS.toMinutes(
                        calcuDate
                    ) * 60
                    // text ??????
//                    Log.i("AAA", "run $minute ??? $second")
                    var strTime = "%02d".format(minute) + " : " + "%02d".format(second)
                    binding.tvTimer.text = strTime
                    // 0????????? timer task ??????
                    if (calcuDate == 0L) {
                        this.cancel()
                        Log.i("AAA", "cancel")
                    }
                }
            }
        }, 0, 1000)
    }


    private fun stopAuthTime() {
        timer.cancel()
        binding.tvTimer.text = "00:00"
    }

    private fun checkPhoneNumber() {
//        binding.customPhone.addTextChangedListener {
//            if (isValidCellPhoneNumber(binding.customNumber.etBase.text.toString())) {
//                binding.btnNext.setBackgroundColor(Color.parseColor("#5D2FFF"));
//                binding.btnNext.setTextColor(Color.parseColor("#FFFFFF"))
//            } else {
//                binding.btnNext.setBackgroundColor(Color.parseColor("#F0F2F5"));
//            }
//        }
    }

    fun isValidCellPhoneNumber(cellphoneNumber: String?): Boolean {
        //??????????????? ?????????
//        if (!Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", cellphoneNumber)) {
//            Toast.makeText(thisContext, "????????? ????????? ????????? ????????????.", Toast.LENGTH_SHORT).show()
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

    private fun String.toNationalPhoneNumber(): String {
        val phoneNumberUtil = PhoneNumberUtil.getInstance()
        val locale = Locale.getDefault().country
        val toNationalNum = phoneNumberUtil.parse(this, locale)

        return phoneNumberUtil.format(
            toNationalNum,
            PhoneNumberUtil.PhoneNumberFormat.E164
        )
    }

}