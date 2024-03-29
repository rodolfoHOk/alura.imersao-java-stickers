import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class AppHttpClient {
  
  public String getData(String url) {
    try {
      URI uri = URI.create(url);
      var client = HttpClient.newHttpClient();
      var request = HttpRequest.newBuilder(uri).GET().build();
      HttpResponse<String> response;
      response = client.send(request, BodyHandlers.ofString());
      String body = response.body();
      return body;
      
    } catch (IOException | InterruptedException ex) {
      // Aula 3 Desafio 2 - Criar as suas próprias exceções e usá-las na classe de cliente HTTP
      throw new RequestException(ex.getMessage());
    }
  }

}
