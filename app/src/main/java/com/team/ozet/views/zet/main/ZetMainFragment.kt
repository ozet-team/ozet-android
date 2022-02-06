package com.team.ozet.views.zet.main

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import coil.load
import com.team.ozet.R
import com.team.ozet.base.BaseFragment
import com.team.ozet.data.resume.AcademicModel
import com.team.ozet.data.resume.CareerModel
import com.team.ozet.data.resume.CertificateModel
import com.team.ozet.data.resume.MilitaryModel
import com.team.ozet.data.user.UserModel
import com.team.ozet.data.zet.ZetSimple
import com.team.ozet.databinding.FragmentZetMainBinding
import com.team.ozet.views.custom_view.add_recycler.AddAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZetMainFragment : BaseFragment<FragmentZetMainBinding>(R.layout.fragment_zet_main) {
    private val viewModel: ZetMainViewModel by viewModel()
    override fun init() {
        binding.vm = viewModel
        viewModelCallBack()
        addRvCallback()
        // todo SharedPreferences token 으로 대체
        val token =
            "JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5LCJ1c2VybmFtZSI6Im96ZXRfZDE2MDY2ZjA5YjU5NDI3NmJiN2Q5NjI4ZTVlYTE1NjQiLCJleHAiOjE2NDQ2NTk1Njl9.fBx1QnFXjnQRD1qqahJWoGWYtmJRMXQofZAFjwsn0wk"
        viewModel.apply {
            getResume("9", token)
//            getUser(token)
        }


    }

    private fun viewModelCallBack() {
        with(viewModel) {
            resumeModel.observe(this@ZetMainFragment, Observer {
                var acSimpleList = arrayListOf<ZetSimple>()
                var crSimpleList = arrayListOf<ZetSimple>()
                var cfSimpleList = arrayListOf<ZetSimple>()
                var mySimpleLIst = arrayListOf<ZetSimple>()


                if (it.academic != null) {
                    for (i in it.academic) {
                        acSimpleList.add(ZetSimple(i.location, "${i.joinAt} ~ ${i.quitAt}"))
                    }
                }

                if (it.career != null) {
                    for (i in it.career) {
                        crSimpleList.add(ZetSimple(i.company, "${i.joinAt} ~ ${i.quitAt}"))
                    }
                }
                if (it.certificate != null) {
                    for (i in it.certificate) {
                        cfSimpleList.add(ZetSimple(i.name, "${i.certificateAt}"))
                    }
                }
                if (it.military != null) {
                    if (it.military.service != null) {
                        var at = ""
                        if (!it.military.joinAt.equals("")) {
                            at = "${it.military.joinAt} ~ ${it.military.quitAt}"
                        }
                        mySimpleLIst.add(ZetSimple(it.military.service, at))
                    }
                }

                binding.arAcademicBg.setItems(acSimpleList)
                binding.arCareer.setItems(crSimpleList)
                binding.arCertificate.setItems(cfSimpleList)
                binding.arMilitary.setItems(mySimpleLIst)


            })

            userModel.observe(this@ZetMainFragment, Observer {
                binding.arIntroduce.setItems(arrayListOf(ZetSimple(it.introduce, "")))
                binding.arAddress.setItems(arrayListOf(ZetSimple(it.address, "")))
                binding.civProfile.load(it.profileImage)
            })
        }
    }

    private fun addRvCallback() {
        binding.arAcademicBg.apply {
            var action =
                ZetMainFragmentDirections.actionZetMainFragmentToZetAcademicBGFragment(AcademicModel())
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
                    val data: AcademicModel = viewModel.resumeModel.value?.let {
                        it.academic[position]
                    }!!
                    findNavController().navigate(
                        ZetMainFragmentDirections.actionZetMainFragmentToZetAcademicBGFragment(
                            data
                        )
                    )
                }
            })
        }

        binding.arCareer.apply {
            var action =
                ZetMainFragmentDirections.actionZetMainFragmentToZetCareerFragment(CareerModel())
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
                    val data: CareerModel = viewModel.resumeModel.value?.let {
                        it.career[position]
                    }!!
                    findNavController().navigate(
                        ZetMainFragmentDirections.actionZetMainFragmentToZetCareerFragment(
                            data
                        )
                    )
                }
            })
        }

        binding.arCertificate.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetCertificateFragment(
                CertificateModel()
            )
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
                    val data: CertificateModel = viewModel.resumeModel.value?.let {
                        it.certificate[position]
                    }!!
                    findNavController().navigate(
                        ZetMainFragmentDirections.actionZetMainFragmentToZetCertificateFragment(
                            data
                        )
                    )
                }
            })
        }

        binding.arMilitary.apply {
            var action =
                ZetMainFragmentDirections.actionZetMainFragmentToZetMilitaryServiceFragment(
                    MilitaryModel()
                )
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
                    val data: MilitaryModel = viewModel.resumeModel.value?.let {
                        it.military
                    }!!
                    findNavController().navigate(
                        ZetMainFragmentDirections.actionZetMainFragmentToZetMilitaryServiceFragment(
                            data
                        )
                    )
                }
            })
        }




        binding.arAddress.apply {

            var action =
                ZetMainFragmentDirections.actionZetMainFragmentToZetAddressFragment(UserModel())
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
//                    val data:Certificate = viewModel.resume.value?.let{
//                        it.certificate[position]
//                    }!!
                    val data: UserModel? = viewModel.userModel.value
                    findNavController().navigate(
                        ZetMainFragmentDirections.actionZetMainFragmentToZetAddressFragment(
                            data!!
                        )
                    )
                }
            })
        }


        binding.arIntroduce.apply {
            var action =
                ZetMainFragmentDirections.actionZetMainFragmentToZetIntroduceFragment(UserModel())
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
                    val data: UserModel? = viewModel.userModel.value
                    findNavController().navigate(
                        ZetMainFragmentDirections.actionZetMainFragmentToZetIntroduceFragment(
                            data!!
                        )
                    )
                }
            })
        }
        binding.arSns.apply {
            var action = ZetMainFragmentDirections.actionZetMainFragmentToZetSNSFragment()
            btnAdd().setOnClickListener {
                findNavController().navigate(action)
            }
            tvSub().setOnClickListener {
                findNavController().navigate(action)
            }
            adapter().setItemClickListener(object : AddAdapter.OnItemClickListener {
                override fun onClick(position: Int) {
//                    val data:Certificate = viewModel.resume.value?.let{
//                        it.certificate[position]
//                    }!!
                    findNavController().navigate(action)
                }
            })
        }

    }


}