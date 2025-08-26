package br.edu.fatecpg.todolist.controller;

import br.edu.fatecpg.todolist.model.Banco;
import br.edu.fatecpg.todolist.model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaController {

    public String insertTarefa(String nomeTarefa, String categoriaTarefa){

        String query = "INSERT INTO tb_tarefa(nm_tarefa, status_tarefa, nm_categoria) VALUES(?, ?, ?)";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, nomeTarefa);
            stmt.setBoolean(2, false);
            stmt.setString(3, categoriaTarefa);

            stmt.execute();
            return "Gravado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String selectTarefa(){

        List<Tarefa> tarefas = new ArrayList<>();

        String query = "SELECT * FROM tb_tarefa";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                tarefas.add(new Tarefa(rs.getString("nm_tarefa"), rs.getBoolean("status_tarefa"), rs.getString("nm_categoria"), rs.getInt("id_tarefa")));
            }

            StringBuilder sb = new StringBuilder();
            for (Tarefa tarefa : tarefas) {
                sb.append(tarefa.toString());
                sb.append("\n");
            }

            return sb.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateTarefa(Integer idTarefa, String novoNomeTarefa,Boolean novoStatus, String novaCategoriaTarefa){

        String query = "UPDATE tb_tarefa SET nm_tarefa = ?, status_tarefa = ?, nm_categoria = ? WHERE id_tarefa = ?";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(4, idTarefa);
            stmt.setString(1, novoNomeTarefa);
            stmt.setBoolean(2, novoStatus);
            stmt.setString(3, novaCategoriaTarefa);

            stmt.execute();
            return "Atualizado com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String updateStatusTarefa(Integer idTarefa){

        String query = "UPDATE tb_tarefa SET status_tarefa = true WHERE id_tarefa = ?";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idTarefa);

            stmt.execute();
            return "Parabens por ter concluido esta tarefa!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteTarefa(Integer idTarefa){

        String query = "DELETE FROM tb_tarefa WHERE id_tarefa = ?";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setInt(1, idTarefa);

            stmt.execute();
            return "Removido com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String selectTarefaPorCategoria(String ctgTarefa){

        List<Tarefa> tarefas = new ArrayList<>();

        String query = "SELECT * FROM tb_tarefa WHERE nm_categoria = ?";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, ctgTarefa);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                tarefas.add(new Tarefa(rs.getString("nm_tarefa"), rs.getBoolean("status_tarefa"), rs.getString("nm_categoria"), rs.getInt("id_tarefa")));
            }

            StringBuilder sb = new StringBuilder();
            for (Tarefa tarefa : tarefas) {
                sb.append(tarefa.toString());
                sb.append("\n");
            }

            return sb.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
