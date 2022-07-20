// Aula 3 Desafio 2 - Criar as suas próprias exceções e usá-las na classe de cliente HTTP
public class RequestException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public RequestException(String message) {
    super(message);
  }
  
}
