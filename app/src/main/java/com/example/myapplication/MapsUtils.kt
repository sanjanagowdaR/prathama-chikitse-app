package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openNearbyHospitals(context: Context) {
    val uri = Uri.parse("geo:0,0?q=hospitals+near+me")

    val intent = Intent(Intent.ACTION_VIEW, uri)
    intent.setPackage("com.google.android.apps.maps")

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        val webIntent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.google.com/maps/search/hospitals+near+me")
        )
        context.startActivity(webIntent)
    }
}

