package com.team.ozet.views

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.team.ozet.views.main_fragment.MainAdapter
import com.team.ozet.views.main_fragment.NoticeAdapter


// recyclerview setItems
@Suppress("UNCHECKED_CAST")
@BindingAdapter("setItems")
fun RecyclerView.setAdapterItems(items:List<Any>?){
    when(adapter){
        is NoticeAdapter ->{
            items?.let {
                with(adapter as NoticeAdapter){
                    clear()
                    addItems(it as List<String>)
                }
            }
        }
        is MainAdapter->{
            items?.let {
                with(adapter as MainAdapter){
                    clear()
                }
            }
        }

        else ->{
        Log.d("AAA", "바인딩어댑터 setItems 예외 에러")
        }
    }
}

// viewpager2 setItems
//@BindingAdapter("setItems")
//fun ViewPager2.setAdapterItems(items:List<UserInfo>?){
//    when(adapter){
//       is HealthUserAdapter ->{
//        items?.let {
//            with(adapter as HealthUserAdapter){
//                clear()
//                addItems(it)
//            }
//        }
//    }else ->{
//        Log.d("AAA", "바인딩어댑터 setItems 예외 에러")
//    }
//    }
