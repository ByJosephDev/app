package pe.edu.tecsup.musiclover.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://api.spotify.com/v1/"
private const val TOKEN =
    "BQAO7tU0-xfhWfAzFOD4wCi-GVhWLIyT5VHJ98H2AVP425e57DtNryJuQH8CZ39fvHDxmDUpZZKB0qc25_o"

private val Logging = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)

private val client = OkHttpClient.Builder()
    .addInterceptor(Logging)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface SpotifyApiService {
    @Headers("Authorization: Bearer $TOKEN")
    @GET("search")
    suspend fun buscar(
        @Query("type") tipo: String,
        @Query("q") q: String
    ): BusquedaResponse

    @Headers("Authorization: Bearer $TOKEN")
    @GET("browse/new-releases")
    suspend fun nuevosLanzamientos(): NuevosLanzamientosResponse
}

object SpotifyApi {
    val retrofitService: SpotifyApiService by lazy { retrofit.create(SpotifyApiService::class.java) }
}