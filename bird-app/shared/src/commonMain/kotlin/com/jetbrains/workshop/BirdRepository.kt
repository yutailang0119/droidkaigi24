import com.jetbrains.workshop.BirdImage
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json

class BirdRepository {
    val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getImages(): List<BirdImage> {
        return httpClient
            .get("https://sebi.io/demo-image-api/pictures.json")
            .body<List<BirdImage>>()
    }

    fun close() {
        
    }
}