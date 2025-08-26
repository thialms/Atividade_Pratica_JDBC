package br.edu.fatecpg.todolist.view;

import br.edu.fatecpg.todolist.controller.TarefaController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TarefaController tc = new TarefaController();
        Scanner sc = new Scanner(System.in);
        int op=0;
        String[] opcoes = {"1 - Adicionar Tarefa", "2 - Atualizar Tarefa", "3 - Marcar Tarefa como concluida", "4 - Remover Tarefa", "5 - Mostrar Tarefas", "6 - Mostrar Tarefas por categoria"};

        while(op != 7){
            System.out.println("TO DO LIST");
            System.out.println();

            for (String opc : opcoes){
                System.out.println(opc);
            }

            System.out.println();

            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.print("Digite o nome da Tarefa: ");
                    String nmTarefa = sc.nextLine();
                    sc.nextLine();
                    System.out.print("Digite a categoria da Tarefa: ");
                    String ctgTarefa = sc.nextLine();

                    System.out.println(tc.insertTarefa(nmTarefa, ctgTarefa));
                    break;
                case 2:
                    System.out.print("Digite o ID da Tarefa que você deseja alterar: ");
                    Integer idTarefaAlterar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Digite o novo nome da Tarefa: ");
                    String novoNomeTarefa = sc.nextLine();
                    System.out.print("Digite a nova categoria da Tarefa: ");
                    String novaCtgTarefa = sc.nextLine();

                    System.out.println(tc.updateTarefa(idTarefaAlterar, novoNomeTarefa, false, novaCtgTarefa));
                    break;
                case 3:
                    System.out.println("Digite o id da Tarefa que você concluiu: ");
                    Integer idConcluido = sc.nextInt();

                    System.out.println(tc.updateStatusTarefa(idConcluido));
                    break;
                case 4:
                    System.out.print("Digite o id da Tarefa que vocẽ ira deletar: ");
                    Integer idTarefaDelete = sc.nextInt();

                    System.out.println(tc.deleteTarefa(idTarefaDelete));
                    break;
                case 5:
                    System.out.println(tc.selectTarefa());
                    break;
                case 6:
                    System.out.print("Digite a categoria: ");
                    String ctgTarefaSearch = sc.next();

                    System.out.println(tc.selectTarefaPorCategoria(ctgTarefaSearch));
                    break;
            }
        }

        sc.close();

    }
}
