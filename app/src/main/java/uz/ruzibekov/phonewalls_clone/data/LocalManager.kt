package uz.ruzibekov.phonewalls_clone.data

import android.content.SharedPreferences
import com.google.gson.Gson
import javax.inject.Inject


class LocalManager @Inject constructor(
    private val preferences: SharedPreferences,
    private val gson: Gson
) {

    var favorites: List<String> = emptyList()
        get() {
            val json = preferences.getString("favorites", "") ?: ""
            return if (json.isNotEmpty())
                gson.fromJson(json, Array<String>::class.java).toList()
            else emptyList()
        }
        set(value) {
            val json = gson.toJson(value)
            preferences.edit().putString("favorites", json).apply()
            field = value
        }
}