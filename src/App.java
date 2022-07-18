import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
// import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Desafio 1 - Consumir o endpoint de filmes mais populares da API do IMDB.
        // String baseUrl = "https://imdb-api.com/en/API/MostPopularMovies/";

        // Desafio 3 - Colocar a chave da API do IMDB em algum lugar fora do código como um arquivo de configuração.
        // String baseUrl = "https://imdb-api.com/en/API/Top250Movies/";
        // String imdbAPIKey = System.getenv("IMDB_KEY");
        // String url = baseUrl + imdbAPIKey;
        
        // Obs: Opção ao IMDB API pois servidor caiu.
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        // fazer uma conexão http e buscar os top 250 filmes
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        // extrair os dados que interessam (título, poster, nota) e exibir
        // Desafio 4 - Mudar o JsonParser para usar uma biblioteca de parsing de JSON
        var objectMapper = new ObjectMapper();
        ImdbResponse imdbResponse = objectMapper.readValue(body, ImdbResponse.class);
        List<FilmData> filmList = imdbResponse.getItems();
        for (FilmData film : filmList) {
            // Desafio 2 - Usar sua criatividade para deixar a saída dos dados mais bonitinha
            System.out.println("\u001b[102;1m \u001b[31;1m" + film.getTitle() + " \u001b[m");
            System.out.println("\u001b[34;3m" + film.getImage() + "\u001b[m");
            for(int i = 0; i < Math.round(Float.parseFloat(film.getImDbRating())); i ++) {
                System.out.print("\u2B50");
            }
            System.out.println("\u001b[1m (" + film.getImDbRating() + ")\u001b[m");
            System.out.println();
        }

        // var jsonParser = new JsonParser();
        // List<Map<String, String>> filmsList = jsonParser.parse(body);
        // for (Map<String,String> film : filmsList) {
        //     System.out.println(film.get("title"));
        //     System.out.println(film.get("image"));
        //     System.out.println(film.get("imDbRating"));
        //     System.out.println();
        // }
    }
}
