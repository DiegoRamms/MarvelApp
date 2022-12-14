package com.dbappgame.marvel.core.security

import com.dbappgame.marvel.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val ts = Timestamp(System.currentTimeMillis()).time.toString()
        val input = "$ts${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}"
        val md = MessageDigest.getInstance("MD5")
        val hash = BigInteger(1, md.digest(input.toByteArray()))
            .toString(16)
            .padStart(32, '0')

        val request = chain.request()
        val url = request.url

        val newUrl = url.newBuilder().apply {
            this.addQueryParameter("ts", ts)
            this.addQueryParameter("hash", hash)
            this.addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
            this.addQueryParameter("limit","100")
        }.build()


        val newRequest = request.newBuilder().url(newUrl).build()

        return chain.proceed(newRequest)

    }
}

