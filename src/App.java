import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";

        // buscar os dados
        var httpClient = new AppHttpClient();
        String json = httpClient.getData(url);
        
        // extrair os dados que interessam
        // ContentExtractor contentExtractor = new ImDbContentExtractor();
        ContentExtractor contentExtractor = new NasaContentExtractor();
        List<Content> contents = contentExtractor.contentExtractor(json);

        // criar instância do gerador de figurinhas
        var generator = new StickersGenerator();

        for (int i = 0; i < 3; i++) {
            // criar o sticker da imagem
            Content content = contents.get(i);
            String imageUrl = content.getImageUrl();
            InputStream inputStream = new URL(imageUrl).openStream();
            String title = content.getTitle();
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
