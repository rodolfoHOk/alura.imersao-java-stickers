import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

  public List<Content> contentExtractor(String json) {
    var jsonParser = new JsonParser();
    List<Map<String, String>> contentMapList = jsonParser.parse(json);

    List<Content> contents = new ArrayList<>();
    for (Map<String, String> contentMap : contentMapList) {
      String title = contentMap.get("title");
      String imageUrl = contentMap.get("url");
      var content = new Content(title, imageUrl);
      contents.add(content);
    }

    return contents;
  }

}
