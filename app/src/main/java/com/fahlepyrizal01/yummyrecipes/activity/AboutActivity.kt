package com.fahlepyrizal01.yummyrecipes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.fahlepyrizal01.yummyrecipes.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        
        toolbarAbout.run {
            title = resources.getString(R.string.text_about)
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener { finish() }
        }

        Glide.with(this)
            .load(ContextCompat.getDrawable(this, R.drawable.profile))
            .circleCrop()
            .into(circleImageViewProfileAbout)

        textViewNameAbout.text = resources.getString(R.string.text_name)
        textViewEmailAbout.text = resources.getString(R.string.text_email)
    }
}
