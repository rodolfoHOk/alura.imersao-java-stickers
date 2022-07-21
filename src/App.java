import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // String url = DataSourceEnum.IMDB.getUrl(); // Aula 3 Desafio 4
        // String url = DataSourceEnum.NASA.getUrl(); // Aula 3 Desafio 4
        String url = DataSourceEnum.LANGUAGES_API.getUrl(); // Aula 4

        // buscar os dados
        var httpClient = new AppHttpClient();
        String json = httpClient.getData(url);
        
        // extrair os dados que interessam
        // ContentExtractor contentExtractor = DataSourceEnum.IMDB.getContentExtractor(); // Aula 3 Desafio 4
        // ContentExtractor contentExtractor = DataSourceEnum.NASA.getContentExtractor(); // Aula 3 Desafio 4
        ContentExtractor contentExtractor = DataSourceEnum.LANGUAGES_API.getContentExtractor(); // Aula 4
        List<Content> contents = contentExtractor.contentExtractor(json);

        // criar instância do gerador de figurinhas
        var generator = new StickersGenerator();

        for (int i = 0; i < 3; i++) {
            // criar o sticker da imagem
            Content content = contents.get(i);
            String imageUrl = content.imageUrl(); // Aula 3 Desafio 1
            InputStream inputStream = new URL(imageUrl).openStream();
            String title = content.title(); // Aula 3 Desafio 1
            String filename = title + ".png";
            String message = "TOPZERA";
            generator.create(inputStream, filename, message);
            
            // exibir dados
            System.out.println("\u001b[102;1m \u001b[31;1m" + title + " \u001b[m");
            System.out.println("\u001b[34;3m" + imageUrl + "\u001b[m");
            System.out.println();
        }
    }
}
