package controllers;

    /*
        Classe para capturar os dados do atendimentos e
        - Enviar para a OpenAI gerar a resposta
        - Salvar no banco de dados (repositório)
     */

import entities.Atendimento;
import repositories.AtendimentoRepository;
import services.OpenAIService;

import java.util.Scanner;

public class AtendimentoController {

    private Scanner scanner = new Scanner(System.in);

    /*
        Método para executar o fluxo de cadastro de atendimento
     */

    public void gerarAtendimento(){

        try{

            System.out.println("\nATENDENTE VIRTUAL:\n");

            var atendimento = new Atendimento();

            System.out.print("INFORME SEU NOME.........: ");
            atendimento.setUsuario(scanner.nextLine());

            System.out.print("DIGITE A SUA PERGUNTA.....: ");
            atendimento.setPergunta(scanner.nextLine());

            // Enviar para a OpenAI
            var service = new OpenAIService();
           var resposta = service.enviarPergunta(atendimento.getUsuario(), atendimento.getPergunta());

            //Capturando a resposta da OpenAI
            atendimento.setResposta(resposta);

            //Salvar no banco de dados
            var repository = new AtendimentoRepository();
            repository.inserir(atendimento);

            //Mostrar a resposta:
            System.out.println("\nRESPOSTA:\n");
            System.out.println(resposta);

        }
        catch(Exception e) {
            System.out.println("\nFALHA AO GERAR ATENDIMENTO: " + e.getMessage());
        }

    }

}
