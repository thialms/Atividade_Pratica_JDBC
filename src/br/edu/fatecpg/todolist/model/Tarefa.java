package br.edu.fatecpg.todolist.model;

public class Tarefa {

    private String nomeTarefa;
    private Boolean statusTarefa;
    private String categoriaTarefa;
    private Integer id;

    public Tarefa(){}

    public Tarefa(String nomeTarefa, Boolean statusTarefa, String categoriaTarefa, Integer id) {
        this.nomeTarefa = nomeTarefa;
        this.statusTarefa = statusTarefa;
        this.categoriaTarefa = categoriaTarefa;
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public Boolean getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(Boolean statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public String getCategoriaTarefa() {
        return categoriaTarefa;
    }

    public void setCategoriaTarefa(String categoriaTarefa) {
        this.categoriaTarefa = categoriaTarefa;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                ", Tarefa: " + nomeTarefa +
                ", status: " + statusTarefa +
                ", categoria: " + categoriaTarefa;
    }
}
