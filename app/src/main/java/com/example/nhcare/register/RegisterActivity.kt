package com.example.nhcare.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import com.example.nhcare.R
import com.example.nhcare.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private lateinit var mBinding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.fullNameEt.onFocusChangeListener = this
        mBinding.EmailEt.onFocusChangeListener = this
        mBinding.PasswordEt.onFocusChangeListener = this
        mBinding.ConfirmPasswordEt.onFocusChangeListener = this
    }
    private fun validateFullName(): Boolean {
        var errorMassege: String? = null
        val value: String = mBinding.fullNameEt.text.toString()
        if (value.isEmpty()){
            errorMassege ="nama lengkap diperlukan"
        }

        if(errorMassege != null){
            mBinding.fullNameTil.apply {
                isErrorEnabled = true
                error = errorMassege
            }
        }

        return errorMassege == null
    }
    private fun validateEmail() :Boolean{
        var errorMassege: String? = null
        val value = mBinding.EmailEt.text.toString()
        if (value.isEmpty()){
            errorMassege="email diperlukan"
        }else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()){
            errorMassege="email tidak valid"
        }
        if(errorMassege != null){
            mBinding.EmailTil.apply {
                isErrorEnabled = true
                error = errorMassege
            }
        return errorMassege == null
    }
    private fun validatePassword() :Boolean{
        var errorMassege: String? = null
        val value = mBinding.PasswordEt.text.toString()
        if (value.isEmpty()){
            errorMassege="Password diperlukan"
        }else if (value.length <8 ){
            errorMassege="Password Minimal 8 Karakter"
        }

        if(errorMassege != null){
            mBinding.PasswordTil.apply {
                isErrorEnabled = true
                error = errorMassege
            }
        return errorMassege == null
    }
    private fun validateConfirmPassword() :Boolean{
        var errorMassege: String? = null
        val value = mBinding.ConfirmPasswordEt.text.toString()
        if (value.isEmpty()){
            errorMassege="Password konfirmasi diperlukan"
        }else if (value.length <8 ){
            errorMassege="Password konfirmasi Minimal 8 Karakter"
        }

        if(errorMassege != null){
            mBinding.ConfirmPasswordTil.apply {
                isErrorEnabled = true
                error = errorMassege
            }
        return errorMassege == null
    }
    private fun validatePasswordAndConfirmPassword() :Boolean{
        var errorMassege: String? = null
        val Password = mBinding.PasswordEt.text.toString()
        val confirmPassword = mBinding.ConfirmPasswordEt.text.toString()
        if(Password != confirmPassword){
            errorMassege="password konfirmasi tidak sama dengan password"
        }
        if(errorMassege != null){
            mBinding.ConfirmPasswordTil.apply {
                isErrorEnabled = true
                error = errorMassege
            }
        return errorMassege == null
    }
            override fun onClick(view: View?) {

    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null){
            when(view.id){
                R.id.fullNameEt -> {
                    if (hasFocus) {
                        if (mBinding.fullNameTil.isErrorEnabled) {
                            mBinding.fullNameTil.isErrorEnabled = false
                        }
                    } else {
                        validateFullName()
                    }
                }
                R.id.EmailEt -> {
                    if (hasFocus){
                        if (mBinding.EmailTil.isErrorEnabled) {
                            mBinding.EmailTil.isErrorEnabled = false
                        }
                    }else{
                        validateEmail()
                    }
                }
                R.id.PasswordEt -> {
                    if (hasFocus){
                        if (hasFocus){
                            if (mBinding.PasswordTil.isErrorEnabled) {
                                mBinding.PasswordTil.isErrorEnabled = false
                            }
                    }else{
                        validatePassword()
                    }
                }
                }
                R.id.ConfirmPasswordEt ->{
                    if (hasFocus){
                        if (hasFocus){
                            if (mBinding.ConfirmPasswordTil.isErrorEnabled) {
                                mBinding.ConfirmPasswordTil.isErrorEnabled = false
                            }
                    }
                    }else{
                        validateConfirmPassword()
                    }
                }
            }

            }            }
        }
    }

    override fun onKey(view: View?, event:Int, keyEvent: KeyEvent?): Boolean {
      return false
    }
}