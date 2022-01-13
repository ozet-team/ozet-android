package com.team.ozet.views.zet.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.data.resume.Academic
import com.team.ozet.data.resume.Career
import com.team.ozet.data.resume.Certificate
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.FragmentZetMainBinding
import com.team.ozet.views.custom_view.add_recycler.AddAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetMainFragment : BaseFragment<FragmentZetMainBinding>(R.layout.fragment_zet_main) {
    private val viewModel:ZetMainViewModel by viewModel()
    override fun init() {
        binding.vm = viewModel
        viewModelCallBack()
        addRvCallback()
        viewModel.getResume()

    }

    private fun viewModelCallBack(){
        with(viewModel){
            resume.observe(this@ZetMainFragment, Observer {
                var acSimpleList = arrayListOf<ZetSimple>()
                var crSimpleList = arrayListOf<ZetSimple>()
                var cfSimpleList = arrayListOf<ZetSimple>()

                for (i in it.academic){
                    acSimpleList.add(ZetSimple(i.major,"${i.joinAt} ~ ${i.quitAt}"))
                }
                for (i in it.career){
                    crSimpleList.add(ZetSimple(i.company,"${i.joinAt} ~ ${i.quitAt}"))
                }
                for (i in it.certificate){
                    cfSimpleList.add(ZetSimple(i.name,"${i.certificateAt}"))
                }
                binding.arAcademicBg.setItems(acSimpleList)
                binding.arCareer.setItems(crSimpleList)
                binding.arCertificate.setItems(cfSimpleList)


            })
        }
    }

    private fun addRvCallback(){
        binding.arAcademicBg.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetAcademicBGFragment(Academic())
            btnAdd().setOnClickListener{
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object :AddAdapter.OnItemClickListener{
                override fun onClick(position:Int) {
                    val data:Academic = viewModel.resume.value?.let{
                        it.academic[position]
                    }!!
                    findNavController().navigate(ZetMainFragmentDirections.actionZetMainFragmentToZetAcademicBGFragment(data))
                }
            })
        }

        binding.arCareer.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetCareerFragment(Career())
            btnAdd().setOnClickListener{
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object :AddAdapter.OnItemClickListener{
                override fun onClick(position:Int) {
                    val data:Career = viewModel.resume.value?.let{
                        it.career[position]
                    }!!
                    findNavController().navigate(ZetMainFragmentDirections.actionZetMainFragmentToZetCareerFragment(data))
                }
            })
        }

        binding.arCertificate.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetCertificateFragment(Certificate())
            btnAdd().setOnClickListener{
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object :AddAdapter.OnItemClickListener{
                override fun onClick(position:Int) {
                    val data:Certificate = viewModel.resume.value?.let{
                        it.certificate[position]
                    }!!
                    findNavController().navigate(ZetMainFragmentDirections.actionZetMainFragmentToZetCertificateFragment(data))
                }
            })
        }

        binding.arMilitary.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetMilitaryServiceFragment()
            btnAdd().setOnClickListener{
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object :AddAdapter.OnItemClickListener{
                override fun onClick(position:Int) {
//                    val data:Certificate = viewModel.resume.value?.let{
//                        it.certificate[position]
//                    }!!
                    findNavController().navigate(action)
                }
            })
        }

        binding.arSns.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetSNSFragment()
            btnAdd().setOnClickListener{
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object :AddAdapter.OnItemClickListener{
                override fun onClick(position:Int) {
//                    val data:Certificate = viewModel.resume.value?.let{
//                        it.certificate[position]
//                    }!!
                    findNavController().navigate(action)
                }
            })
        }


    }


}