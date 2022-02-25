package com.team.ozet.views.dialog

import android.content.Context
import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.team.ozet.R
import com.team.ozet.databinding.DialogCustomBinding
import com.team.ozet.databinding.DialogYearMonthPickerBinding

class CustomDialog(private val marginX: Int, private val title: String, private val body: String) : DialogFragment() {
    private var _binding: DialogCustomBinding? = null
    private lateinit var _listener: BtnClickListener

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = DialogCustomBinding.inflate(LayoutInflater.from(context))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.text = title
        binding.tvBody.text = body

        binding.btnCancel.setOnClickListener {
            _listener.onNegativeClick()
            dismiss()
        }
        binding.btnDone.setOnClickListener {
            _listener.onPositiveClick()
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog!!.window!!.attributes)

        val windowManager = requireContext().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        dialog!!.window!!.attributes = layoutParams
        dialog!!.window!!.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.bg_dialog))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setListener(listener: BtnClickListener) {
        _listener = listener
    }


    interface BtnClickListener {
        fun onPositiveClick()
        fun onNegativeClick()
    }
}