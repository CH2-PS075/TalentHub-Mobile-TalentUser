package com.ch2ps075.talenthub.ui.auth.registertalent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import cn.pedant.SweetAlert.SweetAlertDialog
import com.ch2ps075.talenthub.R
import com.ch2ps075.talenthub.data.preference.LanguagePreferences
import com.ch2ps075.talenthub.data.preference.languageDataStore
import com.ch2ps075.talenthub.databinding.ActivityRegisterTalentBinding
import com.ch2ps075.talenthub.helper.uriToFile
import com.ch2ps075.talenthub.helper.reduceFileImage
import com.ch2ps075.talenthub.state.ResultState
import com.ch2ps075.talenthub.ui.ViewModelFactory
import com.ch2ps075.talenthub.ui.auth.login.LoginActivity

class RegisterTalentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterTalentBinding
    private var selectedFile: Uri? = null
    private val viewModel by viewModels<RegisterTalentViewModel> {
        ViewModelFactory.getInstance(this, LanguagePreferences.getInstance(this.languageDataStore))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterTalentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            registerButton.setOnClickListener {
                when {
                    selectedFile == null -> {
                        Toast.makeText(this@RegisterTalentActivity, getString(R.string.error_empty_field), Toast.LENGTH_SHORT).show()
                    }

                    edRegisterTalentname.text.toString().isEmpty() -> {
                        edRegisterTalentname.error = getString(R.string.error_empty_field)
                    }

                    edRegisterQuantity.text.toString().isEmpty() -> {
                        edRegisterQuantity.error = getString(R.string.error_empty_field)
                    }

                    edRegisterAddress.text.toString().isEmpty() -> {
                        edRegisterAddress.error = getString(R.string.error_empty_field)
                    }

                    edRegisterCategory.text.toString().isEmpty() -> {
                        edRegisterCategory.error = getString(R.string.error_empty_field)
                    }

                    edRegisterContact.text.toString().isEmpty() -> {
                        edRegisterContact.error = getString(R.string.error_empty_field)
                    }

                    edRegisterPrice.text.toString().isEmpty() -> {
                        edRegisterPrice.error = getString(R.string.error_empty_field)
                    }

                    edRegisterEmail.text.toString().isEmpty() -> {
                        edRegisterEmail.error = getString(R.string.error_empty_field)
                    }

                    edRegisterPassword.text.toString().length < 8 -> {
                        edRegisterPassword.error = getString(R.string.error_short_password)
                    }

                    else -> register()
                }



                tvSignin.setOnClickListener {
                    startActivity(Intent(this@RegisterTalentActivity, LoginActivity::class.java))
                }
            }
        }
        binding.btnUploadImage.setOnClickListener {
            startGallery()
        }
        binding.tvSignin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }


    private fun startGallery() {
        launcherGallery.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
    }

    private val launcherGallery = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            selectedFile = uri
            showImage()
        } else {
            Log.d("Photo Picker", "No media selected")
        }
    }

    private fun showImage() {
        selectedFile?.let {
            Log.d("Image URI", "showImage: $it")
            binding.imageView.setImageURI(it)
        }
    }


    private fun register() {
        selectedFile?.let { uri ->
            val imageFile = uriToFile(uri, this@RegisterTalentActivity).reduceFileImage()
            Log.d("Image File", "showImage: ${imageFile.path}")
        }

        with(binding) {
            val picture = imageView.drawable?.toString() ?: ""
            val talentName = edRegisterTalentname.text.toString()
            val quantity = edRegisterQuantity.text.toString()
            val address = edRegisterAddress.text.toString()
            val category = edRegisterCategory.text.toString()
            val contact = edRegisterContact.text.toString()
            val price = edRegisterPrice.text.toString()
            val email = edRegisterEmail.text.toString()
            val password = edRegisterPassword.text.toString()


            viewModel.register(picture, talentName, quantity, address, category, contact, price, email, password)
                .observe(this@RegisterTalentActivity) { result ->
                    if (result != null) {
                        when (result) {
                            is ResultState.Loading -> {
                                showLoading(true)
                            }

                            is ResultState.Success -> {
                                showSuccessAlert()
                                showLoading(false)
                            }

                            is ResultState.Error -> {
                                showErrorAlert()
                                showLoading(false)
                            }
                        }
                    }
                }

        }
    }

    private fun showSuccessAlert() {
        SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
            .setTitleText(getString(R.string.success_title))
            .setContentText(getString(R.string.success_register_message))
            .setConfirmButton(getString(R.string.login_text)) {
                startActivity(Intent(this, LoginActivity::class.java))
            }
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }

    private fun showErrorAlert() {
        SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
            .setTitleText(getString(R.string.failed_title))
            .setContentText(getString(R.string.failed_register_message))
            .setConfirmButton(getString(R.string.try_again_title)) {
                it.dismissWithAnimation()
            }
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}