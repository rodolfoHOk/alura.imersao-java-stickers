import java.util.List;
import java.util.Map;

public class LanguageApiContentExtractor implements ContentExtractor {

  @Override
  public List<Content> contentExtractor(String json) {
    var jsonParser = new JsonParser();
    List<Map<String, String>> contentMapList = jsonParser.parse(json);

    // Aula 3 Desafio 3 - Usar recursos do Java 8 como Streams e Lambdas, para mapear uma lista em uma outra
    // Aula 4 Desafio 3
    List<Content> contents = contentMapList.stream()
      .map(contentMap -> new Content(contentMap.get("nome"), contentMap.get("urlImagem"))).toList();

    return contents;
  }
  
}
