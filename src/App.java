import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // conexão com a API
        String url = "https://alura-filmes.herokuapp.com/conteudos";
        URI endereço = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereço).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair os dados que seram utilizados
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // manipular os dados
        for (Map<String,String> filme : listaDeFilmes) {
           System.out.println(filme.get("title"));
           System.out.println(filme.get("image"));
           System.out.println(filme.get("imDbRating")); 
        }
    }
}
