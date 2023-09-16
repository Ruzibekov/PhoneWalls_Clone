package uz.ruzibekov.phonewalls_clone.data.api

import retrofit2.http.GET
import uz.ruzibekov.phonewalls_clone.data.model.WallpaperResponse

interface ApiService {

    @GET("images/search?limit=10")
    suspend fun getCatsImageList(): List<WallpaperResponse>
}