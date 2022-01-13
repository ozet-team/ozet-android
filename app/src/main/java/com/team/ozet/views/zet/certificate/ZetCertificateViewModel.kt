package com.team.ozet.views.zet.certificate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.team.ozet.base.BaseViewModel
import com.team.ozet.data.resume.Academic
import com.team.ozet.data.resume.Certificate

class ZetCertificateViewModel : BaseViewModel() {
    private val _certificate = MutableLiveData<Certificate>()

    val certificate: LiveData<Certificate> = _certificate

    fun setCertificateData(data: Certificate){
        _certificate.value = data
    }
}