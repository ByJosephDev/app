package pe.edu.tecsup.musiclover.network

data class NuevosLanzamientosResponse(
    val albums: Albums?
) {
    data class Albums(
        val href: String?,
        val items: List<Item?>?,
        val limit: Int?,
        val next: String?,
        val offset: Int?,
        val previous: Any?,
        val total: Int?
    ) {
        data class Item(
            val album_type: String?,
            val artists: List<Artist?>?,
            val available_markets: List<String?>?,
            val external_urls: ExternalUrls?,
            val href: String?,
            val id: String?,
            val images: List<Image?>?,
            val name: String?,
            val release_date: String?,
            val release_date_precision: String?,
            val total_tracks: Int?,
            val type: String?,
            val uri: String?
        ) {
            data class Artist(
                val external_urls: ExternalUrls?,
                val href: String?,
                val id: String?,
                val name: String?,
                val type: String?,
                val uri: String?
            ) {
                data class ExternalUrls(
                    val spotify: String?
                )
            }

            data class ExternalUrls(
                val spotify: String?
            )

            data class Image(
                val height: Int?,
                val url: String?,
                val width: Int?
            )
        }
    }
}