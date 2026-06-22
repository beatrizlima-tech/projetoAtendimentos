package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/*
    Classe para que possamos fazer a integração com
    os serviços da API da OpenAI (ChatGPT)
 */

public class OpenAIService {

    /*
        Método para enviar uma pergunta para a OpenAI e obter a resposta
     */

    public String enviarPergunta(String usuario, String pergunta) throws Exception {

        //Chave para conexão com a OpenAI
        var secretKey = System.getenv("OPENAI_API_KEY");

        //Armazenar o ENDPOINT (endereço da API)
        var endpoint = "https://api.openai.com/v1/responses";

        //Texto para gerar o treinamento da IA (prompt do sistema)
        var promptSistema = "Você é um atendente de suporte de TI para atender dúvidas dos usuários. Resposta de maneira cordial e objetiva. Só responda perguntas relacionadas a assuntos de suporte de TI. Para outras perguntas diga que não é a sua especialidade.";

        //Texto para enviar a pergunta (prompt do usuário)
        var promptUsuario = "Meu nome é: " + usuario + ", minha dúvida é: " + pergunta;

        //Criando os dados em JSON que serão enviados para a OpenAI
        var json = """
                    {
                        "model" : "gpt-4.1",
                        "input" : "%s"
                    }
                """.formatted(promptSistema + promptUsuario);

        //Fazendo a chamada para a OpenAI
        var body = RequestBody.create(json, MediaType.parse("application/json"));
        var request = new Request.Builder()
                .url(endpoint) //endereço da API OpenAI
                .addHeader("Content-Type", "application/json") //JSON
                .addHeader("Authorization", "Bearer " + secretKey) //CHAVE
                .post(body) //DADOS da pergunta
                .build(); //Finalizar

        //Executando a chamada e pegar a resposta
        var http = new OkHttpClient.Builder().build();
        var response = http.newCall(request).execute();

        var responseBody = response.body().string();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseBody);

        String mensagem = root
                .path("output")
                .get(0)
                .path("content")
                .get(0)
                .path("text")
                .asText();

        return mensagem;
    }
}
