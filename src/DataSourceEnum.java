// Aula 3 Desafio 4 - Criar uma Enum que une, como configurações, a URL da API e o extrator utilizado
public enum DataSourceEnum {

  IMDB("https://api.mocki.io/v2/549a5d8b/Top250Movies", new ImDbContentExtractor()),
  NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD", new NasaContentExtractor()),
  LANGUAGES_API("http://localhost:8080/api/v1/linguagens", new LanguageApiContentExtractor());

  private String url;
  private ContentExtractor contentExtractor;

  private DataSourceEnum(String url, ContentExtractor contentExtractor) {
    this.url = url;
    this.contentExtractor = contentExtractor;
  }

  public String getUrl() {
    return url;
  }

  public ContentExtractor getContentExtractor() {
    return contentExtractor;
  }
  
}
