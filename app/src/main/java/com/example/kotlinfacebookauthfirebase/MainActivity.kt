package com.example.kotlinfacebookauthfirebase

import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationRequest
import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
//import com.facebook.AccessToken
//import com.facebook.CallbackManager
//import com.facebook.FacebookCallback
//import com.facebook.FacebookException
//import com.facebook.login.LoginResult
//import com.facebook.login.widget.LoginButton
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.math.sign

class MainActivity : AppCompatActivity() {


    var firebaseAuth: FirebaseAuth? = null
//    var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     //   firebaseAuth = FirebaseAuth.getInstance()
//        callbackManager = CallbackManager.Factory.create()
//        findViewById<LoginButton>(R.id.btn_login).setReadPermissions("email")
//        findViewById<LoginButton>(R.id.btn_login).setOnClickListener {
//            signIn()
//        }

    }
//
//    private fun signIn() {
//        findViewById<LoginButton>(R.id.btn_login).registerCallback(callbackManager,
//            object : FacebookCallback<LoginResult> {
//                override fun onSuccess(result: LoginResult?) {
//
//                    handleFacebookAccessToken(result!!.accessToken)
//                }
//
//                override fun onCancel() {
//
//                }
//
//                override fun onError(error: FacebookException?) {
//
//                }
//
//            })
//    }
//
//    private fun handleFacebookAccessToken(accessToken: AccessToken?) {
//
//        val credential = FacebookAuthProvider.getCredential(accessToken!!.token)
//        firebaseAuth?.signInWithCredential(credential)
//            ?.addOnFailureListener { e ->
//                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
//            }
//            ?.addOnSuccessListener { result ->
//
//                val email = result.user?.email
//                Toast.makeText(this, "You logged with email :" + email, Toast.LENGTH_LONG).show()
//                var e = null
//                e?.let { Log.e("ERROR_EDMT", it.extension) }
//            }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        callbackManager!!.onActivityResult(requestCode, resultCode, data)
    }

    private fun printHash() = try {
        val info = packageManager.getPackageInfo("com.example.kotlinfacebookauthfirebase", 0)
//        = PackageManager.getPackageInfo("com.example.kotlinfacebookauthfirebase", packageManager)
        for (signature in info.signatures)
        {
            val md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray())
            Log.e("KEYHASH", Base64.encodeToString(md.digest(), Base64.DEFAULT))
        }
    }
    catch (e:PackageManager.NameNotFoundException)
    {

    }
    catch (e:NoSuchAlgorithmException)
    {

    }
}


