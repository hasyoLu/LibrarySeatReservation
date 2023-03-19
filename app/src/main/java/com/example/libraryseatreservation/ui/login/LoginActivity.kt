package com.example.libraryseatreservation.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.haa_roh.db.INPUTRIGHT
import com.example.haa_roh.db.NOTFWTHEAUTOCODE
import com.example.libraryseatreservation.MainActivity
import com.example.libraryseatreservation.db.querySpIsLogin
import com.example.libraryseatreservation.R
import com.example.libraryseatreservation.base.BaseActivity
import com.example.libraryseatreservation.databinding.ActivityLoginBinding
import com.example.libraryseatreservation.db.saveToSp
import com.example.libraryseatreservation.ui.ItemFragment
import com.example.libraryseatreservation.util.afterTextChanged

/**
 * author : hasyo
 * time : 2023/3/17
 * 登录组件，集成BMob完成短信验证登录功能，使用 ViewBind+ViewModel实现
 */
class LoginActivity : BaseActivity() {
    private lateinit var binding : ActivityLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    private lateinit var phone : EditText
    private lateinit var code : EditText
    private lateinit var login : Button
    private lateinit var loading : ProgressBar
    private lateinit var authCode : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(status == 0) {
            isStartLogin()
        }
        initView()
        initData()
    }
    /*
        overridePendingTransition(0, 0)用来取消跳转动画
   */
    private fun isStartLogin() {
        if( querySpIsLogin() ){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }
    }
    private fun initView() {
        //获取ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun initData() {

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        phone = binding.username
        code = binding.password
        login = binding.login
        loading = binding.loading
        authCode = binding.authCode
        //获取输入并检测输入格式是否正确
        initInputData()
        initAuthCodeData()
        initVerifyData()
    }

    private fun initAuthCodeData() {
        authCode.setOnClickListener{
            NOTFWTHEAUTOCODE = false
            loginViewModel.loginSendCode(phone.text.toString().trim() )
        }
        loginViewModel.loginGetAutoCode.observe(this, Observer {
            val loginAutoCode = it ?: return@Observer
            if( loginAutoCode.error != null ){
                Toast.makeText(this,"发送失败",Toast.LENGTH_LONG).show()
            }else{
                login.isEnabled = true
            }
        })
        loginViewModel.loginCountNumber.observe(this, Observer {
            val countNumber = it ?: return@Observer
            if(countNumber.textCountNumber != null){
                authCode.text = countNumber.textCountNumber
            }
            authCode.setBackgroundResource(countNumber.textColor)
            authCode.isEnabled = countNumber.isEnable
        })
    }

    private fun initInputData() {
        //输入发生改变后，调用ViewModel中的方法区判断输入是否有异常
        phone.afterTextChanged {
            loginViewModel.loginDataChanged(
                phone.text.toString().trim(),
                code.text.toString().trim()
            )
        }
        code.afterTextChanged {
            loginViewModel.loginDataChanged(
                phone.text.toString().trim(),
                code.text.toString().trim()
            )
        }
        loginViewModel.loginFormState.observe(this, Observer {
            val loginState = it ?:  return@Observer
            //根据登录状态 设置 login按钮是否可以点击
            //login.isEnabled = loginState.isDataValid
            if (loginState.usernameError != null) {
                phone.error = getString(loginState.usernameError)
            }
            else {
                //可以发验证码了
                if(NOTFWTHEAUTOCODE){
                    authCode.isEnabled = loginState.isUserNameValid
                    authCode.setBackgroundResource(R.color.authCode)
                }
                INPUTRIGHT = loginState.isUserNameValid && loginState.isPasswordValid
            }
        })
    }

    private fun initVerifyData() {

        login.setOnClickListener{
            if(!INPUTRIGHT){
                showErrorToast(this,getString(R.string.inputError))
                return@setOnClickListener
            }else{
                //点击登录后设置 等待 可见
                loading.visibility = View.VISIBLE
                loginViewModel.loginVerificationResult(phone.text.toString().trim(),
                    code.text.toString().trim())
            }
        }
        loginViewModel.loginResult.observe(this, Observer {
            val result = it ?: return@Observer
            if(result.success){
                showSuccessToast(this,"登录成功")
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                showErrorToast(this,getString(R.string.sendAutoCodeError))
            }
        })
    }

    companion object {
        private var status = 0
        fun newInstance(activity: Activity, status: Int) {
            this.status = status
            val intent = Intent(activity, LoginActivity::class.java)
            activity.startActivity(intent)
            saveToSp("", false)
            activity.finish()
        }

    }

}