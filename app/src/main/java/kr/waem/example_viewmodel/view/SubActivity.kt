package kr.waem.example_viewmodel.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.waem.example_viewmodel.R
import kr.waem.example_viewmodel.databinding.ActivitySubBinding
import kr.waem.example_viewmodel.view_model.MainViewModel

class SubActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivitySubBinding
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_sub)

        mBinding.lifecycleOwner = this
        mBinding.viewmodelSub = MainViewModel()

        val max : EditText = findViewById(R.id.maxnum)
        val completeBtn : Button = findViewById(R.id.complete)

        completeBtn.setOnClickListener {
            if(max.text.toString().isEmpty()) {
                Toast.makeText(this, "숫자를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                model.setMaxNum(max.text.toString().toInt())
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}