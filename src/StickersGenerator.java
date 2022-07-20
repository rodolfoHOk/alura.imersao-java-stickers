import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.Shape;
import java.awt.BasicStroke;
// import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class StickersGenerator {
  
  public void create(InputStream inputStream, String filename, String message) throws Exception {

    // leitura da imagem
    // File file = new File("input/filme.jpg");
    // InputStream inputStream = new FileInputStream(file);
    // String url = "https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg";
    // InputStream inputStream = new URL(url).openStream();
    BufferedImage originImage = ImageIO.read(inputStream);

    // cria nova imagem em memória com transparência e tamanho novo
    int width = originImage.getWidth();
    int height = originImage.getHeight();
    int newHeight = (int) Math.round(height * 1.15);
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para a nova imagem
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(originImage, 0, 0, null);

    // configurar a fonte
    // Aula 2 Desafio 2 - Centralizar o texto na figurinha
    int fontSize = (newHeight - height) / 2;
    // Aula 2 Desafio 5 - Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.
    var font = new Font("Comic Neue", Font.BOLD, fontSize);
    graphics.setFont(font);
    graphics.setColor(Color.ORANGE);
    
    // escrever uma frase na nova imagem
    // Aula 2 Desafio 2 - Centralizar o texto na figurinha
    int messageWidth = graphics.getFontMetrics().stringWidth(message);
    int xPosition = (width / 2) - (messageWidth / 2);
    int yPosition = newHeight - ((newHeight - height) / 2) + (font.getSize() / 2);
    graphics.drawString(message, xPosition, yPosition);

    // Aula 2 Desafio 7 - Colocar contorno (outline) no texto da imagem.
    FontRenderContext fontRenderContext = new FontRenderContext(null,false,false);
    TextLayout textLayout = new TextLayout(message, font, fontRenderContext);
    AffineTransform affineTransform = new AffineTransform();
    affineTransform.translate(xPosition, yPosition);
    Shape outline = textLayout.getOutline(affineTransform);
    graphics.setColor(Color.black);
    BasicStroke stroke = new BasicStroke(2);
    graphics.setStroke(stroke);
    graphics.draw(outline);
    
    // Aula 2 Desafio 4 - Criar diretório de saída das imagens, se ainda não existir.
    String outputDirectory = "output";
    File directory = new File(outputDirectory);
    if (!directory.exists()) {
      directory.mkdir();
    }

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File(outputDirectory + "/" + filename));

  } 

  // Somente para testes
  public static void main(String[] args) throws Exception {
    String url = "https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg";
    var generator = new StickersGenerator();
    InputStream inputStream = new URL(url).openStream();
    generator.create(inputStream, "movie-top-01.png", "TOPZERA");

    // Aula 2 Desafio 5 - Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.
    // Listar os nomes das fontes instaladas no sistema
    // GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    // String[] fontNames = environment.getAvailableFontFamilyNames();
    // for (String fontName : fontNames) {
    //   System.out.println(fontName);
    // }
  }

}
