package kr.waem.example_viewmodel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import kr.waem.example_viewmodel.R
import kr.waem.example_viewmodel.databinding.ActivityMainBinding
import kr.waem.example_viewmodel.view_model.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding
    private val model : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = model

        val setMaxNum = findViewById<Button>(R.id.setMaxNumbtn)

        setMaxNum.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
            finish()
        }

        val getMaxNum = findViewById<TextView>(R.id.tvMaxNum)
        getMaxNum.text = getString(R.string.getMaxNum, model.getMaxNum())
    }
}