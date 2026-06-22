package repositories;

import entities.Atendimento;
import factories.ConnectionFactory;

import java.sql.Connection;

public class AtendimentoRepository {

    /*
        Método para salvar um registro de atendimento no banco de dados
     */

    public void inserir(Atendimento atendimento) throws Exception{

        // Abrindo conexão com banco de dados
        var factory = new ConnectionFactory();
        var connection = factory.getConnection();

        //Escrevendo um comando SQL para ser executado no banco de dados
        var sql = """
                    INSERT INTO atendimentos(usuario, pergunta, resposta)
                    VALUES(?,?,?)
                """;

        //Preparando o comando SQL para ser executado no banco
        var statement = connection.prepareStatement(sql);
        statement.setString(1, atendimento.getUsuario());
        statement.setString(2, atendimento.getPergunta());
        statement.setString(3, atendimento.getResposta());
        statement.execute(); //Executando o comando SQL

        //Fechar a conexão com o banco de dados
        connection.close();

    }

}
