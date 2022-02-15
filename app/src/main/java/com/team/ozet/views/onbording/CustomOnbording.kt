package com.team.ozet.views.onbording

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.team.ozet.R
import com.team.ozet.views.main.MainActivity

class CustomOnbording : AppIntro() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!

        // Call addSlide passing your Fragments.
        // You can use AppIntroFragment to use a pre-built fragment

        //레이아웃을 생성하여 사용가능
        //AppIntroCustomLayoutFragment.newInstance(R.layout.intro_custom_layout1)
        addSlide(
            AppIntroFragment.newInstance(
                title = "The title of your slide",
                description = "A description that will be shown on the bottom",
                titleColor = Color.WHITE,
                descriptionColor = Color.YELLOW,
                backgroundColor = Color.GREEN,
                titleTypefaceFontRes = R.font.spoqa_han_sans_neo_regular,
                descriptionTypefaceFontRes = R.font.spoqa_han_sans_neo_bold,

                )
        )
//        addSlide(AppIntroFragment.newInstance(
//            title = "시니어누리4",
//            description = "This is the last slide, I won't annoy you more :)" ,
//            titleColor = Color.WHITE,
//            descriptionColor = Color.WHITE,
//            backgroundColor = Color.DKGRAY,
//            titleTypefaceFontRes = R.font.seoul_namsan_eb,
//            descriptionTypefaceFontRes = R.font.seoul_namsan_b,
//        ))

        // Toggle Indicator Visibility 토글제거 false
        isIndicatorEnabled = true

        // Change Indicator Color 토글색상
        setIndicatorColor(
            selectedIndicatorColor = getColor(R.color.purple_700),
            unselectedIndicatorColor = getColor(R.color.Background_Dark)

        )
        // 하단 색 설정
        setColorSkipButton(Color.BLACK)
        setNextArrowColor(Color.BLACK)
        setColorDoneText(Color.BLACK)

        // Switch from Dotted Indicator to Progress Indicator
        //setProgressIndicator()

        // Supply your custom `IndicatorController` implementation
        //indicatorController = MyCustomIndicator(/* initialize me */)

//        // Hide/Show the status Bar
//        showStatusBar(true)
//        // Control the status bar color
//        setStatusBarColor(Color.GREEN)
//        setStatusBarColorRes(R.color.colorGreen)
//
//        // Control the navigation bar color
//        setNavBarColor(Color.RED)
//        setNavBarColorRes(R.color.colorRed)

        //슬라이드 이동 방식
        //setTransformer(AppIntroPageTransformerType.Fade)
        //setTransformer(AppIntroPageTransformerType.Zoom)
        //setTransformer(AppIntroPageTransformerType.Flow)
        //setTransformer(AppIntroPageTransformerType.SlideOver)
        //setTransformer(AppIntroPageTransformerType.Depth)
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Decide what to do when the user clicks on "Skip"
        //스킵 버튼 메인으로 이동
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        finish()

//        PreferenceManager(this).appIntro = true;
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Decide what to do when the user clicks on "Done"
        //완료 버튼 메인으로 이동
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
        finish()

//        PreferenceManager(this).appIntro = true;
    }


}
